package ERE.SistemasOperacionais;

import java.util.ArrayList;

public class LRU {
    private ArrayList<String> entradas;
    private String quantidadeQuadros;

    public LRU (ArrayList<String> entradas, String quantidadeQuadros) {
        this.entradas = entradas;
        this.quantidadeQuadros = quantidadeQuadros;
    }

    public int substituicao() {
        int faltas = 0;
        int quantidadeQuadros =  Integer.parseInt(this.quantidadeQuadros);

        String quadro[] = new String[quantidadeQuadros];
        String quadroMatriz[][] =  new String[quantidadeQuadros][quantidadeQuadros];


        preencherString(quadro);

        for (String entrada: entradas) {

            if (!verificarQuadro(quadro, entrada, quadroMatriz)) {
                faltas++;
                if (faltas <= quantidadeQuadros) {
                    for (int i = 0; i < quadro.length; i++) {
                        if (quadro[i].equals("")) {
                            quadro[i] = entrada;
                            preencher(quadroMatriz, i);
                            break;
                        }
                    }
                }
                else {
                    int index = menosUsado(quadro, quadroMatriz);
                    quadro[index] = entrada;
                    preencher(quadroMatriz, index);
                }
            }
        }
        return faltas;
    }

    private boolean verificarQuadro(String[] quadro, String entrada, String[][] fila) {
        for (int i = 0; i < quadro.length; i++) {
            if (entrada.equals(quadro[i])) {
                preencher(fila, i);
                return true;
            }
        }
        return false;
    }

    private void preencher(String [][] matriz, int i) {
        for (int j = 0; j < matriz.length; j++) {
            matriz[i][j] = "1";
        }
        for (int j = 0; j < matriz.length; j++) {
            matriz[j][i] = "0";
        }
    }

    private void preencherString(String vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = "";
        }
    }

    private int menosUsado(String[] quadro, String[][] quadroMatriz) {
        String binario[] = new String[quadro.length];
        preencherString(binario);
        int index = 0;
        int menosUsado = 0;
        for (int i = 0; i < quadro.length; i++) {
            for (int j = 0; j < quadro.length; j++) {
                binario[i] += quadroMatriz[i][j];
            }
            int decimal = Integer.parseInt(binario[i], 2);
            if (i == 0) {
                index = i;
                menosUsado = decimal;
            }else {
                if (decimal < menosUsado) {
                    index = i;
                    menosUsado = decimal;
                }
            }
        }
        return index;
    }
}
