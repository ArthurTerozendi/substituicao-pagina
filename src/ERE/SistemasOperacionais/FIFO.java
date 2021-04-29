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
        int quantidadeQuadros = Integer.parseInt(this.quantidadeQuadros);
        ArrayList<String> quadro = new ArrayList<>();

        for (String entrada: entradas) {
            if (!verificarQuadro(quadro, entrada)) {
                faltas++;
                if (quadro.size() < quantidadeQuadros) {
                    quadro.add(entrada);
                }
                else {
                    quadro.remove(0);
                    quadro.add(entrada);
                }
            }
        }
        return faltas;
    }

    private boolean verificarQuadro(ArrayList<String> quadro, String entrada) {
        for (String item: quadro) {
            if (item.equals(entrada)) {
                return true;
            }
        }
        return false;
    }
}
