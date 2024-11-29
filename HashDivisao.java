public class HashDivisao extends FuncaoHash {
    @Override
    public int calcularHash(String codigo) {
        int hash = 0;
        int tamanho = tamanhoString(codigo);
        for (int i = 0; i < tamanho; i++) {
            hash = (hash * 31 + codigo.charAt(i)) % 1000;
        }
        return hash;
    }

    @Override
    public String getNome() {
        return "Divisão";
    }
}
