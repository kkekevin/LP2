public class Evento extends Disciplina {
    protected String finalidade;

    public String getFinalidade() {
        return finalidade;
    }
    
    Evento (String finalidade, String nome, String horario, String curso) {
        super (nome, horario, curso);
        this.finalidade = finalidade;
    }
}
