import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    protected Departamento departamento;
    protected ArrayList<Reserva> salas;
    protected ArrayList<Disciplina> cadeirasComSala;
    protected Scanner in;

    public void alocarSala() {
        int indexOfSala;
        System.out.println("""
                1 - p/ disciplina
                2 - p/ evento
                """);
        int tipo = this.in.nextInt();
        this.in.nextLine();
        System.out.println("capacidade: ");
        int capacidade = this.in.nextInt();
        this.in.nextLine();

        switch (tipo) {
            case 1:
                System.out.println("escolha a disciplina");
                listarDisciplina();
                int index = this.in.nextInt();
                this.in.nextLine();
                indexOfSala = melhorSala(capacidade, departamento.disciplinas);
                if (indexOfSala != -1) {
                    salas.get(indexOfSala).disciplinas.add(departamento.disciplinas.get(index));
                    salas.get(indexOfSala).sala.put(salas.get(indexOfSala).getCodLocal(), 
                    salas.get(indexOfSala).disciplinas);
                }
                break;
            case 2:
            default:
                System.out.println("digite valor valido");
                break;
        }
    }

    public void cadastrarSala() {
        System.out.println("1 - sala");
        System.out.println("2 - auditorio");
        int opt = this.in.nextInt();
        this.in.nextLine();

        System.out.println("digite o codigo da sala: ");
        String codSala = this.in.nextLine();
        for (Reserva i : salas) {
            if (i.getCodLocal().equals(codSala)) {
                System.out.println("esta sala ja existe");
                return;
            }
        }
        System.out.println("informe a capacidade: ");
        int capacidade = this.in.nextInt();
        this.in.nextLine();
        System.out.println("semestre para uso: ");
        int semestre = this.in.nextInt();
        this.in.nextLine();
        System.out.println("ano: ");
        int ano = this.in.nextInt();
        this.in.nextLine();
        switch (opt) {
            case 1:
                salas.add(new Sala(codSala, capacidade, semestre, ano));
                break;
            case 2:
                salas.add(new Auditorio(codSala, capacidade, semestre, ano));
                break;
            default:
                System.out.println("entrada invalida");
                break;
        }
    }

    public int melhorSala(int capacidade, ArrayList<Disciplina> disciplina) {
        int index = -1, support = -1;
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getCapacidade() >= capacidade
                    && !salas.get(i).sala.containsValue(disciplina)) {
                support = i;
                if (salas.get(index).getCapacidade() > salas.get(i).getCapacidade()) {
                    index = support;
                }
            }
        }
        return index != -1 ? index : support;
    }

    public void listarDisciplina() {
        for (int i = 0; i < this.departamento.disciplinas.size(); i++)
            System.out.println(i + 1 + " - " + this.departamento.disciplinas.get(i).getNome());
    }

    public void menu() {
        int opt;
        do {
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Cadastrar uma sala");
            System.out.println("2 - Alocar umas sala");
            System.out.println("3 - Cadastrar Fornnecedor");
            System.out.println("4 - Listar Fornecedores");
            System.out.println("5 - Realizar venda");
            System.out.println("6 - Lista Vendas");
            System.out.println("0 - Sair");
            opt = this.in.nextInt();
            this.in.nextLine();

            switch (opt) {
                case 1:
                    cadastrarSala();
                    break;
                case 2:
                    // listarSalas();
                    break;
                default:
                    System.out.println("entrada invalida");
            }
        } while (opt != 0);
    }

    Control() {
        this.departamento = new Departamento("DETE");
        this.in = new Scanner(System.in);
        this.salas = new ArrayList<Reserva>();
    }
}
