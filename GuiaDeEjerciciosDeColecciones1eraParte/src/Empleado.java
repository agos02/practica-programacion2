public class Empleado implements Comparable<Empleado> {
    public String nombreEmpleado;
    public int edadEmpleado;

public Empleado (String nombreEmpleado , int edadEmpleado){
  this.nombreEmpleado = nombreEmpleado;
  this.edadEmpleado = edadEmpleado;  
}

@Override
public int compareTo(Empleado otroEmpleado){
    return this.edadEmpleado - otroEmpleado.edadEmpleado;
}

@Override
public String toString() {
    return nombreEmpleado + " | " + edadEmpleado;
}

}
