# Documento de Visión 

**Proyecto:** Mi consultorio
**Versión:** 1.0
**Fecha:** 2026
---

# 1. Introducción
## 1.1 Propósito

El propósito de este documento es definir la visión, el alcance y las necesidades de los interesados para el sistema **Mi Consultorio**. Este documento servirá como base para las etapas de análisis, diseño y desarrollo del software, garantizando que la solución desarrollada satisfaga las necesidades del consultorio y mantega una visión compartida entre todos los interesados.

---

## 1.2 Descripción del producto

**Mi Consultorio** es una aplicación web orientada a consultorios médicos pequeños que permite registrar usuarios y gestionar citas médicas de manera sencilla, organizada y segura.
El sistema está diseñado para consultorios independientes que ofrecen servicios de medicina general y odontología.

---

## 1.4 Alcance del producto

### El sistema incluirá:

- Registro de usuarios.
- Inicio de sesión.
- Recuperación de contraseña mediante un enlace enviado al correo electrónico registrado.
- Gestión de disponibilidad del médico.
- Agendamiento de citas.
- Consulta de citas programadas.
- Cancelación de citas.
- Gestión básica de pacientes.
- Gestión de roles y permisos por parte del administrador.

### El sistema no incluirá

- Historias clínicas.
- Pagos electrónicos.
- Facturación.
- Fórmulas médicas.
- Videoconsultas.
- Notificaciones automaticas.

El sistema está diseñado pra consultorios médicos pequeños y no pretende reemplazar un sistema integral de gestión hospitalaria. 

---

## 1.5 Contexto del negocio

Muchos consultorios médicos pequeños administran sus citas mediante llamadas telefónicas, aplicaciones de mensajería o agendas físicas, lo que puede generar errores en la programación, perdida de información y duplicidad en la citas.

**Mi Consultorio** busca centralizar este proceso mediante una aplicación web sencilla que facilite el trabajo diario del médico, la recepcionista y los pacientes.

---

## 1.6 Definiciones

| Término | Definición |
|----------|------------|
| **Médico** | Profesional de la salud encargado de prestar atención médica. |
| **Paciente** | Usuario que solicita y recibe los servicios médicos del consultorio. |
| **Recepcionista** | Usuario encargado del registro de pacientes y la gestión de citas cuando sea necesario. |
| **Administrador** | Usuario con permisos para administrar roles, permisos y configuraciones generales del sistema. En consultorios pequeños este rol puede ser desempeñado por el médico si es necesario. |
| **Disponibilidad** | Horarios habilitados por el médico para recibir pacientes. |
| **Cita médica** | Espacio de tiempo con una fecha y hora específicas entre un paciente y un médico. |

## 1.7 Referencias

- IEEE 29148 
- Ley 1581 de 2012 -  Régimen general de protección de datos personales (Habeas Data - Colombia)

---

# 2. Descripción general

## 2.1 Perspectiva del producto

Mi Consultorio será una aplicación web independiente desplegada en la nube, accesible desde navegadores modernos y diseñada para funcionar correctamente tanto en dispositivos móviles como en computadores de escritorio.

---

## 2.2 Funciones del producto

| ID | Función | Descripción |
|----|----------|-------------|
| CAP-01 | Autenticación | Registro de usuarios, inicio de sesión y recuperación de contraseña. |
| CAP-02 | Gestión de usuarios | Administración básica de pacientes. |
| CAP-03 | Gestión de disponibilidad | Configuración de los horarios de atención del médico. |
| CAP-04 | Agendamiento | Registro de citas según la especialidad y la disponibilidad existente. |
| CAP-05 | Consulta de citas | Visualización de las citas programadas. |
| CAP-06 | Cancelación de citas | Cancelación de citas previamente agendadas. |
| CAP-07 | Gestión de roles y permisos | Administración de permisos y roles de acceso al sistema. |

---

## 2.3 Características de los usuarios

### Paciente

- Posee conocimientos básicos de informática.
- Puede registrarse, consultar, agendar y cancelar sus citas.

### Médico

- Profesional de la salud.
- Consulta su agenda.
- Gestiona su disponibilidad.
- En consultorios pequeños puede asumir también las funciones del administrador.

### Recepcionista

- Administra el registro de pacientes.
- Agenda, consulta y cancela citas.
- Requiere una interfaz sencilla y rapida.

### Administrador

- Configura los permisos del sistema.
. Gestiona los roles de usuario.
- Realiza configuraciones generales del sistema.

---

# 3. Requisitos de alto nivel

## 3.1 Requisitos funcionales

| ID | Requisito |
|----|------------|
| REQ-F-01 | El sistema deberá permitir el registro de nuevos usuarios. |
| REQ-F-02 | El sistema deberá permitir el inicio de sesión de pacientes, recepcionistas, médicos y administradores. |
| REQ-F-03 | El sistema deberá permitir recuperar la contraseña mediante un enlace enviado al correo electrónico registrado. |
| REQ-F-04 | El sistema deberá permitir al médico configurar su disponibilidad. |
| REQ-F-05 | El sistema deberá permitir agendar citas únicamente en horarios disponibles. |
| REQ-F-06 | El sistema deberá impedir la asignación de dos citas para el mismo médico, fecha y hora. |
| REQ-F-07 | El sistema deberá permitir consultar las citas programadas. |
| REQ-F-08 | El paciente podrá cancelar una cita con al menos dos horas de anticipación. |
| REQ-F-09 | La recepcionista podrá cancelar una cita cuando sea necesario. |
| REQ-F-10 | El administrador podrá gestionar los roles y permisos de los usuarios. |
| REQ-F-11 | El sistema deberá mostrar mensajes claros cuando ocurra un error durante su uso. |


## 3.2 Requisitos no funcionales

| ID | Requisito |
|----|------------|
| REQ-NF-01 | Las contraseñas deberán almacenarse utilizando un algoritmo de hash seguro. |
| REQ-NF-02 | La interfaz deberá ser responsiva y funcionar correctamente en dispositivos móviles y computadores. |
| REQ-NF-03 | El tiempo de respuesta para consultar la agenda no deberá superar los tres segundos bajo condiciones normales. |
| REQ-NF-04 | Toda la comunicación entre cliente y servidor deberá realizarse mediante HTTPS. |

---

## 3.3 Riesgos del proyecto

| Riesgo | Impacto | Estrategia de mitigación |
|---------|---------|--------------------------|
| Retrasos en el desarrollo | Medio | Planificar el proyecto mediante Kanban y realizar entregas incrementales. |
| Errores en el registro de información | Medio | Implementar validaciones en formularios y mensajes de error claros. |
| Pérdida de información | Alto | Realizar copias de seguridad periódicas de la base de datos. |
| Cambios en los requisitos | Medio | Priorizar funcionalidades esenciales y controlar el alcance del proyecto. |

---

