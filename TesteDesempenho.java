// Classe para realizar as 5 buscas
public class TesteDesempenho {
    public static void main(String[] args) {
        int numBuscas = 5;
        for (int tamanhoTabela : new int[]{1000, 10000, 100000}) {
            for (int funcaoHash : new int[]{1, 2, 3}) { 
                for (int tamanhoConjunto : new int[]{10000, 100000, 1000000}) {
                    long tempoTotalBusca = 0;
                    int comparacoesTotais = 0;

                    for (int i = 0; i < numBuscas; i++) {
                        long tempoInicio = System.nanoTime();
                        int comparacoes = buscarElemento(tamanhoTabela, funcaoHash, tamanhoConjunto);
                        long tempoFinal = System.nanoTime();

                        tempoTotalBusca += (tempoFinal - tempoInicio);
                        comparacoesTotais += comparacoes;
                    }

                    double mediaTempoBusca = tempoTotalBusca / (double) numBuscas;
                    double mediaComparacoes = comparacoesTotais / (double) numBuscas;

                    System.out.println("Tabela: " + tamanhoTabela + ", Hash Func: " + funcaoHash + ", Conjunto: " + tamanhoConjunto);
                    System.out.println("Média tempo de busca: " + mediaTempoBusca + " ns");
                    System.out.println("Média comparações: " + mediaComparacoes);
                }
            }
        }
    }

    // Este é um exemplo de como a busca pode ser estruturada
    public static int buscarElemento(int tamanhoTabela, int funcaoHash, int tamanhoConjunto) {
        // Lógica para buscar o elemento na tabela
        // E retornar o número de comparações feitas
        int comparacoes = 0;
        // Código de busca aqui...
        return comparacoes;
    }
}
