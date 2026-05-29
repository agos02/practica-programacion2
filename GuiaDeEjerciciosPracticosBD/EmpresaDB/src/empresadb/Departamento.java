package empresadb;

public class Departamento {

    private int id_depto;
    private String nombre_depto;

    public Departamento(int id_depto, String nombre_depto) {
        this.id_depto = id_depto;
        this.nombre_depto = nombre_depto;
    }

    public int getId_depto() {
        return id_depto;
    }

    public String getNombre_depto() {
        return nombre_depto;
    }

    @Override
    public String toString() {
        return nombre_depto; // esto es CLAVE para el JComboBox
    }
}