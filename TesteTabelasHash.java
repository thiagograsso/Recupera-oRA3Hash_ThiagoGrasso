public class TesteTabelasHash {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(1000, new HashDivisao());

        // Inserção de exemplo
        for (int i = 0; i < 100; i++) {
            String codigo = gerarCodigo9Digitos(i);
            Registro registro = new Registro(codigo, "Valor " + i);
            int comparacoesInsercao = tabelaHash.inserir(registro);
            System.out.println("Comparações ao inserir " + codigo + ": " + comparacoesInsercao);
        }

        // Exibir total de colisões após as inserções
        System.out.println("Total de colisões após inserção: " + tabelaHash.getTotalColisoes());

        // Busca de exemplo
        for (int i = 0; i < 100; i++) {
            String codigo = gerarCodigo9Digitos(i);
            Registro registroEncontrado = tabelaHash.buscar(codigo).getRegistro();

            if (registroEncontrado != null) {
                System.out.println("Registro " + registroEncontrado.getCodigo() + " encontrado com sucesso.");
            } else {
                System.out.println("Registro " + codigo + " não encontrado.");
            }
        }

        System.out.println("Execução concluída. Os resultados foram exibidos no console.");
    }

    public static String gerarCodigo9Digitos(int numero) {
        char[] codigo = new char[9];
        for (int i = 8; i >= 0; i--) {
            codigo[i] = (char) ('0' + (numero % 10));
            numero /= 10;
        }
        return new String(codigo);
    }
}
