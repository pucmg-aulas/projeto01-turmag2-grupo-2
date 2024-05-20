package sistemarestaurante;

import java.util.ArrayList;

/**
 * Classe que representa um cardápio.
 * Contém uma lista de itens do cardápio e métodos para manipular essa lista.
 * 
 * @author victo
 */
public class Cardapio {
    private static ArrayList<ItemCardapio> itensCardapio;

    public Cardapio() {
        this.itensCardapio = new ArrayList<>();
    }

    /**
     * Adiciona um item ao cardápio.
     * 
     * @param item O item a ser adicionado.
     */
    public static void adicionarAoCardapio(ItemCardapio item) {
        itensCardapio.add(item);
    }

    /**
     * Remove um item do cardápio pelo ID.
     * 
     * @param id O ID do item a ser removido.
     * @return true se o item foi removido, false se o item não foi encontrado.
     */
    public boolean removerDoCardapio(int id) {
        for (ItemCardapio item : itensCardapio) {
            if (item.getId() == id) {
                itensCardapio.remove(item);
                return true;
            }
        }
        return false; // Item não encontrado
    }

    /**
     * Retorna um item do cardápio pelo ID.
     * 
     * @param id O ID do item a ser retornado.
     * @return O item do cardápio, ou null se o item não foi encontrado.
     */
    public ItemCardapio pedirItem(int id) {
        for (ItemCardapio item : itensCardapio) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item não encontrado
    }

    /**
     * Lista todos os itens do cardápio.
     */
    public void listarCardapio() {
        int i = 0; 
        for (ItemCardapio item : itensCardapio) {
            System.out.println( item.getId() + ": "+ item.getNome() + " - Preço: " + item.getPreco());
            i++;
        }
    }
    
    
    
}
