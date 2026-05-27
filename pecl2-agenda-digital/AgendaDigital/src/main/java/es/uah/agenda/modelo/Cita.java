package es.uah.agenda.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cita implements Comparable<Cita> {

    private LocalDateTime fechaHora;
    private Duration duracion;
    private String lugar;
    private final List<Contacto> participantes;

    public Cita(LocalDateTime fechaHora, Duration duracion, String lugar, List<Contacto> participantes) {
        setFechaHora(fechaHora);
        setDuracion(duracion);
        setLugar(lugar);
        this.participantes = new ArrayList<>(Objects.requireNonNullElse(participantes, List.of()));
    }

    public final void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha/hora no puede ser nula");
        }
        this.fechaHora = fechaHora;
    }

    public final void setDuracion(Duration duracion) {
        if (duracion == null || duracion.isNegative() || duracion.isZero()) {
            throw new IllegalArgumentException("Duración debe ser positiva");
        }
        this.duracion = duracion;
    }

    public final void setLugar(String lugar) {
        if (lugar == null || lugar.isBlank()) {
            throw new IllegalArgumentException("El lugar no puede ser nulo o vacío");
        }
        this.lugar = lugar.trim();
    }

    public LocalDateTime getFechaHora()      { return fechaHora; }
    public Duration getDuracion()            { return duracion; }
    public String getLugar()                 { return lugar; }
    public List<Contacto> getParticipantes() { return Collections.unmodifiableList(participantes); }

    public LocalDateTime getFechaFin() {
        return fechaHora.plus(duracion);
    }

    public boolean añadirParticipante(Contacto c) {
        return c != null && !participantes.contains(c) && participantes.add(c);
    }

    public boolean eliminarParticipante(Contacto c) {
        return participantes.remove(c);
    }

    /**
     * Detecta solapamiento temporal: [ini1, fin1) ∩ [ini2, fin2) ≠ ∅
     * Complejidad: O(1).
     */
    public boolean tieneConflictoCon(Cita otra) {
        if (otra == null || otra == this) return false;
        return this.fechaHora.isBefore(otra.getFechaFin())
            && otra.getFechaHora().isBefore(this.getFechaFin());
    }

    @Override
    public int compareTo(Cita otra) {
        return this.fechaHora.compareTo(otra.fechaHora);
    }

    @Override
    public String toString() {
        return "Cita{fecha=%s, lugar='%s', duracion=%dmin}"
                .formatted(fechaHora, lugar, duracion.toMinutes());
    }
}
