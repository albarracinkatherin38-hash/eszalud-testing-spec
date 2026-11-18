package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001: Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 1, 10, 30);

        CitaMedica cita = new CitaMedica(
                "PAC-001",
                "DOC-001",
                "ESP-001",
                fechaHora,
                "Consulta de control",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("PAC-001", cita.getPaciente());
        assertEquals("DOC-001", cita.getDoctor());
        assertEquals("ESP-001", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Consulta de control", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-007: Crear una cita con un estado válido")
    void shouldKeepValidAppointmentStatus() {
        CitaMedica cita = new CitaMedica(
                "PAC-002",
                "DOC-002",
                "ESP-002",
                LocalDateTime.of(2026, 12, 2, 15, 0),
                "Dolor de cabeza",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar los atributos después de construir el objeto")
    void shouldReturnAppointmentAttributes() {
        LocalDateTime fechaHora = LocalDateTime.of(2026, 12, 3, 9, 15);

        CitaMedica cita = new CitaMedica(
                "PAC-003",
                "DOC-003",
                "ESP-003",
                fechaHora,
                "Chequeo general",
                EstadoCita.CANCELADA
        );

        assertEquals("PAC-003", cita.getPaciente());
        assertEquals("DOC-003", cita.getDoctor());
        assertEquals("ESP-003", cita.getEspecialidad());
        assertEquals(fechaHora, cita.getFechaHora());
        assertEquals("Chequeo general", cita.getMotivo());
        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}
