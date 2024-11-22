public class ListaEncadeada {
    private No cabeça;

    public ListaEncadeada() {
        cabeça = null;
    }

    public void inserir(Registro registro) {
        No novoNo = new No(registro);
        novoNo.proximo = cabeça;
        cabeça = novoNo;
    }

    public Registro buscar(String codigo) {
        No atual = cabeça;
        while (atual != null) {
            if (atual.registro.getCodigo().equals(codigo)) {
                return atual.registro;
            }
            atual = atual.proximo;
        }
        return null; // Não encontrado
    }
}
