<img src="https://capsule-render.vercel.app/api?type=waving&color=C87000&height=160&section=header&text=ingenieria-software&fontSize=28&fontColor=FFFFFF&fontAlignY=40&desc=IS%20%7C%20UAH%202025-26&descAlignY=60&descColor=FFD895" width="100%"/>

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![UML](https://img.shields.io/badge/UML-5C2D91?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![UAH](https://img.shields.io/badge/UAH-GII-085041?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-5DCAA5?style=for-the-badge)

</div>

---

## About

**Asignatura:** Ingeniería del Software &middot; UAH GII &middot; Curso 2025-26

Introduction to software engineering principles and practice. Requirements engineering, UML modelling, object-oriented design and implementation with Java, and systematic software testing.

---

## Topics covered

| Block | Content |
|-------|---------|
| Requirements engineering | Stakeholder analysis, functional/non-functional requirements, IEEE 830 SRS format |
| Use case modelling | Use case diagrams, use case descriptions, actors and relationships |
| UML design | Class diagrams, sequence diagrams, deployment diagrams (Draw.io / StarUML) |
| OOP with Java | Inheritance, encapsulation, polymorphism, interfaces, abstract classes |
| Testing | Unit testing with JUnit 5, cyclomatic complexity V(G), basis paths, white-box / black-box |
| Reverse engineering | Deriving design artifacts from existing code, documentation from implementation |
| Software process | Software lifecycle models, development processes, quality metrics |

---

## Practices

| # | Name | Description | Stack |
|---|------|-------------|-------|
| PECL1 | [talleres-mecanicos](./pecl1-talleres-mecanicos/) | SRS (IEEE 830) + full UML suite (use cases, class, sequence ×4, deployment diagrams) for a national chain of mechanic workshops | Draw.io |
| PECL2 | [agenda-digital](./pecl2-agenda-digital/) | Digital agenda class hierarchy with inheritance (contacts, appointments, tasks), JUnit unit tests, cyclomatic complexity analysis and black/white-box testing of a stock-management function | Java · Maven · JUnit |

---

## Project structure

```
ingenieria-software/
├── pecl1-talleres-mecanicos/
│   ├── RodríguezPaisDelNogal.pdf
│   └── DiagramasDraw.io/
│       ├── DiagramaCasosDeUso.drawio
│       ├── DiagramaClase.drawio
│       ├── DiagramaDespliegue.drawio
│       ├── DiagramaSecuenciaCajero.drawio
│       ├── DiagramaSecuenciaComercial.drawio
│       ├── DiagramaSecuenciaGestor.drawio
│       └── DiagramaSecuenciaMecanico.drawio
└── pecl2-agenda-digital/
    ├── PaisDelNogalRodriguez.pdf
    └── AgendaDigital/
        ├── pom.xml
        └── src/
            ├── main/java/es/uah/agenda/
            │   ├── Main.java
            │   ├── modelo/
            │   │   ├── Contacto.java
            │   │   ├── ContactoProfesional.java
            │   │   ├── Cita.java
            │   │   ├── CitaTrabajo.java
            │   │   ├── Tarea.java
            │   │   ├── TareaSeguimiento.java
            │   │   ├── Estado.java
            │   │   └── Prioridad.java
            │   └── util/ValidadorEmail.java
            └── test/java/es/uah/agenda/modelo/
                ├── CitaTest.java
                ├── CitaTrabajoTest.java
                ├── ContactoTest.java
                ├── ContactoProfesionalTest.java
                ├── TareaTest.java
                └── TareaSeguimientoTest.java
```
---

<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=C87000&height=100&section=footer" width="100%"/>

*Ingeniería del Software &middot; UAH GII &middot; 2025-26*
</div>
