public class Metricas {
    private long tempoInsercao;
    private int colisoesTabela;
    private int colisoesLista;
    private int comparacoesBusca;

    public void resetar() {
        tempoInsercao = 0;
        colisoesTabela = 0;
        colisoesLista = 0;
        comparacoesBusca = 0;
    }

    public void registrarTempoInsercao(long tempo) {
        tempoInsercao = tempo;
    }

    public void incrementarColisoesTabela() {
        colisoesTabela++;
    }

    public void incrementarColisoesLista() {
        colisoesLista++;
    }

    public void incrementarComparacoesBusca() {
        comparacoesBusca++;
    }

    public void exibir() {
        System.out.println("Tempo de inserção: " + tempoInsercao + " ns");
        System.out.println("Colisões na tabela: " + colisoesTabela);
        System.out.println("Colisões nas listas: " + colisoesLista);
        System.out.println("Comparações de busca: " + comparacoesBusca);
    }
}
