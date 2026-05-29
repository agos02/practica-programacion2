package empresadb;

public class Empleado {

    private int id;
    private String nombre;
    private String departamento;
    private int idDepto;
    private String foto;

    public Empleado() {
    }

    public Empleado(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public Empleado(int id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public int getIdDepto() {
    return idDepto;
    }

    public void setIdDepto(int idDepto) {
    this.idDepto = idDepto;
    }
    public String getFoto(){
        return foto; 
    }
    public void setFoto(String foto){
    this.foto = foto; 
    }
}