package no.nav.kafka.streams;

import java.util.Objects;

public class Resultat {
    private final String stedsnavn;
    private final Long antall;


    public Resultat(String stedsnavn, Long antall) {
        this.stedsnavn = stedsnavn;
        this.antall = antall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resultat resultat = (Resultat) o;
        return Objects.equals(stedsnavn, resultat.stedsnavn) &&
            Objects.equals(antall, resultat.antall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stedsnavn, antall);
    }

    @Override
    public String toString() {
        return "Resultat{" +
            "stedsnavn='" + stedsnavn + '\'' +
            ", antall=" + antall +
            '}';
    }
}

