/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemarestaurante;

import java.util.Scanner;

/**
 *
 * @author victo
 */
public class SistemaRestaurante {

    static ItemCardapio Moqueca = new ItemCardapio(1, "Moqueca de Tilápia", 50.0);
    static ItemCardapio Falafel = new ItemCardapio(2, "Falafel Assado", 30.0);
    static ItemCardapio Salada = new ItemCardapio(3, "Salada Primavera com Macarrão Konjac", 40.0);
    static ItemCardapio Escondidinho = new ItemCardapio(4, "Escondidinho de Frango", 45.0);
    static ItemCardapio Strogonoff = new ItemCardapio(5, "Strogonoff", 30.0);
    static ItemCardapio Caçarola = new ItemCardapio(6, "Caçarola de Carne com Legumes", 50.0);
    static ItemCardapio Agua = new ItemCardapio(7, "Água", 5.0);
    static ItemCardapio Suco = new ItemCardapio(8, "Suco", 8.0);
    static ItemCardapio Refrigerante = new ItemCardapio(9, "Refrigerante", 7.0);
    static ItemCardapio Cerveja = new ItemCardapio(10, "Cerveja", 12.0);
    static ItemCardapio Vinho = new ItemCardapio(11, "Taça de Vinho", 18.0);




    Cliente cliente;
    Pedido pedido;
    static Scanner sc = new Scanner(System.in);
  
    static FilaDePedidos historico = new FilaDePedidos();
    static Mesa[] mesas = new Mesa[10];
    static FilaDePedidos fila = new FilaDePedidos();
   
    
        static PreencherCardapio preenchimento = new PreencherCardapio();
         static Cardapio cardapio = preenchimento.preencher(); // Popula o cardapio
    



    
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

