/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetorestaurante;

import java.time.LocalDate;

/**
 *
 * @author victo
 */
public class Pedido {
    public int id;
    public Cliente cliente;
    public int numeroDePessoas;
    public String horaEntrada;
    public String horaSaida;
    public String dataEntrada;
    public String dataSaida;
    public boolean statusPedido;// F -não atendido T -Atendido
    public int mesa;

    
    
    public Pedido(Cliente cliente, int numeroDePessoas, int id){
        this.cliente = cliente;
        this.numeroDePessoas = numeroDePessoas;
        this.id = id;
        this.statusPedido = false;
        this.mesa = 0;
    }
    
    public void AssociarData(int idMesa){
        this.mesa = idMesa;
        this.statusPedido = true;
    }
    
    public void AssociarMesa(int idMesa){
        this.mesa = idMesa;
        this.statusPedido = true;
    }
    
}