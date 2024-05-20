/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author victo
 */
public class Pedido {

    public int id;
    public Cliente cliente;
    public int numeroDePessoas;
    public Comanda comanda;
    public String saida;
    public String entrada;

    public boolean statusPedido;// F -não atendido T -Atendido
    public int mesa;

    public Pedido(Cliente cliente, int numeroDePessoas, int id) {
        this.cliente = cliente;
        this.numeroDePessoas = numeroDePessoas;
        this.id = id;
        this.statusPedido = false;
        this.mesa = 0;
        this.comanda = new Comanda();
    }

    public void AssociarData() {
        
        this.statusPedido = true;
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.entrada = sdf.format(cal.getTime());
    }
    
    public void RegistrarSaida() {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        this.saida = sdf.format(cal.getTime());
    }
    
   public double valorDividido(Comanda comanda){ //calcula a conta já com os 10% e dividi pelo numero de pessoas da mesa.
    Double valorTotal = comanda.calcularTotal();
    return valorTotal / this.numeroDePessoas;
    

   }

    public void AssociarMesa(int idMesa) {
        this.mesa = idMesa;
        this.statusPedido = true;
    }

}
