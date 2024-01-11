package ExamenLogiciel.demoexam.entities;


import ExamenLogiciel.demoexam.entities.embedded.LicenceId;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Licence {
    @EmbeddedId
    private LicenceId id;
    private String text;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "license_composant",
            joinColumns = {@JoinColumn(name = "license_nom"),@JoinColumn(name = "license_version_id"),@JoinColumn(name = "license_langue")},
            inverseJoinColumns = {@JoinColumn(name = "composant_version_id"),@JoinColumn(name = "code")})
    private List<Composant> composantsLicense = new ArrayList<>();

    @ManyToMany(mappedBy = "licensesLog")
    private List<Logiciel> logicielsLicense = new ArrayList<>();

    public Licence() {
    }

    public Licence(LicenceId id, String text) {
        this.id = id;
        this.text = text;
    }

    public LicenceId getId() {
        return id;
    }

    public void setId(LicenceId id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Composant> getComposantsLicense() {
        return composantsLicense;
    }

    public void setComposantsLicense(List<Composant> composantsLicense) {
        this.composantsLicense = composantsLicense;
    }

    public List<Logiciel> getLogicielsLicense() {
        return logicielsLicense;
    }

    public void setLogicielsLicense(List<Logiciel> logicielsLicense) {
        this.logicielsLicense = logicielsLicense;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("License{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
