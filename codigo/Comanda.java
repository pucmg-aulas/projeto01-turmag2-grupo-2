/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

/**
 *
 * @author victo
 */
import java.util.ArrayList;

public class Comanda {
    private ArrayList<ItemCardapio> itensComanda;

    public Comanda() {
        this.itensComanda = new ArrayList<>();
    }

    /**
     * Adiciona um item à comanda.
     * 
     * @param item O item a ser adicionado.
     */
    public void adicionarItem(ItemCardapio item) {
        itensComanda.add(item);
    }

    /**
     * Remove um item da comanda pelo ID.
     * 
     * @param id O ID do item a ser removido.
     * @return true se o item foi removido, false se o item não foi encontrado.
     */
    public boolean removerItem(int id) {
        for (ItemCardapio item : itensComanda) {
            if (item.getId() == id) {
                itensComanda.remove(item);
                return true;
            }
        }
        return false; // Item não encontrado
    }

    /**
     * Retorna um item da comanda pelo ID.
     * 
     * @param id O ID do item a ser retornado.
     * @return O item da comanda, ou null se o item não foi encontrado.
     */
    public ItemCardapio obterItem(int id) {
        for (ItemCardapio item : itensComanda) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item não encontrado
    }

    /**
     * Lista todos os itens da comanda.
     */
    public void listarItens() {
        for (ItemCardapio item : itensComanda) {
            System.out.println(item);
        }
    }

    /**
     * Calcula o total da comanda.
     * 
     * @return O valor total dos itens da comanda.
     */
    public double calcularTotal() { //calcula o valor total com os 10% inclusos
        double total = 0;
        for (ItemCardapio item : itensComanda) {
            total += item.getPreco();
        }
        total += total * 0.10;
        return total;
    }
}
