/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

/**
 *
 * @author victo
 */
import java.util.*;
public class Mesa {
    int idMesa;
    int capacidade;
    boolean disponibilidade;
    public static Pedido pedido;
    static Comanda comanda = new Comanda();
    
    public Mesa(int idMesa, int capacidade, boolean disponibilidade){
        this.idMesa = idMesa;
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
    }

    public void alocarMesa(int idPedido){
        this.disponibilidade = false;
    }
    public void desalocarMesa(){
        this.disponibilidade = true;
        this.pedido = null;
    }
    public boolean verificarCapacidade(Pedido pedido){
        int pessoas = pedido.numeroDePessoas;
        if(this.capacidade >= pessoas){
            return true;
        }
        return false;
    }
   
}