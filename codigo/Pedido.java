public class Pedido {
    private int id;
    private Cliente cliente;
    private int numeroDePessoas;
    private int horaEntrada;
    private int horaSaida;
    private int dataEntrada;
    private int dataSaida;
    private String status;
    
    
    public Pedido(Cliente cliente, String staus, int numeroDePessoas, int horaEntrada, int horaSaida, int dataEntrada, int dataSaida){
        this.cliente = cliente;
        this.numeroDePessoas = numeroDePessoas;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
    
    public String registrarPedido(){
    return "";
    }
    
    public boolean atualizarPedido(){
    return false;
    }
    
    public boolean cancelarPedido(){
    return false;
    }
    
    public void consultarPedido(){
    
    }
    
    public void listarPedidos(){
    
    }
}
