# Decisiones de negocio – Capa Model EsZalud

Este documento registra las decisiones adoptadas para la implementación de la capa Model,
de acuerdo con la sección 8 de la Especificación Formal de Pruebas Unitarias (EFP).

## 1. Identificadores

- Las referencias a paciente, doctor y especialidad se representan mediante `String`.
- En `CitaMedica`, los campos `paciente`, `doctor` y `especialidad` son obligatorios
  y no pueden ser `null`.
- Estos identificadores se validan únicamente contra `null`, porque representan
  referencias a otros registros y la EFP no exige validar su contenido.

## 2. Campos obligatorios

Se rechaza la creación del objeto con `IllegalArgumentException` cuando un campo
obligatorio de texto es `null`, una cadena vacía (`""`) o una cadena compuesta
únicamente por espacios.

| Modelo | Campos obligatorios |
|---|---|
| `Paciente` | `documento`, `nombres`, `apellidos` |
| `Doctor` | `documento`, `nombres`, `apellidos`, `colegiatura` |
| `Especialidad` | `nombre` |
| `CitaMedica` | `paciente`, `doctor`, `especialidad`, `fechaHora` |

En `CitaMedica`, `fechaHora` es de tipo `LocalDateTime` y solo se valida contra `null`.

## 3. Campos opcionales

Los siguientes campos son opcionales y aceptan `null` y cadena vacía:

| Modelo | Campos opcionales |
|---|---|
| `Paciente` | `telefono`, `correo` |
| `Doctor` | `especialidad` |
| `Especialidad` | `descripcion` |
| `CitaMedica` | `motivo` |

No se establecen longitudes máximas ni formatos específicos para los campos de texto,
porque la EFP no define una regla de negocio que los justifique.

## 4. Fechas

- `fechaHora` de `CitaMedica` es obligatoria y no puede ser `null`.
- Se permiten fechas pasadas; no se implementa una restricción de fecha futura.

## 5. Estados de la cita

- Los estados válidos son `PROGRAMADA`, `ATENDIDA` y `CANCELADA`, representados
  mediante el enum `EstadoCita`.
- Si al crear una cita el estado recibido es `null`, se asigna automáticamente
  el estado `PROGRAMADA`.
- No se definen transiciones entre estados en esta versión.

## 6. Fuera de alcance

- No se implementan reglas que requieran consultar otros registros, como verificar
  que el paciente o el doctor existan.
- No se implementa persistencia, CRUD, integración con MongoDB ni componentes de
  interfaz gráfica en la capa Model.

## 7. Pruebas adicionales

Se implementaron las pruebas recomendadas de la sección 7 de la EFP que son
compatibles con las decisiones anteriores:

| Modelo | Pruebas implementadas |
|---|---|
| `Paciente` | PAC-006 a PAC-009 (documento, nombres y apellidos vacíos o con espacios) y PAC-012 (correo `null` aceptado) |
| `Doctor` | DOC-007 a DOC-009 (campos obligatorios vacíos) y DOC-011, DOC-012 (especialidad vacía o `null` aceptada por ser opcional) |
| `Especialidad` | ESP-004, ESP-005 (nombre vacío o con espacios) y ESP-006, ESP-007 (descripción vacía o `null` aceptada) |
| `CitaMedica` | CIT-009, CIT-016 (motivo vacío o con espacios aceptado), CIT-011 (fecha pasada aceptada) y CIT-012 a CIT-014 (estados válidos) |

Las siguientes pruebas recomendadas no aplican a esta versión:

| Prueba | Motivo |
|---|---|
| PAC-010, PAC-011 | No se valida el formato de correo ni de teléfono. |
| DOC-010 | No se valida el formato de la colegiatura. |
| CIT-010 | `LocalDateTime` impide representar una fecha y hora inválida. |
| CIT-015 | El enum `EstadoCita` impide representar un estado no reconocido. |
