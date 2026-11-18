package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("CIT-002: Rechazar la creación de una cita sin identificador de paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC-001",
                        "ESP-001",
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-003: Rechazar la creación de una cita sin identificador de doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        null,
                        "ESP-001",
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-004: Rechazar la creación de una cita sin identificador de especialidad")
    void shouldRejectAppointmentWithoutSpecialty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        null,
                        LocalDateTime.of(2026, 12, 1, 10, 30),
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-005: Rechazar la creación de una cita sin fecha y hora")
    void shouldRejectAppointmentWithoutDateTime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC-001",
                        "DOC-001",
                        "ESP-001",
                        null,
                        "Consulta de control",
                        EstadoCita.PROGRAMADA
                )
        );
    }

    @Test
    @DisplayName("CIT-006: Asignar PROGRAMADA cuando el estado es nulo")
    void shouldDefaultToProgrammedStatusWhenStateIsNull() {
        CitaMedica cita = new CitaMedica(
                "PAC-004",
                "DOC-004",
                "ESP-004",
                LocalDateTime.of(2026, 12, 4, 11, 0),
                "Control",
                null
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-009: Aceptar un motivo vacío")
    void shouldAcceptAppointmentWithEmptyReason() {
        CitaMedica cita = new CitaMedica(
                "PAC-005",
                "DOC-005",
                "ESP-005",
                LocalDateTime.of(2026, 12, 5, 8, 0),
                "",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("", cita.getMotivo());
    }

    @Test
    @DisplayName("CIT-016: Aceptar un motivo compuesto solo por espacios")
    void shouldAcceptAppointmentWithBlankReason() {
        CitaMedica cita = new CitaMedica(
                "PAC-005",
                "DOC-005",
                "ESP-005",
                LocalDateTime.of(2026, 12, 5, 8, 0),
                "   ",
                EstadoCita.PROGRAMADA
        );

        assertNotNull(cita);
        assertEquals("   ", cita.getMotivo());
    }

    @Test
    @DisplayName("CIT-011: Aceptar una fecha pasada")
    void shouldAcceptAppointmentWithPastDate() {
        LocalDateTime fechaPasada = LocalDateTime.of(2020, 1, 15, 9, 0);

        CitaMedica cita = new CitaMedica(
                "PAC-006",
                "DOC-006",
                "ESP-006",
                fechaPasada,
                "Consulta histórica",
                EstadoCita.ATENDIDA
        );

        assertEquals(fechaPasada, cita.getFechaHora());
    }

    @Test
    @DisplayName("CIT-012: Conservar el estado PROGRAMADA")
    void shouldKeepProgrammedStatus() {
        CitaMedica cita = new CitaMedica(
                "PAC-007",
                "DOC-007",
                "ESP-007",
                LocalDateTime.of(2026, 12, 6, 10, 0),
                "Control",
                EstadoCita.PROGRAMADA
        );

        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-013: Conservar el estado ATENDIDA")
    void shouldKeepAttendedStatus() {
        CitaMedica cita = new CitaMedica(
                "PAC-008",
                "DOC-008",
                "ESP-008",
                LocalDateTime.of(2026, 12, 7, 10, 0),
                "Control",
                EstadoCita.ATENDIDA
        );

        assertEquals(EstadoCita.ATENDIDA, cita.getEstado());
    }

    @Test
    @DisplayName("CIT-014: Conservar el estado CANCELADA")
    void shouldKeepCancelledStatus() {
        CitaMedica cita = new CitaMedica(
                "PAC-009",
                "DOC-009",
                "ESP-009",
                LocalDateTime.of(2026, 12, 8, 10, 0),
                "Control",
                EstadoCita.CANCELADA
        );

        assertEquals(EstadoCita.CANCELADA, cita.getEstado());
    }
}
