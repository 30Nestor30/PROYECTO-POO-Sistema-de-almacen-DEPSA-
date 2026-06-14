/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author HP
 */
public class Validaciones {
    
    // Método para validar que el teléfono tenga 9 dígitos
    public static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{9}");
    }

    // Método para validar que un campo de texto no esté vacío
    public static boolean noEsVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
}
