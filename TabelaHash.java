public class TabelaHash {
    private Registro[][] tabela; // Tabela com vetores de registros para tratar colisões
    private int tamanho; // Tamanho da tabela
    private FuncaoHash funcaoHash; // Função hash utilizada
    private int totalColisoes; // Contador total de colisões

    // Construtor da classe
    @SuppressWarnings("unchecked")
    public TabelaHash(int tamanho, FuncaoHash funcaoHash) {
        this.tamanho = tamanho;
        this.funcaoHash = funcaoHash;
        this.tabela = new Registro[tamanho][]; // Inicializando a tabela
        this.totalColisoes = 0; // Inicializando o contador de colisões
    }

    // Método para inserir um registro na tabela hash
    public int inserir(Registro registro) {
        int comparacoes = 0;
        int indice = funcaoHash.hash(registro.getCodigo(), tamanho);

        // Verifica se já existe uma lista de registros no índice
        if (tabela[indice] == null) {
            tabela[indice] = new Registro[1]; // Cria um vetor para armazenar o primeiro registro
            tabela[indice][0] = registro;
        } else {
            // Se a lista já existe, verifica se o registro já está presente
            for (int i = 0; i < tabela[indice].length; i++) {
                comparacoes++;
                if (tabela[indice][i].getCodigo().equals(registro.getCodigo())) {
                    return comparacoes; // Já existe, nenhuma inserção
                }
            }

            // Caso contrário, cria um novo vetor com tamanho maior
            Registro[] novaLista = new Registro[tabela[indice].length + 1];
            System.arraycopy(tabela[indice], 0, novaLista, 0, tabela[indice].length);
            novaLista[tabela[indice].length] = registro;
            tabela[indice] = novaLista;
            // Contabilizando colisão
            totalColisoes++;
        }

        return comparacoes; // Retorna o número de comparações feitas
    }

    // Método para buscar um registro na tabela hash
    public ResultadoBusca buscar(String chave) {
        int comparacoes = 0;
        int indice = funcaoHash.hash(chave, tamanho);

        // Verifica se existe um vetor de registros no índice
        if (tabela[indice] != null) {
            // Busca o registro no vetor de registros
            for (int i = 0; i < tabela[indice].length; i++) {
                comparacoes++;
                if (tabela[indice][i].getCodigo().equals(chave)) {
                    return new ResultadoBusca(tabela[indice][i], comparacoes); // Registro encontrado
                }
            }
        }

        return new ResultadoBusca(null, comparacoes); // Se não encontrado
    }

    // Método para exibir o estado da tabela (útil para debug)
    public void exibirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            if (tabela[i] != null) {
                for (Registro registro : tabela[i]) {
                    System.out.print(registro + " ");
                }
            }
            System.out.println();
        }
    }

    // Método para retornar o total de colisões
    public int getTotalColisoes() {
        return totalColisoes;
    }
}
