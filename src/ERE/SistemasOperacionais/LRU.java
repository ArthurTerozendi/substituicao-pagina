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
        boolean tem = false;
        boolean vazio = true;
        String quadros[] = new String[quantidadeQuadros];
        String fila[][] =  new String[quantidadeQuadros][quantidadeQuadros];
        String aux[] = new String[quantidadeQuadros];
        for (int i = 0; i < quadros.length; i++) {
            quadros[i] = "";
            aux[i] = "";
        }
        for (String entrada: entradas) {
            for (int i = 0; i < quadros.length; i++) {
                if (entrada.equals(quadros[i])) {
                    tem = true;
                    for (int j = 0; j < quadros.length; j++) {
                        fila[i][j] = "1";
                    }
                    for (int j = 0; j < quadros.length; j++) {
                        fila[j][i] = "0";
                    }
                    break;
                }
                else {
                    tem = false;
                }
            }
            if (!tem) {
                faltas++;
                for (int i = 0; i < quadros.length; i++) {
                    if (quadros[i].equals("")) {
                        quadros[i] = entrada;
                        for (int j = 0; j < quadros.length; j++) {
                            fila[i][j] = "1";
                        }
                        for (int j = 0; j < quadros.length; j++) {
                            fila[j][i] = "0";
                        }
                        vazio = true;
                        break;
                    }
                    else {
                        vazio = false;
                    }
                }
                if (!vazio) {
                    int menosUsadoIndex = 0;
                    int menosUsado = 0;
                    for (int i = 0; i < quadros.length; i++) {
                        for (int j = 0; j < quadros.length; j++) {
                            aux[i] += fila[i][j];
                        }
                        int numero = Integer.parseInt(aux[i], 2);
                        if (i == 0) {
                            menosUsadoIndex = i;
                            menosUsado = numero;
                        }else {
                            if (numero < menosUsado) {
                                menosUsadoIndex = i;
                                menosUsado = numero;
                            }
                        }
                    }
                    quadros[menosUsadoIndex] = entrada;
                    for (int j = 0; j < quadros.length; j++) {
                        fila[menosUsadoIndex][j] = "1";
                    }
                    for (int j = 0; j < quadros.length; j++) {
                        fila[j][menosUsadoIndex] = "0";
                    }
                    for (int j = 0; j < quadros.length; j++) {
                        aux[j] = "";
                    }
                }

            }
        }

        return faltas;
    }
}
