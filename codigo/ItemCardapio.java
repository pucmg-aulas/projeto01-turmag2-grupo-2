/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

/**
 * Classe que representa um item do cardápio.
 * Cada item possui um ID, nome e preço.
 * Esta classe será usada para povoar uma lista de itens no cardápio.
 */
public class ItemCardapio {
    private int id;
    private String nome;
    private double preco;
    

    /**
     * Construtor para criar um item do cardápio.
     *
     * @param id    Identificador único do item.
     * @param nome  Nome do item.
     * @param preco Preço do item.
     */
    public ItemCardapio(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return 
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
