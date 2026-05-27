package es.uah.agenda.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TareaSeguimiento extends Tarea {

    private LocalDate fechaLimite;
    private final List<Contacto> responsables;

    public TareaSeguimiento(String descripcion, Prioridad prioridad, Estado estado,
                            LocalDate fechaLimite, List<Contacto> responsables) {
        super(descripcion, prioridad, estado);
        setFechaLimite(fechaLimite);
        this.responsables = new ArrayList<>(Objects.requireNonNullElse(responsables, List.of()));
    }

    public final void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = Objects.requireNonNull(fechaLimite, "Fecha límite no puede ser nula");
    }

    public LocalDate getFechaLimite() { return fechaLimite; }

    public List<Contacto> getResponsables() {
        return Collections.unmodifiableList(responsables);
    }

    public boolean asignarResponsable(Contacto c) {
        return c != null && !responsables.contains(c) && responsables.add(c);
    }

    public boolean eliminarResponsable(Contacto c) {
        return responsables.remove(c);
    }

    /** Una tarea está vencida si hoy > fechaLimite y no está completada/cancelada. */
    public boolean estaVencida() {
        if (getEstado() == Estado.COMPLETADA || getEstado() == Estado.CANCELADA) {
            return false;
        }
        return LocalDate.now().isAfter(fechaLimite);
    }

    @Override
    public String toString() {
        return "TareaSeguimiento{desc='%s', prio=%s, limite=%s, responsables=%d}"
                .formatted(getDescripcion(), getPrioridad(), fechaLimite, responsables.size());
    }
}
