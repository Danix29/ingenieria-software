package es.uah.agenda.modelo;

import es.uah.agenda.util.ValidadorEmail;
import java.util.Objects;

public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String nombre, String telefono, String email, String direccion) {
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        this.direccion = direccion;
    }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre.trim();
    }

    public final void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("^\\+?[0-9]{9,15}$")) {
            throw new IllegalArgumentException("Teléfono inválido: " + telefono);
        }
        this.telefono = telefono;
    }

    public final void setEmail(String email) {
        if (!ValidadorEmail.esValido(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre()    { return nombre; }
    public String getTelefono()  { return telefono; }
    public String getEmail()     { return email; }
    public String getDireccion() { return direccion; }

    public boolean esEmailValido() {
        return ValidadorEmail.esValido(this.email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto c)) return false;
        return Objects.equals(email, c.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Contacto{nombre='%s', email='%s'}".formatted(nombre, email);
    }
}
