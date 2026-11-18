package pe.saludpublica.model;

/**
 * Modelo que representa una especialidad médica.
 */
public class Especialidad {

    private final String nombre;
    private final String descripcion;

    public Especialidad(String nombre, String descripcion) {
        requireNotNull(nombre, "El nombre es obligatorio");

        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    private static void requireNotNull(String value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
