package ERE.SistemasOperacionais;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Leitor leitor = new Leitor("entrada.txt");
        ArrayList<String> entradas = leitor.ler();
        String quantidadeQuadros = leitor.getQuantidadeQuadros();
        FIFO fifo = new FIFO(entradas, quantidadeQuadros);
        LRU lru = new LRU(entradas, quantidadeQuadros);
        Otimo otimo = new Otimo(entradas, quantidadeQuadros);

        System.out.println(fifo.substituicao());
        System.out.println(lru.substituicao());
        System.out.println(otimo.substituicao());
    }
}
