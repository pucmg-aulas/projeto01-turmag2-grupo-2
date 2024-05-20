/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

/**
 *
 * @author victo
 */
public class PreencherCardapio {
    public Cardapio preencher() {
        Cardapio cardapio = new Cardapio();
        cardapio.adicionarAoCardapio(new ItemCardapio(1, "Moqueca de Tilápia", 50.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(2, "Falafel Assado", 30.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(3, "Salada Primavera com Macarrão Konjac", 40.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(4, "Escondidinho de Frango", 45.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(5, "Strogonoff", 30.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(6, "Caçarola de Carne com Legumes", 50.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(7, "Água", 5.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(8, "Suco", 8.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(9, "Refrigerante", 7.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(10, "Cerveja", 12.0));
        cardapio.adicionarAoCardapio(new ItemCardapio(11, "Taça de Vinho", 18.0));
        return cardapio;
    }
}
