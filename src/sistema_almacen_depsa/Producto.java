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
    private String marca;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor
    public Producto(String codigo, String nombre, String marca , double precio, int stock, String categoria) 
    {
        this.codigo = codigo;
        
        // Usamos los Setters para activar tus escudos de seguridad
        setNombre(nombre); 
        this.marca = marca;
        setPrecio(precio); // Escudo REQ-003
        setStock(stock);   // Escudo REQ-004
        
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

    // FILTRO DE SEGURIDAD PARA EL NOMBRE (REQ-002)
    public void setNombre(String nombre) 
    {
        if (nombre == null || nombre.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("ERROR: El nombre del producto es obligatorio.");
        }
        this.nombre = nombre;
    }
    
    public String getMarca()
    {
        return marca;
    }
    
    // Y su Setter
    public void setMarca(String marca)
    {
        this.marca = marca;
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


