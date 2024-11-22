public class AnaliseTabelaHash {
    public static void main(String[] args) {
        // Preparar tabelas e dados
        TabelaHash tabelaDivisao = new TabelaHash(1000, new HashDivisao());
        TabelaHash tabelaMultiplicacao = new TabelaHash(1000, new HashMultiplicacao());
        TabelaHash tabelaDobramento = new TabelaHash(1000, new HashDobramento());

        // Dados para inserção
        Registro[] registros = gerarRegistros(10000); 
        // Inserção e contagem de colisões e comparações para HashDivisao
        long tempoInicio = System.nanoTime();
        for (Registro registro : registros) {
            tabelaDivisao.inserir(registro);
        }
        long tempoFinal = System.nanoTime();
        System.out.println("Tempo de inserção - Divisão: " + (tempoFinal - tempoInicio) + " ns");
        System.out.println("Total de colisões - Divisão: " + tabelaDivisao.getTotalColisoes());

        // Repita o processo para Multiplicação e Dobramento
        tempoInicio = System.nanoTime();
        for (Registro registro : registros) {
            tabelaMultiplicacao.inserir(registro);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo de inserção - Multiplicação: " + (tempoFinal - tempoInicio) + " ns");
        System.out.println("Total de colisões - Multiplicação: " + tabelaMultiplicacao.getTotalColisoes());

        tempoInicio = System.nanoTime();
        for (Registro registro : registros) {
            tabelaDobramento.inserir(registro);
        }
        tempoFinal = System.nanoTime();
        System.out.println("Tempo de inserção - Dobramento: " + (tempoFinal - tempoInicio) + " ns");
        System.out.println("Total de colisões - Dobramento: " + tabelaDobramento.getTotalColisoes());

        // Busca e medição de comparações para cada função hash
        for (int i = 0; i < 5; i++) {
            String codigoBusca = gerarCodigo9Digitos(i);

            // Busca para a tabela de Divisão
            long inicioBusca = System.nanoTime();
            ResultadoBusca resultadoDivisao = tabelaDivisao.buscar(codigoBusca);
            long fimBusca = System.nanoTime();
            System.out.println("Tempo de busca - Divisão: " + (fimBusca - inicioBusca) + " ns");
            System.out.println("Comparações durante a busca - Divisão: " + resultadoDivisao.getComparacoes());

            // Busca para a tabela de Multiplicação
            inicioBusca = System.nanoTime();
            ResultadoBusca resultadoMultiplicacao = tabelaMultiplicacao.buscar(codigoBusca);
            fimBusca = System.nanoTime();
            System.out.println("Tempo de busca - Multiplicação: " + (fimBusca - inicioBusca) + " ns");
            System.out.println("Comparações durante a busca - Multiplicação: " + resultadoMultiplicacao.getComparacoes());

            // Busca para a tabela de Dobramento
            inicioBusca = System.nanoTime();
            ResultadoBusca resultadoDobramento = tabelaDobramento.buscar(codigoBusca);
            fimBusca = System.nanoTime();
            System.out.println("Tempo de busca - Dobramento: " + (fimBusca - inicioBusca) + " ns");
            System.out.println("Comparações durante a busca - Dobramento: " + resultadoDobramento.getComparacoes());
        }
    }

    // Função auxiliar para gerar códigos fictícios de 9 dígitos
    public static String gerarCodigo9Digitos(int numero) {
        char[] codigo = new char[9];
        for (int i = 8; i >= 0; i--) {
            codigo[i] = (char) ('0' + (numero % 10));
            numero /= 10;
        }
        return new String(codigo);
    }

    // Método para gerar registros fictícios
    public static Registro[] gerarRegistros(int quantidade) {
        Registro[] registros = new Registro[quantidade];
        for (int i = 0; i < quantidade; i++) {
            String codigo = gerarCodigo9Digitos(i);  
            registros[i] = new Registro(codigo, "Valor " + i); 
        }
        return registros;
    }
}
