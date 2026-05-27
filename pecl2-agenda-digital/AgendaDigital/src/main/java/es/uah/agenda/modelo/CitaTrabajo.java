package es.uah.agenda.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitaTrabajo extends Cita {

    private final List<String> agendaTemas;

    public CitaTrabajo(LocalDateTime fechaHora, Duration duracion, String lugar,
                       List<Contacto> participantes, List<String> agendaTemas) {
        super(fechaHora, duracion, lugar, participantes);
        this.agendaTemas = new ArrayList<>(agendaTemas != null ? agendaTemas : List.of());
    }

    public boolean añadirTema(String tema) {
        if (tema == null || tema.isBlank()) return false;
        return agendaTemas.add(tema.trim());
    }

    public boolean eliminarTema(String tema) {
        return agendaTemas.remove(tema);
    }

    public List<String> getAgendaTemas() {
        return Collections.unmodifiableList(agendaTemas);
    }

    /** Duración estimada = duración programada de la cita. */
    public Duration getDuracionEstimada() {
        return getDuracion();
    }

    @Override
    public String toString() {
        return "CitaTrabajo{fecha=%s, lugar='%s', temas=%d}"
                .formatted(getFechaHora(), getLugar(), agendaTemas.size());
    }
}
