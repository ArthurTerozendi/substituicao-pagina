package ERE.SistemasOperacionais;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Leitor leitor = new Leitor("entrada.txt");
        ArrayList<String> entradas = leitor.ler();
        String quantidadeQuadros = leitor.getQuantidadeQuadros();

        Escritor escritor = new Escritor("saida.txt");
        ArrayList<String> saidas = new ArrayList<>();

        FIFO fifo = new FIFO(entradas, quantidadeQuadros);
        LRU lru = new LRU(entradas, quantidadeQuadros);
        Otimo otimo = new Otimo(entradas, quantidadeQuadros);

        saidas.add("FIFO " + fifo.substituicao());
        saidas.add("OTM " + otimo.substituicao());
        saidas.add("LRU " +lru.substituicao());

        escritor.escrever(saidas);
    }
}
