import java.util.Random;

public class TesteDesempenho {
    public static void main(String[] args) {
        int numBuscas = 5;
        FuncaoHash[] funcoesHash = {
                new HashDivisao(),
                new HashDobramento(),
                new HashMultiplicacao()
        };

        for (int tamanhoTabela : new int[]{1000, 10000, 100000}) {
            for (FuncaoHash funcaoHash : funcoesHash) {
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

                    System.out.println("Tabela: " + tamanhoTabela + ", Hash Func: " + funcaoHash.getNome() + ", Conjunto: " + tamanhoConjunto);
                    System.out.println("Média tempo de busca: " + mediaTempoBusca + " ns");
                    System.out.println("Média comparações: " + mediaComparacoes);
                }
            }
        }
    }

    public static int buscarElemento(int tamanhoTabela, FuncaoHash funcaoHash, int tamanhoConjunto) {
        int[] tabela = new int[tamanhoTabela];
        Random random = new Random();


        for (int i = 0; i < tamanhoTabela; i++) {
            String codigo = gerarCodigoAleatorio(9);
            tabela[i] = funcaoHash.calcularHash(codigo);
        }


        String codigoBuscado = gerarCodigoAleatorio(9);
        int elementoBuscado = funcaoHash.calcularHash(codigoBuscado);


        int comparacoes = 0;
        for (int i = 0; i < tamanhoTabela; i++) {
            comparacoes++;
            if (tabela[i] == elementoBuscado) {
                break;
            }
        }

        return comparacoes;
    }


    public static String gerarCodigoAleatorio(int tamanho) {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            codigo.append(random.nextInt(10));
        }
        return codigo.toString();
    }
}
