package pe.saludpublica.model;

/**
 * Modelo que representa a un doctor.
 */
public class Doctor {

    private final String documento;
    private final String nombres;
    private final String apellidos;
    private final String colegiatura;
    private final String especialidad;

    public Doctor(String documento, String nombres, String apellidos, String colegiatura, String especialidad) {
        requireNotNull(documento, "El documento es obligatorio");
        requireNotNull(nombres, "Los nombres son obligatorios");
        requireNotNull(apellidos, "Los apellidos son obligatorios");
        requireNotNull(colegiatura, "La colegiatura es obligatoria");

        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.colegiatura = colegiatura;
        this.especialidad = especialidad;
    }

    private static void requireNotNull(String value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
