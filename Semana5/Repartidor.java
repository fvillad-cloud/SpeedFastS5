/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedfasts5;


/**
 * Clase que representa al trabajador que procesa de forma concurrente los pedidos desde la zona de carga.
 * @author Francisco
 */
public class Repartidor implements Runnable {
    
    public final String nombre;
    public final ZonaDeCarga carga;

    public Repartidor(String nombre, ZonaDeCarga carga) {
        this.nombre = nombre;
        this.carga = carga;
    }

    /*
     Ciclo continuo para extraer pedidos de la zona de carga.
    */
    @Override
    public void run() {
        while(true){
            Pedido pedido = carga.retirarPedido();
            
            if(pedido == null){
                System.out.println("[Zona de Carga Vacia]");
                break;
            }
            System.out.println("[Repartidor - "+nombre+"] Retirando pedido #"+pedido.getId());
            
            pedido.setEstado(EstadoPedido.EN_REPARTO);
            
            System.out.println("[Repartidor - "+nombre+"] Estado: "+pedido.getEstado());
            
            
            //Simula el tiempo de entrega
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            
            System.out.println("[Repartidor - "+nombre+"] Entregando pedido #"+pedido.getId());
            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("[Repartidor - "+nombre+"] Estado: "+pedido.getEstado());
            
        }
    }
}
