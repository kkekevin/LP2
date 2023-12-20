import java.util.ArrayList;
import java.util.HashMap;

public abstract class Reserva {
    protected String codLocal;
    protected HashMap<String, ArrayList<String> > sala;
    protected ArrayList<String> horarios;
    protected int semestre, ano, capacidade;
    boolean tipo;

    public String getCodLocal() {
        return codLocal;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getAno() {
        return ano;
    }

    public int getSemestre() {
        return semestre;
    }

    Reserva (String codLocal, int capacidade, boolean tipo, int semestre, int ano) {
        this.sala = new HashMap<>();
        this.horarios = new ArrayList<String>();
        this.codLocal = codLocal;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.semestre = semestre;
        this.ano = ano;
        sala.put(codLocal, null);
    }
}
