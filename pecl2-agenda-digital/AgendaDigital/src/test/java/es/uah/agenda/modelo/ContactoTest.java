package es.uah.agenda.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ContactoTest {

    @Test
    void creacionValidaDebeAsignarCampos() {
        Contacto c = new Contacto("Ana", "+34600111222", "ana@uah.es", "C/ Mayor 1");
        assertEquals("Ana", c.getNombre());
        assertEquals("ana@uah.es", c.getEmail());
        assertTrue(c.esEmailValido());
    }

    @ParameterizedTest
    @ValueSource(strings = {"sin-arroba", "a@b", "@uah.es", "espacio @uah.es"})
    void emailsInvalidosDebenLanzarExcepcion(String email) {
        assertThrows(IllegalArgumentException.class,
            () -> new Contacto("Ana", "+34600111222", email, "dir"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "abcdefghij", "+34 600 111 222"})
    void telefonosInvalidosDebenLanzarExcepcion(String tel) {
        assertThrows(IllegalArgumentException.class,
            () -> new Contacto("Ana", tel, "ana@uah.es", "dir"));
    }

    @Test
    void nombreNuloOVacioDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contacto(null, "+34600111222", "ana@uah.es", "dir"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contacto("   ", "+34600111222", "ana@uah.es", "dir"));
    }

    @Test
    void equalsBasadoEnEmail() {
        Contacto c1 = new Contacto("Ana", "+34600111222", "ana@uah.es", "d1");
        Contacto c2 = new Contacto("Ana Bis", "+34600333444", "ana@uah.es", "d2");
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
