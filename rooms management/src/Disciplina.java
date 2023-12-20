public class Disciplina {
    protected String nome, horario, curso;
    //Reserva reserva;
    //protected boolean alocado;

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public String getCurso() {
        return curso;
    }

    Disciplina (String nome, String horario, String curso) {
        this.nome = nome;
        this.horario = horario;
        this.curso = curso;
    }
}
