/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package speedfasts5;

/**
 * Enumerador que establece el ciclo de vida operativo de un pedido.
 * @author Francisco
 */
public enum EstadoPedido {
    PENDIENTE, //El pedido ha sido creado y cargado en el sistema
    EN_REPARTO, //El pedido fue retirado de la zona de carga y se encuentra en ruta a destino.
    ENTREGADO //El pedido fue entregado con exito.
}
