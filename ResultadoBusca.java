public class ResultadoBusca {
    private Registro registro;
    private int comparacoes;

    public ResultadoBusca(Registro registro, int comparacoes) {
        this.registro = registro;
        this.comparacoes = comparacoes;
    }

    public Registro getRegistro() {
        return registro;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
