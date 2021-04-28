package ERE.SistemasOperacionais;

import java.io.*;
import java.util.ArrayList;

public class Leitor {
    private File file;

    public Leitor(String path) {
        this.file = new File(path);
    }

    public ArrayList<String> ler() throws IOException {
        ArrayList<String> entrada = new ArrayList<>();
        FileReader leitor = new FileReader(file);
        BufferedReader bLeitor =  new BufferedReader(leitor);
        int i = 0;
        while(bLeitor.ready()) {
            if (i != 0) {
                entrada.add(bLeitor.readLine());
            }
            else {
                bLeitor.readLine();
            }
            i++;
        }

        bLeitor.close();
        leitor.close();
        return entrada;
    }
    public String getQuantidadeQuadros() throws IOException {
        FileReader leitor = new FileReader(file);
        BufferedReader bLeitor =  new BufferedReader(leitor);
        String quantidadeQuadros = bLeitor.readLine();

        return quantidadeQuadros;
    }

}
