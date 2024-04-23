package sistemarestaurante;
public class Hora {

    public String validarHora(int hora, int minuto) {

        // Verificar se a hora é válida
        if (hora >= 0 && hora < 24 && minuto >= 0 && minuto < 60) {
            System.out.println("Hora válida.");
            return(hora + ":" + minuto);
        } else {
            System.out.println("Hora inválida.");
        }

        return ("0");
    }
    
}
