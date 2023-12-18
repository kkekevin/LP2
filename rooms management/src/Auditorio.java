public class Auditorio extends Reserva {
    String finalidade;

    Auditorio(String codSala, int capacidade, int semestre, int ano) {
        super(codSala, capacidade, false, semestre, ano);
    }
}
