package ERE.SistemasOperacionais;

import java.util.ArrayList;

public class Otimo {
    private ArrayList<String> entradas;
    private String quantidadeQuadros;

    public Otimo (ArrayList<String> entradas, String quantidadeQuadros) {
        this.entradas = entradas;
        this.quantidadeQuadros = quantidadeQuadros;
    }

    public int substituicao() {
        int faltas = 0;
        int quantidadeQuadros =  Integer.parseInt(this.quantidadeQuadros);

        String quadro[] = new String[quantidadeQuadros];
        Integer tempos[] = new Integer[quantidadeQuadros];
        boolean temposBoolean[] = new boolean[quantidadeQuadros];

        for (int i = 0; i < quantidadeQuadros; i++) {
            quadro[i] = "";
            tempos[i] = 0;
            temposBoolean[i] = false;
        }

        for (int i = 0; i < entradas.size(); i++) {

            if(!verificarQuadro(quadro, entradas.get(i))) {
                faltas++;
                if (faltas <= quantidadeQuadros) {
                    for (int j = 0; j < quantidadeQuadros; j++) {
                        if (quadro[j].equals("")) {
                            quadro[j] = entradas.get(i);
                            break;
                        }
                    }
                }
                else {
                    for (int j = i + 1; j < entradas.size(); j++) {
                        for (int k = 0; k < quantidadeQuadros; k++) {
                            if (!temposBoolean[k]) {
                                tempos[k]++;
                            }
                            if (quadro[k].equals(entradas.get(j))) {
                                temposBoolean[k] = true;
                            }
                        }
                    }
                    int index = maiorTempo(tempos);
                    quadro[index] = entradas.get(i);

                    for (int j = 0; j < quantidadeQuadros; j++) {
                        temposBoolean[j] = false;
                        tempos[j] = 0;
                    }
                }
            }
        }
        return faltas;
    }

    private boolean verificarQuadro(String[] quadro, String entrada) {
        for (String item: quadro) {
            if (item.equals(entrada)) {
                return true;
            }
        }
        return false;
    }

    private int maiorTempo(Integer[] tempos) {
        int maiorTempo = 0;
        int index = 0;
        for (int j = 0; j < tempos.length; j++) {
            if (j == 0) {
                maiorTempo = tempos[j];
                index = j;
            }
            else if (maiorTempo < tempos[j]) {
                maiorTempo = tempos[j];
                index = j;
            }
        }
        return index;
    }
}
