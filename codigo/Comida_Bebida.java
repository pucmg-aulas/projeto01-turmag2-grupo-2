public class Comida_Bebida{
    private int id;
    private String nome;
    private double preco;

    public Comida_Bebida(int id,String nome,double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    public void adicionaComidaCardapio(Comida_Bebida comivel){
        Cardapio.add(comivel);
    }
    
    public void adicionaBebidaCardapio(Comida_Bebida bebivel){
        Cardapio.add(bebivel);
    }

}