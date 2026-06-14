/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author HP
 */
public class DetallePedido 
{
    private Producto producto;
    private int cantidad;
    private double subtotal;

    // Constructor
    public DetallePedido(Producto producto, int cantidad) 
    {
        this.producto = producto;
        this.cantidad = cantidad;
        // Calculamos el subtotal automaticamente multiplicando el precio por la cantidad
        this.subtotal = producto.getPrecio() * cantidad;
    }

    // === GETTERS Y SETTERS ===
    public Producto getProducto() 
    {
        return producto;
    }

    public void setProducto(Producto producto) 
    {
        this.producto = producto;
    }

    public int getCantidad() 
    {
        return cantidad;
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
        // Si cambian la cantidad, actualizamos el subtotal
        this.subtotal = this.producto.getPrecio() * cantidad;
    }

    public double getSubtotal() 
    {
        return subtotal;
    }
}