        while (escolha != 9) {

            System.out.println("***************Menu***************");
            System.out.println("*1- Ver Mesas                    *");
            System.out.println("*2- Ver Fila                     *");
            System.out.println("*3- Fazer Reserva                *");
            System.out.println("*4- Cancelar Reserva             *");
            System.out.println("*5- Atender Pedido               *");
            System.out.println("*6- Fechar comanda e Liberar Mesa*");
            System.out.println("*7- Histórico de Pedidos         *");
            System.out.println("*8- Setor de Serviços            *");
            System.out.println("*9- Sair                         *");
            System.out.println("**********************************");

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
                    System.out.println("3- Reservar Mesa");
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
                    
                    verMesas();

                    System.out.println("Qual mesa deseja desocupar?");
                    int mesaALiberar = input.nextInt();

                    LiberarMesa(mesaALiberar);

                    break;

                case 7:
                    System.out.println("- Histórico -");
                    historico.listarPedidos();
                    System.out.println("");
                    System.out.println("************************");
                    break;

                case 8:
    int escolhaMenu = 0;

    while (escolhaMenu != 6) {
        System.out.println("**********Menu***********");
        System.out.println("*1- Ver Mesas           *");
        System.out.println("*2- Ver Cardapio        *");
        System.out.println("*3- Fazer Pedido        *");
        System.out.println("*4- Cancelar Pedido     *");
        System.out.println("*5- ver comanda         *");
        System.out.println("*6- Sair                *");
        System.out.println("*************************");

        escolhaMenu = input.nextInt();

        switch (escolhaMenu) {
            case 1:
                // Code to view tables
                verMesas();
                break;
            case 2:
                // Code to view menu
                cardapio.listarCardapio();
                break;
            case 3:
                // Code to make an order
                fazerPedido(); //FEITO
                break;
            case 4:
                // Code to cancel an order
                cancelarPedido(); // falta fazer
                break;
            case 5:
                // Exiting the service sector menu
                verComanda();
                
                
                break;
            case 6:
                // Exiting the service sector menu
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice! Please choose an option from 1 to 5.");
                break;
        }
    }
    break;
                case 9:
                    System.out.println("Volte sempre!");
                    break;

                default:
                    System.out.println("Escolha uma opçao de 1 a 7!");
                    break;
            }

        }

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
            if (mesas[i].disponibilidade == false) {
                System.out.println("Mesa " + mesas[i].idMesa + " ocupada por " + mesas[i].pedido.cliente.nome);

            }
        }

        System.out.println("*************************");
    }

    public static void reservar() {
        int id;
        Cliente cliente;
        int numeroDePessoas;

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
                    fila.filaDeEspera.get(j).AssociarData();
                    mesas[i].alocarMesa(fila.filaDeEspera.get(j).id);
                    System.out.println("O pedido do id " + fila.filaDeEspera.get(j).id + " foi alocado a mesa " + mesas[i].idMesa);
                    Mesa.pedido = fila.retornaPedido(j);
                    fila.filaDeEspera.remove(j);
                    break;
                }

            }

        }

    }

    private static void LiberarMesa(int mesaALiberar) {
        
        double APagar =  mesas[mesaALiberar].comanda.calcularTotal();
        
        System.out.println("Total a Pagar: R$"+ APagar +".");
        
        mesas[mesaALiberar].pedido.RegistrarSaida();
        
        historico.filaDeEspera.add(mesas[mesaALiberar].pedido) ;
        
        mesas[mesaALiberar].desalocarMesa();
        
        System.out.println("A mesa " + mesas[mesaALiberar].idMesa + " foi desocupada!");
        

    }
    
    
    public static void fazerPedido(){
        
        verMesas();
        System.out.println("Qual mesa fará o pedido?");
        int numcom =sc.nextInt();
                
        while (true) {
        System.out.println("O que deseja pedir: ");
        cardapio.listarCardapio();
        
        System.out.println("\nDigite o numero do prato ou bebida que deseja ('0' PARA SAIR): ");
        int item = sc.nextInt();
            
            switch (item) {
                case 0:
                    System.out.println("Saindo...");
                    return; 
                case 1:
                    mesas[numcom].comanda.adicionarItem(Moqueca);
                    break;
                case 2:
                    mesas[numcom].comanda.adicionarItem(Falafel);
                    break;
                case 3:
                    mesas[numcom].comanda.adicionarItem(Salada);
                    break;
                case 4:
                    mesas[numcom].comanda.adicionarItem(Escondidinho);
                    break;
                case 5:
                    mesas[numcom].comanda.adicionarItem(Strogonoff);
                    break;
                case 6:
                    mesas[numcom].comanda.adicionarItem(Caçarola);
                    break;
                case 7:
                    mesas[numcom].comanda.adicionarItem(Agua);
                    break;
                case 8:
                    mesas[numcom].comanda.adicionarItem(Suco);
                    break;
                case 9:
                    mesas[numcom].comanda.adicionarItem(Refrigerante);
                    break;
                case 10:
                    mesas[numcom].comanda.adicionarItem(Cerveja);
                    break;
                case 11:
                    mesas[numcom].comanda.adicionarItem(Vinho);
                    break;
                default:
                    System.out.println("Digite um valor de 0 a 11 ");
                    break;
            }
        }
        
        
    

    

    }
    public static void cancelarPedido(){
        verMesas();
        System.out.println("Qual mesa quer cancelar?");
        int numcom =sc.nextInt();
        
        System.out.println("O que deseja cancelar: ");
        mesas[numcom].comanda.listarItens();
        
        System.out.println("\nDigite o numero do prato ou bebida que deseja cancelar: ");
        int item = sc.nextInt();
        
        mesas[numcom].comanda.removerItem(item);
        
        }
    
    public static void verComanda(){
        verMesas();
        System.out.println("Qual comanda quer ver?");
        int numcom =sc.nextInt();
        System.out.println("Itens da comanda:");
        mesas[numcom].comanda.listarItens();
    }
}
