/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author Beeker
 */
public abstract class Persona 
{
    private String tipo_documento;
    private String documento;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String direccion;
    private String telefono;

    // Constructor con los 7 atributos requeridos
    public Persona(String tipo_documento, String documento, String nombres, String apellido_paterno, String apellido_materno, String direccion, String telefono) 
    {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // === GETTERS Y SETTERS ===
    public String getTipo_documento() 
    {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) 
    {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() 
    {
        return documento;
    }

    public void setDocumento(String documento) 
    {
        this.documento = documento;
    }

    public String getNombres() 
    {
        return nombres;
    }

    public void setNombres(String nombres) 
    {
        this.nombres = nombres;
    }

    public String getApellido_paterno() 
    {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) 
    {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() 
    {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) 
    {
        this.apellido_materno = apellido_materno;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }
}
