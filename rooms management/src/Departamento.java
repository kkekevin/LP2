import java.util.ArrayList;

public class Departamento {
    protected String nome;
    protected ArrayList <Disciplina> disciplinas;
    protected ArrayList <Evento> eventos;
    public int i;

    Departamento (String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
        this.eventos = new ArrayList<Evento>();
    }
}
