import java.util.HashMap;

public class Disciplina {
    protected String nome, cod;
    protected int ch;
    protected HashMap <String, Boolean> pre;
    protected boolean aprovado;
    
    Disciplina (String cod, String nome, int ch) {
        this.cod = cod;
        this.nome = nome;
        this.ch = ch;
        this.aprovado = false;
        this.pre = new HashMap<String, Boolean>();
    }
}
