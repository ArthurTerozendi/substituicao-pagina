package ERE.SistemasOperacionais;

import java.util.ArrayList;

public class FIFO {
    private ArrayList<String> entradas;
    private String quantidadeQuadros;
    public FIFO(ArrayList<String> entradas, String quantidadeQuadros) {
        this.entradas = entradas;
        this.quantidadeQuadros = quantidadeQuadros;
    }
    public int substituicao() {
        int faltas = 0;
        boolean tem = false;
        int quantidadeQuadros = Integer.parseInt(this.quantidadeQuadros);
        ArrayList<String> fila = new ArrayList<>();
        for (String entrada: entradas) {
            for (String item: fila) {
                if (item.equals(entrada)) {
                    tem = true;
                    break;
                }
                else {
                    tem = false;
                }
            }
            if (!tem) {
                faltas++;
                if (fila.size() < quantidadeQuadros) {
                    fila.add(entrada);
                }
                else {
                    fila.remove(0);
                    fila.add(entrada);
                }
            }
        }
        return faltas;
    }
}
