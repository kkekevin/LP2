import java.util.ArrayList;

public class Curso {
    ArrayList<Disciplina> disciplinas;
    String nome;
    int cod;

    Curso (String nome, int cod) {
        this.nome = nome;
        this.cod = cod;
        disciplinas = new ArrayList<Disciplina>();
    }
}
