package es.uah.agenda.util;

import java.util.regex.Pattern;

public final class ValidadorEmail {

    // RFC 5322 simplificado: cubre la mayoría de casos reales sin complejidad excesiva
    private static final Pattern PATRON_EMAIL = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    private ValidadorEmail() {
        throw new AssertionError("Clase de utilidad, no instanciable");
    }

    public static boolean esValido(String email) {
        return email != null && PATRON_EMAIL.matcher(email).matches();
    }
}
