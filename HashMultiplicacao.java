public class HashMultiplicacao extends FuncaoHash {
    @Override
    public int calcularHash(String codigo) {
        int hash = 0;
        int tamanho = tamanhoString(codigo);
        for (int i = 0; i < tamanho; i++) {
            hash = hash * 31 + (codigo.charAt(i) * 3);
        }
        return hash % 1000;
    }

    @Override
    public String getNome() {
        return "Multiplicação";
    }
}
