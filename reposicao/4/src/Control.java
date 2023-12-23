import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Control {
    Curso curso;
    protected Scanner in;

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("grade.txt"))) {
            String line = reader.readLine();
            String[] v = line.split(";");
            Integer cod = Integer.parseInt(v[1]);
            curso = new Curso(v[0], cod);
            line = reader.readLine();
            while (line != null) {

                String[] vet = line.split(";");
                int ch = Integer.parseInt(vet[2]);
                curso.disciplinas.add(new Disciplina(vet[0], vet[1], ch));
                if (vet.length > 3) {
                    for (int i = 3; i < vet.length; i++)
                        curso.disciplinas.get(curso.disciplinas.size() - 1).pre.put(
                                vet[i], false);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSubject() {
        System.out.println("entre com o codigo da disciplina: ");
        String subject = this.in.nextLine();        
        for (Disciplina i : curso.disciplinas) {
            if (i.cod.equals(subject))
                i.aprovado = true;
            if (i.pre.containsKey(subject))
                i.pre.put(subject, true);            
        }
    }

    public void availableSubjects() {
        System.out.println(curso.nome);
        for (Disciplina i : curso.disciplinas) {
            if (!i.aprovado && !i.pre.containsValue(false))
                System.out.println(i.nome);
        }        
    }

    public void menu () {
        readFile();
        int opt;
        do {
            System.out.println("""
                    1 - mencionar disciplinas
                    2 - verificar disciplinas disponiveis
                    0 - sair
                    """);

            opt = this.in.nextInt();
            this.in.nextLine();

            switch (opt) {
                case 1:
                    insertSubject();
                    break;
                case 2:
                    availableSubjects();
                    break;
                case 0:
                    System.out.println("seeya");
                    this.in.close();
                    System.exit(0);
                default:
                    break;
            }
        } while (true);
    }

    Control() {
        this.in = new Scanner(System.in);
    }
}
