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
        String fila[] = new String[quantidadeQuadros];
        Integer tempoProxExecucao[] = new Integer[quantidadeQuadros];
        boolean aux[] = new boolean[quantidadeQuadros];
        boolean vazio = true;
        boolean tem = false;
        for (int i = 0; i < quantidadeQuadros; i++) {
            fila[i] = "";
            tempoProxExecucao[i] = 0;
            aux[i] = false;
        }

        for (int i = 0; i < entradas.size(); i++) {
            for (String item: fila) {
                if (item.equals(entradas.get(i))) {
                    tem = true;
                    break;
                }
                else {
                    tem = false;
                }
            }
            if(!tem) {
                faltas++;
                for (int j = 0; j < quantidadeQuadros; j++) {
                    if (fila[j].equals("")) {
                        fila[j] = entradas.get(i);
                        vazio = true;
                        break;
                    }
                    else {
                        vazio = false;
                    }
                }
                if (!vazio) {
                    for (int j = i + 1; j < entradas.size(); j++) {
                        for (int k = 0; k < quantidadeQuadros; k++) {
                            if (!aux[k]) {
                                tempoProxExecucao[k]++;
                            }
                            if (fila[k].equals(entradas.get(j))) {
                                aux[k] = true;
                            }
                        }
                    }
                    int maiorTempoProxExec = 0;
                    int maiorTempoProxExecIndex = 0;
                    for (int j = 0; j < quantidadeQuadros; j++) {
                        if (j == 0) {
                            maiorTempoProxExec = tempoProxExecucao[j];
                            maiorTempoProxExecIndex = j;
                        }
                        else if (maiorTempoProxExec < tempoProxExecucao[j]) {
                            maiorTempoProxExec = tempoProxExecucao[j];
                            maiorTempoProxExecIndex = j;
                        }
                    }
                    fila[maiorTempoProxExecIndex] = entradas.get(i);

                    for (int j = 0; j < quantidadeQuadros; j++) {
                        aux[j] = false;
                        tempoProxExecucao[j] = 0;
                    }
                }
            }
        }

        return faltas;
    }
}
