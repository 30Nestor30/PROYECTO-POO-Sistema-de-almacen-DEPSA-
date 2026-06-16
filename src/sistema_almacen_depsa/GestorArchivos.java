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
public class GestorArchivos {

   // ==============================================================================
   // REQ-013: registrarLog() - EL HISTORIAL DEL SISTEMA (LA CAJA NEGRA)
   // ¿Qué gestor es este?: Es el Gestor 3. Su único trabajo es registrar el historial 
   //                       de auditoría de todo lo que pasa en el sistema.
   // ¿Para qué sirve?: Para tener pruebas (una caja negra). Escribe en 'depsa_log.txt' 
   //             quién hizo qué y a qué hora. El usuario no ve nada en pantalla, 
   //             pero el administrador puede leer el bloc de notas para auditar.
   // ==============================================================================
    public static void registrarLog(String operacion, String detalle) {
        
        // El modo 'true' activa el APPEND (no borra lo anterior)
        try (FileWriter fw = new FileWriter("depsa_log.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
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
