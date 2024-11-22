public class HashDobramento extends FuncaoHash {
    @Override
    public int calcularHash(String codigo) {
        int hash = 0;
        for (int i = 0; i < 9; i += 2) { // Código fixo em 9 dígitos
            int parte = (codigo.charAt(i) - '0') * 10;
            if (i + 1 < 9) {
                parte += (codigo.charAt(i + 1) - '0');
            }
            hash += parte;
        }
        return hash % 1000; // Ajuste o divisor conforme o tamanho da tabela
    }

    @Override
    public String getNome() {
        return "Dobramento";
    }
}
