public class HashDivisao extends FuncaoHash {
    @Override
    public int calcularHash(String codigo) {
        int hash = 0;
        for (int i = 0; i < codigo.length(); i++) {
            hash = (hash * 31 + codigo.charAt(i)) % 1000; // Exemplo de hash com resto da divisão
        }
        return hash;
    }

    @Override
    public String getNome() {
        return "Divisão";
    }
}
