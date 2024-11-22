public class Registro {
    private String codigo;

    public Registro(String codigo, String s) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Registro{" + "codigo='" + codigo + '\'' + '}';
    }
}
