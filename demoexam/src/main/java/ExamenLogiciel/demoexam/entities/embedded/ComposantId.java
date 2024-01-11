package ExamenLogiciel.demoexam.entities.embedded;

import ExamenLogiciel.demoexam.entities.Version;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ComposantId implements Serializable {
    private String Code ;
    @ManyToOne
    @JoinColumn(name = "composant_version_id")
    private Version composantVersion;


    public ComposantId(String code, Version composantVersion) {
        Code = code;
        this.composantVersion = composantVersion;
    }

    public ComposantId() {
         super();
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Version getComposantVersion() {
        return composantVersion;
    }

    public void setComposantVersion(Version composantVersion) {
        this.composantVersion = composantVersion;
    }

    @Override
    public String toString() {
        return "ComposantId{" +
                "Code='" + Code + '\'' +
                ", composantVersion=" + composantVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComposantId that)) return false;
        return Objects.equals(Code, that.Code) && Objects.equals(composantVersion, that.composantVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Code, composantVersion);
    }
}
