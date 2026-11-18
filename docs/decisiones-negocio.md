# Decisiones de negocio – Capa Model EsZalud

Este documento registra las decisiones adoptadas para la implementación de la capa Model,
de acuerdo con la sección 8 de la Especificación Formal de Pruebas Unitarias (EFP).

## 1. Identificadores

- Las referencias a paciente, doctor y especialidad se representan mediante `String`.
- En `CitaMedica`, los campos `paciente`, `doctor` y `especialidad` son obligatorios
  y no pueden ser `null`.

## 2. Campos obligatorios

Se rechaza la creación del objeto con `IllegalArgumentException` cuando el campo
obligatorio correspondiente es `null`.

| Modelo | Campos obligatorios |
|---|---|
| `Paciente` | `documento`, `nombres`, `apellidos` |
| `Doctor` | `documento`, `nombres`, `apellidos`, `colegiatura` |
| `Especialidad` | `nombre` |
| `CitaMedica` | `paciente`, `doctor`, `especialidad`, `fechaHora` |

## 3. Campos opcionales

Los siguientes campos son opcionales y aceptan `null`:

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

La sección 7 de la EFP propone pruebas adicionales (documento vacío, cadenas con
solo espacios, formatos de correo, etc.). No forman parte del mínimo obligatorio
y no se implementan en esta versión. Si se incorporan posteriormente, este documento
deberá actualizarse con las reglas correspondientes.
