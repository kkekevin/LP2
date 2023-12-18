import java.util.ArrayList;
import java.util.HashMap;

public abstract class Reserva {
    protected String codLocal;
    protected HashMap<String, ArrayList<Disciplina> > sala;
    protected ArrayList<Disciplina> disciplinas;
    protected int semestre, ano, capacidade;
    boolean tipo;

    public String getCodLocal() {
        return codLocal;
    }

    public int getCapacidade() {
        return capacidade;
    }

    Reserva (String codLocal, int capacidade, boolean tipo, int semestre, int ano) {
        this.sala = new HashMap<>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.codLocal = codLocal;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.semestre = semestre;
        this.ano = ano;
        sala.put(codLocal, null);
    }
}
