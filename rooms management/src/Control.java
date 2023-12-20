import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    protected Departamento departamento;
    protected ArrayList<Reserva> salas;    
    protected Scanner in;

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("solicitacao.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] vet = line.split(";");
                String tipo = vet[0];
                Integer ano = Integer.parseInt(vet[1]);
                Integer semestre = Integer.parseInt(vet[2]);
                String curso = vet[3];
                String dado = vet[4];
                Integer vagas = Integer.parseInt(vet[5]);
                String horario = vet[6];
                line = reader.readLine();
                }

                reader.close();
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

    public void writeFile(String tipo, int ano, Integer semestre,
            String curso, String dado, int vagas, String horario) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("solicitacao.txt", true))) {
            writer.write(tipo + ";");
            writer.write(ano + ";");
            writer.write(semestre + ";");
            writer.write(curso + ";");
            writer.write(dado + ";");
            writer.write(vagas + ";");
            writer.write(horario + "\n");
            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeRFile (int opt, String codSala, int capacidade, int semestre, int ano) {
        try (BufferedWriter writer = new BufferedWriter (new FileWriter("salas.txt", true))) {
            writer.write(opt + ";");
            writer.write(codSala + ";");
            writer.write(capacidade + ";");
            writer.write(semestre + ";");
            writer.write(ano + "\n");
        writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void readRFile () {
        try (BufferedReader reader = new BufferedReader(new FileReader("salas.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] vet = line.split(";");
                Integer opt = Integer.parseInt(vet[0]);
                String codSala = vet[1];
                Integer capacidade = Integer.parseInt(vet[2]);
                Integer semestre = Integer.parseInt(vet[3]);
                Integer ano = Integer.parseInt(vet[4]);
                    switch (opt) {
                case 1:
                    this.salas.add(new Sala(codSala, capacidade, semestre, ano));
                    break;
                case 2:
                    this.salas.add(new Auditorio(codSala, capacidade, semestre, ano));
                    break;
                default:                
                    break;
                }
                line = reader.readLine();
            }            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeSFile(String nome, String horario,String curso) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("disciplinas.txt", true))) {
            writer.write(nome + ";");
            writer.write(horario + ";");
            writer.write(curso + "\n");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void readSFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("disciplinas.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] vet = line.split(";");
                String nome = vet[0];
                String curso = vet[1];
                String horario = vet[2];               
                line = reader.readLine();
                departamento.disciplinas.add(new Disciplina(nome, horario, curso));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
                indexOfSala = melhorSala(capacidade, departamento.disciplinas.get(index - 1).getHorario());
                if (indexOfSala != -1) { // verifica se encontrou a sala
                    salas.get(indexOfSala).horarios.add(departamento.disciplinas.get(index - 1).horario);
                    salas.get(indexOfSala).sala.put(salas.get(indexOfSala).getCodLocal(),
                            salas.get(indexOfSala).horarios);

                    writeFile("FIXA", salas.get(indexOfSala).getAno(), salas.get(indexOfSala).getSemestre(),
                            departamento.disciplinas.get(index - 1).getCurso(), "disciplina",
                            salas.get(indexOfSala).getCapacidade(),
                            departamento.disciplinas.get(index - 1).getHorario());
                            System.out.println("successs");

                } else {
                    System.out.println("nenhuma sala disponivel");
                }
                break;
            case 2:
                System.out.println("""
                        Selecione a finalidade:
                        1 - seminario
                        2 - defesa tcc
                        3 - palestra
                        4 - prova
                        """);
                int finalidade = this.in.nextInt();
                this.in.nextLine();
                System.out.println("DIGITE DIA DA SEMANA E HORARIO CONFORME PADRAO 23M45 SIGAA: ");
                String horario = this.in.nextLine();
                System.out.println("curso solicitante: ");
                String curso = this.in.nextLine();
                switch (finalidade) {
                    case 1:
                        departamento.eventos.add(new Evento("seminario", "evento", horario, curso));
                        break;
                    case 2:
                        departamento.eventos.add(new Evento("tcc", "evento", horario, curso));
                        break;
                    case 3:
                        departamento.eventos.add(new Evento("palestra", "evento", horario, curso));
                        break;
                    case 4:
                        departamento.eventos.add(new Evento("prova", "evento", horario, curso));
                        break;
                    default:
                        System.out.println("entrada invalida");
                        break;
                }
                indexOfSala = melhorAuditorio(capacidade, departamento.disciplinas);
                if (indexOfSala != -1) { // verifica se encontrou a sala
                    salas.get(indexOfSala).horarios.add(
                            departamento.eventos.get(departamento.eventos.size() - 1).horario);
                    salas.get(indexOfSala).sala.put(salas.get(indexOfSala).getCodLocal(),
                            salas.get(indexOfSala).horarios);

                    writeFile("EVENTUAL", salas.get(indexOfSala).getAno(), salas.get(indexOfSala).getSemestre(),
                            departamento.eventos.get(departamento.eventos.size() - 1).getCurso(),
                            departamento.eventos.get(departamento.eventos.size() -1).getFinalidade(),
                            salas.get(indexOfSala).getCapacidade(),
                            departamento.eventos.get(departamento.eventos.size() - 1).getHorario());
                            System.out.println("successs");
                } else {
                    System.out.println("nenhuma sala disponivel");
                }
                // file
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
        writeRFile(opt, codSala, capacidade, semestre, ano);
    }

    public int melhorSala(int capacidade, String horario) {
        int index = -1, support = -1, x = 0;
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getCapacidade() >= capacidade
                    && !salas.get(i).horarios.contains(horario)) {
                support = i;
                if (salas.get(x).getCapacidade() > salas.get(i).getCapacidade()) {
                    index = support;
                    x = index;
                }
            }
        }
        return index != -1 ? index : support;
    }

    public int melhorAuditorio(int capacidade, ArrayList<Disciplina> disciplina) {
        int index = -1, support = -1, x = 0;
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getCapacidade() >= capacidade
                    && !salas.get(i).sala.containsValue(disciplina) && !salas.get(i).tipo) {
                support = i;
                if (salas.get(index).getCapacidade() > salas.get(i).getCapacidade()) {
                    index = support;
                    x = index;
                }
            }
        }
        return index != -1 ? index : support;
    }

    public void cadastrarDisciplina() {
        System.out.println("Nome da disciplina: ");
        String nome = this.in.nextLine();
        for (Disciplina i : departamento.disciplinas) {
            if (i.getNome().equals(nome)) {
                System.out.println("esta disciplina ja existe");
                return;
            }
        }
        System.out.println("Horario da disciplina conforme padrao semanal SIGAA: ");
        String horario = this.in.nextLine();
        System.out.println("Curso: ");
        String curso = this.in.nextLine();
        departamento.disciplinas.add(new Disciplina(nome, horario, curso));
        writeSFile(nome, horario, curso);
    }

    public void listarDisciplina() {
        for (int i = 0; i < this.departamento.disciplinas.size(); i++)
            System.out.println(i + 1 + " - " + this.departamento.disciplinas.get(i).getNome());
    }

    public void menu() {
        readSFile();
        readRFile();
        // readFile();
        int opt;
        do {
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Cadastrar uma sala");
            System.out.println("2 - Alocar umas sala");
            System.out.println("3 - Cadastrar disciplina");
            System.out.println("0 - Sair");
            opt = this.in.nextInt();
            this.in.nextLine();

            switch (opt) {
                case 1:
                    cadastrarSala();
                    break;
                case 2:
                    alocarSala();
                    break;
                case 3:
                    cadastrarDisciplina();
                case 0:
                    System.out.println("seeya");
                    this.in.close();
                    System.exit(0);
                default:
                    System.out.println("entrada invalida");
            }
        } while (true);
    }

    Control() {
        this.departamento = new Departamento("DETE");
        this.in = new Scanner(System.in);
        this.salas = new ArrayList<Reserva>();
    }
}
