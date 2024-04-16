import java.util.*;

public class Mesa {
    int idMesa;
    int capacidade;
    boolean disponibilidade;

    public Mesa(int idMesa, int capacidade, boolean disponibilidade) {
        this.idMesa = idMesa;
        this.capacidade = capacidade;
        this.disponibilidade = disponibilidade;
    }

    public int verificarDisponiblidade(Mesa mesas[]) {
        for (int i = 0; i < mesas.length; i++) {
            if (mesas[i].disponibilidade) {
                return mesas[i].idMesa;
            }
        }
        return -1;
    }

    public void alocarMesa(int idPedido) {
        this.disponibilidade = false;
    }

    public void desalocarMesa() {
        this.disponibilidade = true;
    }

    public boolean verificarCapacidade(Pedido pedido) {
        int pessoas = pedido.numeroPessoas;
        if (this.capacidade >= pessoas) {
            return true;
        }
        return false;
    }

    public void listarMesasDisponiveis(Mesa mesas[]) {
        System.out.println("Mesas Disponiveis:");
        for (int i = 0; i < mesas.length; i++) {
            if (mesas[i].disponibilidade) {
                System.out.println(mesas[i].idMesa);
            }
        }
    }

    public double calcularTempoPermanencia(Cliente cliente) {

    }

}
