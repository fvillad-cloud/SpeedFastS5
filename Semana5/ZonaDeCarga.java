/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedfasts5;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Clase que administra la cola centralizada de pedidos pendientes utilizando colecciones seguras para hilos (BlockingQueue)
 * @author Francisco
 */
public class ZonaDeCarga {
    private final BlockingQueue<Pedido> colaPedidos;

    public ZonaDeCarga() {
        this.colaPedidos = new LinkedBlockingQueue<>();
    }
    
    
    /**
     * Añade un nuevo pedido a la cola mediante .offer.
     * @param p 
     */
    public synchronized void agregarPedido(Pedido p){
       colaPedidos.offer(p);
    }
    
    /**
     * Extrae el siguiente pedido de la cola mediante .poll
     * @return 
     */
    public synchronized Pedido retirarPedido(){
       return colaPedidos.poll();
    }
    
    
    
    
    
}
