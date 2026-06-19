/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author NESTOR
 */
  public class GestorArchivos 
 {

    // ==============================================================================
    // REQ-GA-01: guardarClientes() - ALMACENAMIENTO DE DATOS (Gestor 1)
    // ¿Qué hace?: Toma los datos de la tabla visual de clientes y, al presionar el botón guardar, 
    //             los guarda en un bloc de notas que se crea una sola vez llamado 'clientes.txt'. 
    //             Ahí se almacenarán todos los clientes ingresados.
    // ==============================================================================
    public static void guardarClientes(javax.swing.JTable tabla) {

        // No usamos 'true' aquí porque queremos que reescriba toda la tabla actualizada
        try (java.io.FileWriter fw = new FileWriter("registro_clientes.txt");
                java.io.BufferedWriter bw = new java.io.BufferedWriter(fw))
        {

            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();

            // Recorremos fila por fila toda la tabla visual
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String tipoDoc = modelo.getValueAt(i, 0).toString();
                String documento = modelo.getValueAt(i, 1).toString();
                String nombres = modelo.getValueAt(i, 2).toString();
                String apePaterno = modelo.getValueAt(i, 3).toString();
                String apeMaterno = modelo.getValueAt(i, 4).toString();
                String direccion = modelo.getValueAt(i, 5).toString();
                String telefono = modelo.getValueAt(i, 6).toString();

                // Unimos todos los datos con el separador |
                String linea = tipoDoc + "|" + documento + "|" + nombres + "|"
                        + apePaterno + "|" + apeMaterno + "|" + direccion + "|" + telefono;

                bw.write(linea);
                bw.newLine();
            }

            // Anotamos en el Log (Caja Negra) que el guardado fue exitoso
            registrarLog("SISTEMA", "Se actualizó el archivo clientes.txt");

        }
        catch (java.io.IOException e) 
        {
            System.out.println("Error al guardar clientes: " + e.getMessage());
            registrarLog("ERROR", "Falló escritura en clientes.txt: " + e.getMessage());
        }
    }
    
    
    // ==============================================================================
  // REQ-GA-02: cargarClientes() - RECUPERACIÓN DE DATOS (Gestor 2)
    // ¿Qué hace?: Abre el block 'clientes.txt'donde estan guardado a los clientes y al iniciar el sistema, lee la información 
    //             y la inyecta automáticamente en la tabla visual del panel de clientes.
    // ==============================================================================
    public static void cargarClientes(javax.swing.JTable tabla)
    {
        
        // Usamos BufferedReader para leer el texto línea por línea de forma rápida
       try (java.io.FileReader fr = new java.io.FileReader("registro_clientes.txt");
             java.io.BufferedReader br = new java.io.BufferedReader(fr)) {
            
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
            String linea;
            
            // Mientras el bloc de notas tenga líneas escritas, seguimos leyendo
            while ((linea = br.readLine()) != null) {
                
                // Cortamos la línea de texto cada vez que encuentre un '|'
                // Nota: En Java se pone "\\|" porque el pipe es un símbolo especial
                String[] datosCliente = linea.split("\\|"); 
                
                // Agregamos esa lista de palabras como una nueva fila en la tabla
                modelo.addRow(datosCliente);
            }
            
        } 
       catch (java.io.FileNotFoundException e)
       {
            // Si da este error es porque el programa es nuevo y aún no se guardó nadie.
            // No hacemos nada, es normal la primera vez.
            System.out.println("El archivo no existe aún. Se creará al guardar por primera vez.");
            
        } 
       catch (java.io.IOException e) 
       {
            System.out.println("Error de lectura: " + e.getMessage());
            registrarLog("ERROR", "No se pudo leer clientes.txt: " + e.getMessage());
        }
    }
    
    
    // ==============================================================================
    // REQ-GA-03: registrarLog() - EL HISTORIAL DEL SISTEMA (gestor 3)
    // ¿Qué gestor es este?: Es el Gestor 3. Su único trabajo es registrar el historial 
    //                       de auditoría de todo lo que pasa en el sistema.
    // ¿Para qué sirve?: Para tener pruebas (una caja negra). Escribe en 'depsa_log.txt' 
    //             quién hizo qué y a qué hora. El usuario no ve nada en pantalla, 
    //             pero el administrador puede leer el bloc de notas para auditar.
    // ==============================================================================

    public static void registrarLog(String operacion, String detalle)
    {

        // El modo 'true' activa el APPEND (no borra lo anterior)
       try (FileWriter fw = new FileWriter("historial_almacen.txt", true);
                BufferedWriter bw = new BufferedWriter(fw))
        {

            // Obtenemos la fecha y hora exacta del sistema
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaHora = ahora.format(formato);

            // Escribimos en el formato exacto que te pidieron
            bw.write("[" + fechaHora + "] " + operacion + " - " + detalle);
            bw.newLine(); // Salto de línea para el siguiente registro

        } 
        catch (IOException e) 
        {
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
    
    // ==============================================================================
    // REQ-001: guardarProductos() - PERSISTENCIA DE DATOS
    // ¿Qué hace?: Lee todas las filas de la tabla visual de productos y las escribe 
    //             una por una en el bloc de notas 'registro_productos.txt' separadas
    //             por el símbolo '|'. Esto asegura que los datos no se borren.
    // ==============================================================================
    public static void guardarProductos(javax.swing.JTable tabla)
    {
        // Abrimos un "canal de escritura" (FileWriter) hacia el archivo de texto.
        // Usamos BufferedWriter para escribir de manera más rápida y eficiente en el disco duro.
        try (java.io.FileWriter fw = new java.io.FileWriter("registro_productos.txt");
             java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) 
        {
            
            // Obtenemos el "molde" (DefaultTableModel) de la tabla visual para poder leer sus celdas
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
            
            // Iniciamos un bucle (for) que va a dar una vuelta por cada fila que exista en la tabla
            for (int i = 0; i < modelo.getRowCount(); i++) {
                
                // Extraemos el texto de cada columna de la fila actual (i)
                // Recuerda: Se cuenta desde cero.
                String codigo = modelo.getValueAt(i, 0).toString();
                String nombre = modelo.getValueAt(i, 1).toString();
                String marca = modelo.getValueAt(i, 2).toString(); // NUEVO: Extraemos la marca de la columna 2
                String precio = modelo.getValueAt(i, 3).toString(); // El precio se movió a la columna 3
                String stock = modelo.getValueAt(i, 4).toString(); // El stock se movió a la columna 4
                String categoria = modelo.getValueAt(i, 5).toString(); // La categoría se movió a la columna 5
                
                // Unimos todos los textos extraídos en una sola oración, separados por un palito "|"
                // NUEVO: Agregamos la marca en el orden correcto dentro de la oración
                bw.write(codigo + "|" + nombre + "|" + marca + "|" + precio + "|" + stock + "|" + categoria);
                
                // Hacemos un "Enter" (salto de línea) en el bloc de notas para que el siguiente producto vaya abajo
                bw.newLine();
            }
        } 
        catch (Exception e) 
        {
            // Si ocurre algún error (ej. disco lleno o archivo bloqueado), lo imprimimos en la consola de abajo
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    
    
    // ==============================================================================
    // REQ-001: cargarProductos() - RECUPERACIÓN DE DATOS
    // ¿Qué hace?: Abre el bloc 'registro_productos.txt' y lee la información línea 
    //             por línea al iniciar el sistema, inyectándola automáticamente en 
    //             la tabla visual del panel de productos.
    // ==============================================================================
    public static void cargarProductos(javax.swing.JTable tabla) 
    {
        // Abrimos un "canal de lectura" (FileReader) para leer el archivo de texto.
        // Usamos BufferedReader para leer línea por línea muy rápido.
        try (java.io.FileReader fr = new java.io.FileReader("registro_productos.txt");
             java.io.BufferedReader br = new java.io.BufferedReader(fr))
        {
            
            // Conectamos con el "molde" de la tabla para poder inyectarle nuevas filas
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
            
            // Creamos una variable vacía para guardar la oración que vamos a leer del bloc de notas
            String linea;
            
            // BUCLE INTELIGENTE: Lee una línea completa del texto y la guarda en la variable 'linea'.
            // Si el resultado no es nulo (es decir, si encontró texto), entra al bucle. Si ya no hay texto, termina.
            while ((linea = br.readLine()) != null) 
            {
                // Cortamos la línea de texto cada vez que encuentre el palito "|"
                // Esto convierte la oración en un arreglo de palabras (0=Código, 1=Nombre, 2=Marca, etc.)
                String[] datos = linea.split("\\|"); 
                
                // Agregamos todo ese arreglo como una nueva fila en la tabla de golpe
                modelo.addRow(datos);
            }
        } 
        catch (Exception e)
        {
            // Si el archivo no existe aún (porque el programa es nuevo y no se ha guardado nada),
            // ignoramos el error silenciosamente. Es normal la primera vez.
        }
    }
}
