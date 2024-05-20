package sistemarestaurante;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author victo
 */
public class FilaDePedidos {

    ArrayList<Pedido> filaDeEspera;

    public FilaDePedidos() {
        filaDeEspera = new ArrayList<Pedido>();

    }

    public void adicionarPedidoAFila(Pedido pedido) {
        filaDeEspera.add(pedido);
    }

    public void removerPedidoDaFila(int id) {
        filaDeEspera.remove(id);
    }

    public Pedido consultarProximoCliente(int capacidade) {
        for (Pedido pedido : filaDeEspera) {
            if (pedido != null) {
                if (pedido.numeroDePessoas <= capacidade) {
                    return pedido;
                }
            }
        }

        return null;
    }
    
    public Pedido retornaPedido(int num){
        Pedido pedido = filaDeEspera.get(num);
        return pedido;
                }
    

    public void listarPedidos() {
        for (Pedido pedido : filaDeEspera) {
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Cliente: " + pedido.cliente.nome + " ID do pedido: " + pedido.id + " Num de Pessoas: " + pedido.numeroDePessoas + " Tel. P/ contato: " + pedido.cliente.telefone);
            System.out.println("----------------------------------------------------------------------------------------------");
        }

    }
    public void listarHistorico() {
        for (Pedido pedido : filaDeEspera) {
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Cliente: " + pedido.cliente.nome + " ID do pedido: " + pedido.id + " Num de Pessoas: " + pedido.numeroDePessoas + " Tel. P/ contato: " + pedido.cliente.telefone);
            System.out.println("Entrada: " + pedido.entrada + " Saida: " + pedido.saida );
            System.out.println("----------------------------------------------------------------------------------------------");
        }

    }
    
    

}
