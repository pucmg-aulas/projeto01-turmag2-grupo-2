public class FilaDeEspera {
    
    public FilaDeEspera() {
        filaDeEspera = new Pedido[100];
    }

    public void adicionarPedido (Pedido pedido) {
        int proximaPosicao = 0;

        while (filaDeEspera[proximaPosicao] != null) {
            proximaPosicao++;
        }

        filaDeEspera[proximaposicao] = pedido;
    }

    public void removerPedido () {
        for (int i = 0; i < filaDeEspera.lenght; i++) {
            if (filaDeEspera[i] == pedido) {
                filaDeEspera[i] = null;
                return;
            }
        }
    }

    public void consultarProximoCliente () {
        for (Pedido : filaDeEspera) {
            if (pedido != null) {
                return pedido
            }
        }

        return null;
    }
}
