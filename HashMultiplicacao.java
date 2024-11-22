public class HashMultiplicacao extends FuncaoHash {
    @Override
    public int calcularHash(String codigo) {
        int hash = 0;
        for (int i = 0; i < codigo.length(); i++) {
            hash = hash * 31 + (codigo.charAt(i) * 3); // Multiplicação para variação
        }
        return hash % 1000; // Ajuste o divisor conforme o tamanho da tabela
    }

    @Override
    public String getNome() {
        return "Multiplicação";
    }
}
