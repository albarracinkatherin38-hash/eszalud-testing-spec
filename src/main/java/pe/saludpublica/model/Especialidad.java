package pe.saludpublica.model;

/**
 * Modelo que representa una especialidad médica.
 */
public class Especialidad {

    private String nombre;
    private String descripcion;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
