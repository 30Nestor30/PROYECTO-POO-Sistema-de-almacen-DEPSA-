/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author Beeker 
 */
//clase hija de Persona
public class Cliente extends Persona 
{
    private boolean tienePedidoActivo;

    // El constructor ahora recibe los 7 parametros de Persona
    public Cliente(String tipo_documento, String documento, String nombres, String apellido_paterno,
            String apellido_materno, String direccion, String telefono) 
    {
        // Se envian los 7 parametros obligatorios a la clase madre
        super(tipo_documento, documento, nombres, apellido_paterno, apellido_materno, direccion, telefono);
        this.tienePedidoActivo = false;
    }

    public boolean isTienePedidoActivo() 
    {
        return tienePedidoActivo;
    }

    public void setTienePedidoActivo(boolean tienePedidoActivo) 
    {
        this.tienePedidoActivo = tienePedidoActivo;
    }
}
