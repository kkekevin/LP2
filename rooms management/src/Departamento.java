import java.util.ArrayList;

public class Departamento {
    protected String nome;
    protected ArrayList <Disciplina> disciplinas;
    public int i;

    Departamento (String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
    }
}
