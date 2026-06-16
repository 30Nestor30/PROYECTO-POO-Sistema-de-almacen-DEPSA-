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
    // REQ-011: guardarClientes() - ALMACENAMIENTO DE DATOS (Gestor 1)
    // ¿Qué hace?: Toma los datos de la tabla visual de clientes y, al presionar el botón guardar, 
    //             los guarda en un bloc de notas que se crea una sola vez llamado 'clientes.txt'. 
    //             Ahí se almacenarán todos los clientes ingresados.
    // ==============================================================================
    public static void guardarClientes(javax.swing.JTable tabla) {

        // No usamos 'true' aquí porque queremos que reescriba toda la tabla actualizada
        try (java.io.FileWriter fw = new java.io.FileWriter("clientes.txt"); java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {

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

        } catch (java.io.IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
            registrarLog("ERROR", "Falló escritura en clientes.txt: " + e.getMessage());
        }
    }
    
    
    // ==============================================================================
  // REQ-012: cargarClientes() - RECUPERACIÓN DE DATOS (Gestor 2)
    // ¿Qué hace?: Abre el block 'clientes.txt'donde estan guardado a los clientes y al iniciar el sistema, lee la información 
    //             y la inyecta automáticamente en la tabla visual del panel de clientes.
    // ==============================================================================
    public static void cargarClientes(javax.swing.JTable tabla)
    {
        
        // Usamos BufferedReader para leer el texto línea por línea de forma rápida
        try (java.io.FileReader fr = new java.io.FileReader("clientes.txt");
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
            
        } catch (java.io.FileNotFoundException e) {
            // Si da este error es porque el programa es nuevo y aún no se guardó nadie.
            // No hacemos nada, es normal la primera vez.
            System.out.println("El archivo no existe aún. Se creará al guardar por primera vez.");
            
        } catch (java.io.IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
            registrarLog("ERROR", "No se pudo leer clientes.txt: " + e.getMessage());
        }
    }
    
    
    // ==============================================================================
    // REQ-013: registrarLog() - EL HISTORIAL DEL SISTEMA (gestor 3)
    // ¿Qué gestor es este?: Es el Gestor 3. Su único trabajo es registrar el historial 
    //                       de auditoría de todo lo que pasa en el sistema.
    // ¿Para qué sirve?: Para tener pruebas (una caja negra). Escribe en 'depsa_log.txt' 
    //             quién hizo qué y a qué hora. El usuario no ve nada en pantalla, 
    //             pero el administrador puede leer el bloc de notas para auditar.
    // ==============================================================================

    public static void registrarLog(String operacion, String detalle)
    {

        // El modo 'true' activa el APPEND (no borra lo anterior)
        try (FileWriter fw = new FileWriter("depsa_log.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {

            // Obtenemos la fecha y hora exacta del sistema
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaHora = ahora.format(formato);

            // Escribimos en el formato exacto que te pidieron
            bw.write("[" + fechaHora + "] " + operacion + " - " + detalle);
            bw.newLine(); // Salto de línea para el siguiente registro

        } catch (IOException e) {
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }
}
