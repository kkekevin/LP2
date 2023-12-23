public class Pergunta {
    public String pergunta, opa, opb, opc, opd;
    public int resposta;
    public boolean respondida;

    Pergunta (String pergunta, String opa, String opb, String opc ,String opd, int resposta) {
        this.pergunta = pergunta;
        this.opa = opa;
        this.opb = opb;
        this.opc = opc;
        this.opd = opd;
        this.resposta = resposta;
        this.respondida = false;
    }
    @Override
    public String toString() {
        return pergunta + "\n1 - " + opa + "\n2 - " + opb + "\n3 - " +  opc + "\n4 - " + opd;
    }
}
