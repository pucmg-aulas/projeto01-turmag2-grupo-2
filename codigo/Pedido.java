/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

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
    private int mesa;

    
    
    public Pedido(Cliente cliente, int numeroDePessoas, String horaEntrada, String horaSaida, String dataEntrada, String dataSaida, int id){
        this.cliente = cliente;
        this.numeroDePessoas = numeroDePessoas;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.id = id;
        this.mesa = 0;
    }
    
}
