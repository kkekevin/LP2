import java.io.BufferedReader;
import java.io.FileReader;

public class CompararParagrafo {
    String textoP[], textoS[];
    int plagio;

    public String[] readFile (String arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String paragrafo = reader.readLine();
            int x = 0;
            String[] vet = new String[100];
            while (paragrafo != null) {
                vet[x] = paragrafo;
                paragrafo = reader.readLine();
                x++;
            }
            return vet;            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void comparar (String textp, String texts) {
        textoP = readFile(textp);
        textoS = readFile(texts);
        
        for (int i = 0; i < textoP.length; i++) {
            for (int j = 0; j < textoS.length; j++) {
                if (textoP[i] != null && textoS != null && textoP[i].equals(textoS[j]))
                    this.plagio++;
            }
        }
        System.out.println(plagio + " detectado");
    }
}
