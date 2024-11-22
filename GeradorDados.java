import java.util.Random;

public class GeradorDados {
    public static Registro[] gerarRegistros(int quantidade) {
        Registro[] registros = new Registro[quantidade];
        Random random = new Random(123); // Seed fixa para consistência

        for (int i = 0; i < quantidade; i++) {
            StringBuilder codigo = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                codigo.append(random.nextInt(10)); // Gera um dígito de 0 a 9
            }
            registros[i] = new Registro(codigo.toString(), "Valor " + i);
        }

        return registros;
    }
}
