/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author HP
 */
// === HERENCIA ===
// Al igual que el Cliente, el Vendedor hereda los datos basicos de Persona.
public class Vendedor extends Persona 
{
    private String codigoVendedor;
    private String email;

    // Constructor actualizado con los 7 parametros de Persona + los 2 del vendedor
    public Vendedor(String tipo_documento, String documento, String nombres, String apellido_paterno, String apellido_materno, String direccion, String telefono, String codigoVendedor, String email) 
    {
        super(tipo_documento, documento, nombres, apellido_paterno, apellido_materno, direccion, telefono);
        this.codigoVendedor = codigoVendedor;
        this.email = email;
    }

    public String getCodigoVendedor() 
    {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) 
    {
        this.codigoVendedor = codigoVendedor;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
}
