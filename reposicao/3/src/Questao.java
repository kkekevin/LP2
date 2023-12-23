import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Questao {
    ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();

    public void readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            String[] vet = line.split(";");
            String questao = vet[0];
            String la = vet[1];
            String lb = vet[2];
            String lc = vet[3];
            String ld = vet[4];
            Integer resposta = Integer.parseInt(vet[5]);
            perguntas.add(new Pergunta(questao, la, lb, lc, ld, resposta));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listFile() {
        try {
            File f = new File("/home/kevin/CPufma/LP2/LP2/reposicao/3/questoes");
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                readFile(files[i].getPath());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        responder();
    }

    public void responder() {
        String c = "correta", e = "errada";
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int quantidade = 0;

        do {
            int index = random.nextInt(perguntas.size());
            if (!perguntas.get(index).respondida) {
                System.out.println(perguntas.get(index).toString());
                int x = in.nextInt();
                in.nextLine();
                if (perguntas.get(index).resposta == x) {
                    System.out.println(c);
                } else {
                    System.out.println(e);
                }
                quantidade++;
            }
            perguntas.get(index).respondida = true;
        } while (quantidade > perguntas.size());
    }
}
