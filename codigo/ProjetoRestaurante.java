/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetorestaurante;

import java.util.Scanner;

/**
import java.util.Scanner;

/**
 *
 * @author victo
 */
public class ProjetoRestaurante {

    Cliente cliente;
    Pedido pedido;
    static Mesa[] mesas = new Mesa[10];
    static FilaDePedidos fila = new FilaDePedidos();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuantificarMesas();

        System.out.println("      *Bem Vindo!*      ");
        menu();

    }

    public static void menu() {

        Scanner input = new Scanner(System.in);

        int escolha = 0;

        while (escolha != 7) {

            System.out.println("**********Menu**********");
            System.out.println("*1- Ver Mesas          *");
            System.out.println("*2- Ver Fila           *");
            System.out.println("*3- Fazer Reserva      *");
            System.out.println("*4- Cancelar Reserva   *");
            System.out.println("*5- Atender Pedido     *");
            System.out.println("*6- Liberar Mesa       *");
            System.out.println("*7- Sair               *");
            System.out.println("************************");

            escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("1- Ver Mesas");
                    // codigo p/ ver as mesas
                    verMesas();
                    break;
                case 2:
                    System.out.println("- Fila -");
                    fila.listarPedidos();
                    System.out.println("");
                    System.out.println("************************");

                    break;
                case 3:
                    System.out.println("3- Resrvar Mesa");
                    // Variables
                    reservar();

                    /* fila.adicionarPedidoAFila(new Pedido(new Cliente("fulano", "031-se liga"), "Não atendido", 1, 0, 0, 0, 0,fila.filaDeEspera.size()));
                     fila.adicionarPedidoAFila(new Pedido(new Cliente("ciclano", "031-se liga"), "Não atendido", 1, 0, 0, 0, 0,fila.filaDeEspera.size())); */
                    break;

                case 4:
                    System.out.println("4- Cancelar Reserva");
                    remover();

                    break;

                case 5:
                    //Implementar Lógica p/ mudar o estado de uma mesa p/ ocupado e remover o pedido que foi atendido
                    System.out.println("5- Atender Pedido");
                    AtenderPedido();

                    break;
                    
                case 6:
                    System.out.println("6- Liberar Mesa");
                    
                    System.out.println("Qual mesa deseja desocupar?");
                    int mesaALiberar = input.nextInt();
                    
                    LiberarMesa(mesaALiberar);
                    
                    break;

                case 7:
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("Escolha uma opçao de 1 a 7!");
                    break;
            }

        }

        System.out.println("Volte sempre!");

    }

    //funcão que inicializa as mesas de acordo com sua quantidade
    public static void QuantificarMesas() {
        int id;
        int capacidade;
        boolean disponibilidade = true;
        for (int i = 0; i < 10; i++) {
            capacidade = 4;
            if (i > 3) {
                capacidade = 6;
            }
            if (i > 7) {
                capacidade = 8;
            }
            mesas[i] = new Mesa(i + 1, capacidade, true);
        }
    }

    public static void verMesas() {
        System.out.println("**********Mesas**********");
        /* for (Mesa mesa : mesas) {
            System.out.println("ID: " + mesa.idMesa + ", Capacidade: " + mesa.capacidade + ", Disponibilidade: " + (mesa.disponibilidade ? "Disponivel" : "Indisponível"));
        }*/

        for (int i = 0; i < mesas.length; i++) {
            System.out.println("Mesa " + mesas[i].idMesa + "  Capacidade: " + mesas[i].capacidade + (mesas[i].disponibilidade ? "  Disponivel" : "  Ocupado"));
        }

        System.out.println("*************************");
    }

    public static void reservar() {
        int id;
        Cliente cliente;
        int numeroDePessoas;
        String horaEntrada;
        String horaSaida;
        String dataEntrada;
        String dataSaida;

        // Method to read input
        Scanner scanner = new Scanner(System.in);

        // Assuming Cliente has its own method to read input
        System.out.println("Nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Telefone do cliente:");
        String telefone = scanner.nextLine();

        cliente = new Cliente(nome, telefone);

        System.out.println("Numero de pessoas:");
        numeroDePessoas = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Hora de entrada (HH:mm):");
        System.out.print("Hora:");
        int horaIn = scanner.nextInt();
        System.out.print("Minuto:");
        int minutoIn = scanner.nextInt();

        horaEntrada = new Hora().validarHora(horaIn, minutoIn);

        System.out.println("Hora de saída (HH:mm):");
        System.out.print("Hora:");
        int horaOut = scanner.nextInt();
        System.out.print("Minuto:");
        int minutoOut = scanner.nextInt();

        horaSaida = new Hora().validarHora(horaOut, minutoOut);

        System.out.println("Dia de entrada:");

        System.out.print("Dia:");
        int diaIn = scanner.nextInt();
        System.out.print("Mes:");
        int mesIn = scanner.nextInt();
        System.out.print("Ano:");
        int anoIn = scanner.nextInt();

        Data dataIn = new Data(diaIn, mesIn, anoIn);
        dataEntrada = dataIn.dataFormatada();

        System.out.println("Dia de saida:");

        System.out.print("Dia:");
        int diaOut = scanner.nextInt();
        System.out.print("Mes:");
        int mesOut = scanner.nextInt();
        System.out.print("Ano:");
        int anoOut = scanner.nextInt();

        Data dataOut = new Data(diaOut, mesOut, anoOut);
        dataSaida = dataOut.dataFormatada();

        fila.adicionarPedidoAFila(new Pedido(cliente, numeroDePessoas, fila.filaDeEspera.size()));
    }

    private static void remover() {

        Scanner input = new Scanner(System.in);

        System.out.println("Qual o Id do pedido que deseja cancelar?");
        int idescolha = input.nextInt();
        fila.removerPedidoDaFila(idescolha);
    }

    private static void AtenderPedido() {
        int capacidade;
        for (int i = 0; i < mesas.length; i++) {
            capacidade = mesas[i].capacidade;
            for (int j = 0; j < fila.filaDeEspera.size(); j++) {
                if (fila.filaDeEspera.get(j).numeroDePessoas <= capacidade) {
                    
                    fila.filaDeEspera.get(j).AssociarMesa(mesas[i].idMesa);
                                        
                    System.out.println("O pedido do id " + fila.filaDeEspera.get(j).id + " foi alocado a mesa " + mesas[i].idMesa);
                                       
                    
                    
                    
                    break;
                } else {
                    System.out.println("Não há mesas vazias com capacidade para o pedido " + fila.filaDeEspera.get(j).id  + " ou ele não cabe nesta mesa! (Mesa "+ mesas[i].idMesa+")");
                    break;
                }

            }

        }

    }
    
    private static void LiberarMesa(int mesaALiberar){
        for (int i = 0; i < mesas.length; i++) {
           if(mesas[i].idMesa == mesaALiberar){
               mesas[i].desalocarMesa();
               System.out.println("A mesa "+mesas[i]+" foi desocupada!");
           }
                } 

            

        

    }
}
