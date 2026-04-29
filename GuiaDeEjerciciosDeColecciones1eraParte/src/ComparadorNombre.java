import java.util.Comparator;
public class ComparadorNombre implements Comparator<Empleado> {
    
@Override
public int compare(Empleado e1, Empleado e2) {
    return e1.nombreEmpleado.compareTo(e2.nombreEmpleado);
}


}
