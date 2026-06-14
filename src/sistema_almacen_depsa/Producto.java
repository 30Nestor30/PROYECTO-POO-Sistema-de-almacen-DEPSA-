/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author NESTOR
 */
public class Producto 
{
     private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor
    public Producto(String codigo, String nombre, double precio, int stock, String categoria) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        // Llamamos a los Setters para que los datos pasen por el filtro obligatoriamente.
        setPrecio(precio);
        setStock(stock);
        this.categoria = categoria;
    }

    // === GETTERS Y SETTERS COMPLETOS CON FILTROS (Bombas) ===
    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public double getPrecio() 
    {
        return precio;
    }

    // FILTRO DE SEGURIDAD PARA EL PRECIO (REQ-003)
    public void setPrecio(double precio) 
    {
        if (precio > 0) 
        {
            this.precio = precio;
        } 
        else 
        {
            throw new IllegalArgumentException("ERROR: El precio debe ser mayor a cero. Valor recibido: " + precio);
        }
    }

    public int getStock() 
    {
        return stock;
    }

    // FILTRO DE SEGURIDAD PARA EL STOCK (REQ-004)
    public void setStock(int stock) 
    {
        if (stock >= 0) 
        {
            this.stock = stock;
        } 
        else 
        {
            throw new IllegalArgumentException("ERROR: El stock no puede ser negativo. Valor recibido: " + stock);
        }
    }

    public String getCategoria() 
    {
        return categoria;
    }

    public void setCategoria(String categoria) 
    {
        this.categoria = categoria;
    }
}


