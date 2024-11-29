public abstract class FuncaoHash {


    public int tamanhoString(String chave) {
        int tamanho = 0;
        char[] caracteres = chave.toCharArray();
        for (char c : caracteres) {
            tamanho++;
        }
        return tamanho;
    }


    public int hash(String chave, int tamanhoTabela) {
        int soma = 0;
        int tamanho = tamanhoString(chave);
        for (int i = 0; i < tamanho; i++) {
            soma += chave.charAt(i);
        }
        return soma % tamanhoTabela;
    }

    public abstract int calcularHash(String codigo);

    public abstract String getNome();
}
