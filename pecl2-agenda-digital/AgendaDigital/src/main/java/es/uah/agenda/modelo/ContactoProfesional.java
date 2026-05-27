package es.uah.agenda.modelo;

public class ContactoProfesional extends Contacto {

    private String empresa;
    private String cargo;

    public ContactoProfesional(String nombre, String telefono, String email,
                               String direccion, String empresa, String cargo) {
        super(nombre, telefono, email, direccion);
        setEmpresa(empresa);
        setCargo(cargo);
    }

    public final void setEmpresa(String empresa) {
        if (empresa == null || empresa.isBlank()) {
            throw new IllegalArgumentException("Empresa no puede ser nula o vacía");
        }
        this.empresa = empresa.trim();
    }

    public final void setCargo(String cargo) {
        if (cargo == null || cargo.isBlank()) {
            throw new IllegalArgumentException("Cargo no puede ser nulo o vacío");
        }
        this.cargo = cargo.trim();
    }

    public String getEmpresa() { return empresa; }
    public String getCargo()   { return cargo; }

    @Override
    public String toString() {
        return "ContactoProfesional{nombre='%s', empresa='%s', cargo='%s'}"
                .formatted(getNombre(), empresa, cargo);
    }
}
