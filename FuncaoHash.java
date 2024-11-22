public abstract class FuncaoHash {
    public int hash(String chave, int tamanhoTabela) {
        int soma = 0;
        for (int i = 0; i < chave.length(); i++) {
            soma += chave.charAt(i);
        }
        return soma % tamanhoTabela;
    }

    public abstract int calcularHash(String codigo);

    public abstract String getNome();
}
