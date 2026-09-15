/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedfasts5;

/**
 * Clase que modela un pedido para entregar.
 * @author Francisco
 */
public class Pedido {
    
    private final int id;
    private final String direccionEntrega;
    private EstadoPedido estado;
    
    /**
     * 
     * @param id Identificador unico de pedido
     * @param direccionEntrega Direccion física a la cual debe ser entregado el pedido.
     * 
     * Se inicializa el estado del pedido como PENDIENTE.
     */

    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }


    public int getId() {
        return id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public synchronized EstadoPedido getEstado() {
        return estado;
    }
    
    public synchronized void setEstado(EstadoPedido nuevoEstado){
        this.estado = nuevoEstado;
    }
    
    /**
     * 
     * @return Retorna informacion ordenada del pedido.
     */
    @Override
    public String toString(){
        return "Pedido #" + id + "Destino: " + direccionEntrega + " Estado: " + estado;
    }
    
    
    
}
