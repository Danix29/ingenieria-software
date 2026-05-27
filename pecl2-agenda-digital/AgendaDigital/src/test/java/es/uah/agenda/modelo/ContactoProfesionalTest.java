package es.uah.agenda.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactoProfesionalTest {

    @Test
    void creacionValida() {
        ContactoProfesional cp = new ContactoProfesional(
            "Luis", "+34699888777", "luis@acme.com", "Av. Principal 10",
            "ACME", "CTO"
        );
        assertEquals("ACME", cp.getEmpresa());
        assertEquals("CTO", cp.getCargo());
        assertTrue(cp instanceof Contacto);
    }

    @Test
    void empresaVaciaDebeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new ContactoProfesional(
            "Luis", "+34699888777", "luis@acme.com", "dir", "  ", "CTO"));
    }

    @Test
    void cargoNuloDebeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new ContactoProfesional(
            "Luis", "+34699888777", "luis@acme.com", "dir", "ACME", null));
    }
}
