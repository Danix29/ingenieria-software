package es.uah.agenda.modelo;

import java.util.Comparator;
import java.util.Objects;

public class Tarea implements Comparable<Tarea> {

    // Orden: CRITICA (4) primero → BAJA (1) último
    public static final Comparator<Tarea> POR_PRIORIDAD_DESC =
        Comparator.comparingInt((Tarea t) -> t.prioridad.getNivel()).reversed();

    private String descripcion;
    private Prioridad prioridad;
    private Estado estado;

    public Tarea(String descripcion, Prioridad prioridad, Estado estado) {
        setDescripcion(descripcion);
        setPrioridad(prioridad);
        setEstado(estado);
    }

    public final void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("Descripción no puede ser nula o vacía");
        }
        this.descripcion = descripcion.trim();
    }

    public final void setPrioridad(Prioridad prioridad) {
        this.prioridad = Objects.requireNonNull(prioridad, "Prioridad no puede ser nula");
    }

    public final void setEstado(Estado estado) {
        this.estado = Objects.requireNonNull(estado, "Estado no puede ser nulo");
    }

    public String getDescripcion() { return descripcion; }
    public Prioridad getPrioridad() { return prioridad; }
    public Estado getEstado() { return estado; }

    public void completar() {
        this.estado = Estado.COMPLETADA;
    }

    /** Orden natural: por prioridad descendente. */
    @Override
    public int compareTo(Tarea otra) {
        return POR_PRIORIDAD_DESC.compare(this, otra);
    }

    @Override
    public String toString() {
        return "Tarea{desc='%s', prio=%s, estado=%s}"
                .formatted(descripcion, prioridad, estado);
    }
}
