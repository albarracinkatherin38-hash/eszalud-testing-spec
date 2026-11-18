package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DoctorTest {

    @Test
    @DisplayName("DOC-001: Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "44556677",
                "Carlos",
                "Ramos",
                "CMP-12345",
                "ESP-001"
        );

        assertNotNull(doctor);
        assertEquals("44556677", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ramos", doctor.getApellidos());
        assertEquals("CMP-12345", doctor.getColegiatura());
        assertEquals("ESP-001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("DOC-006: Verificar los atributos después de construir el objeto")
    void shouldReturnDoctorAttributes() {
        Doctor doctor = new Doctor(
                "11223344",
                "María",
                "Torres",
                "CMP-67890",
                "ESP-002"
        );

        assertEquals("11223344", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("Torres", doctor.getApellidos());
        assertEquals("CMP-67890", doctor.getColegiatura());
        assertEquals("ESP-002", doctor.getEspecialidad());
    }
}
