/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_almacen_depsa;

/**
 *
 * @author HP
 */
// Importamos la herramienta ArrayList para manejar listas de datos
import java.util.ArrayList;

public class Pedido 
{
    private String idPedido;
    private String estado; 
    private Cliente cliente;   
    private Vendedor vendedor; 
    
    // === COLECCIONES (Semana 5) Y COMPOSICION (Semana 11) ===
    // Un pedido esta compuesto por una lista de muchos detalles
    private ArrayList<DetallePedido> listaDetalles; 

    // Constructor
    public Pedido(String idPedido, Cliente cliente, Vendedor vendedor) 
    {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.estado = "Pendiente"; 
        
        // Inicializamos la lista vacia para que este lista para recibir productos
        this.listaDetalles = new ArrayList<>();
    }
    
    // === METODO PARA AGREGAR PRODUCTOS AL PEDIDO ===
    public void agregarDetalle(DetallePedido nuevoDetalle)
    {
        this.listaDetalles.add(nuevoDetalle);
    }
    
    // === METODO PARA CALCULAR EL TOTAL DEL PEDIDO ===
    public double calcularTotal()
    {
        double total = 0;
        // Recorremos la lista sumando todos los subtotales
        for (DetallePedido detalle : listaDetalles) 
        {
            total = total + detalle.getSubtotal();
        }
        return total;
    }

    // === GETTERS Y SETTERS NORMALES ===
    public String getIdPedido() 
    {
        return idPedido;
    }

    public void setIdPedido(String idPedido) 
    {
        this.idPedido = idPedido;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() 
    {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) 
    {
        this.vendedor = vendedor;
    }

    public ArrayList<DetallePedido> getListaDetalles() 
    {
        return listaDetalles;
    }
}