package ExamenLogiciel.demoexam.entities.embedded;


import ExamenLogiciel.demoexam.entities.Version;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LogicielId implements Serializable {
    private String nom;
    @ManyToOne
    @JoinColumn(name = "logiciel_version_id")
    private Version logicielVersion;

    public LogicielId() {

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Version getLogicielVersion() {
        return logicielVersion;
    }

    public void setLogicielVersion(Version logicielVersion) {
        this.logicielVersion = logicielVersion;
    }

    public LogicielId(String nom, Version logicielVersion) {
        this.nom = nom;
        this.logicielVersion = logicielVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicielId that)) return false;
        return Objects.equals(nom, that.nom) && Objects.equals(logicielVersion, that.logicielVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, logicielVersion);
    }

    @Override
    public String toString() {
        return "LogicielId{" +
                "nom='" + nom + '\'' +
                ", logicielVersion=" + logicielVersion +
                '}';
    }
}
