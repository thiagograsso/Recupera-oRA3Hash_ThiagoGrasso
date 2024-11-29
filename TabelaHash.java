public class TabelaHash {
    private Registro[][] tabela;
    private int[] tamanhos;
    private int tamanho;
    private FuncaoHash funcaoHash;
    private int totalColisoes;

    public TabelaHash(int tamanho, FuncaoHash funcaoHash) {
        this.tamanho = tamanho;
        this.funcaoHash = funcaoHash;
        this.tabela = new Registro[tamanho][];
        this.tamanhos = new int[tamanho];
        this.totalColisoes = 0;
    }

    public int inserir(Registro registro) {
        int comparacoes = 0;
        int indice = funcaoHash.hash(registro.getCodigo(), tamanho);

        if (tabela[indice] == null) {
            tabela[indice] = new Registro[1];
            tabela[indice][0] = registro;
            tamanhos[indice] = 1;
        } else {

            for (int i = 0; i < tamanhos[indice]; i++) {
                comparacoes++;
                if (tabela[indice][i].getCodigo().equals(registro.getCodigo())) {
                    return comparacoes;
                }
            }


            Registro[] novaLista = new Registro[tamanhos[indice] + 1];
            for (int i = 0; i < tamanhos[indice]; i++) {
                novaLista[i] = tabela[indice][i];
            }
            novaLista[tamanhos[indice]] = registro;
            tabela[indice] = novaLista;
            tamanhos[indice]++;
            totalColisoes++;
        }
        return comparacoes;
    }

    public ResultadoBusca buscar(String chave) {
        int comparacoes = 0;
        int indice = funcaoHash.hash(chave, tamanho);

        if (tabela[indice] != null) {
            for (int i = 0; i < tamanhos[indice]; i++) {
                comparacoes++;
                if (tabela[indice][i].getCodigo().equals(chave)) {
                    return new ResultadoBusca(tabela[indice][i], comparacoes);
                }
            }
        }
        return new ResultadoBusca(null, comparacoes);
    }

    public void exibirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            if (tabela[i] != null) {
                for (int j = 0; j < tamanhos[i]; j++) {
                    System.out.print(tabela[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int getTotalColisoes() {
        return totalColisoes;
    }
}
