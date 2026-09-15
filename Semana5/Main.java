/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package speedfasts5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal encargada de orquestar y poner en marcha toda la simulacion. 
 * @author Francisco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("[Zona de Carga inicializada]");
        
        ZonaDeCarga carga = new ZonaDeCarga();
        
        //Se cargan 5 pedidos
        carga.agregarPedido(new Pedido(1,"Colo Colo 671"));
        carga.agregarPedido(new Pedido(2,"Los Carreras 987"));
        carga.agregarPedido(new Pedido(3,"Lautaro 258"));
        carga.agregarPedido(new Pedido(4,"O'higgins 376"));
        carga.agregarPedido(new Pedido(5,"Juan de Dios Rivera 2064"));
        
        //Se crean 3 hilos que simulan repartidores.
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        executor.submit(new Repartidor("Juan Carlos", carga));
        executor.submit(new Repartidor("Susana Alarcon", carga));
        executor.submit(new Repartidor("Cristian Soto", carga));
        
        executor.shutdown();
        
         try {
            boolean finalizaron = executor.awaitTermination(40, TimeUnit.SECONDS);
            if (finalizaron) {
                System.out.println("Todos los pedidos han sido entregados correctamente");
            }else{
                System.out.println("Se agotó el tiempo de espera");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
    
}
