package ExamenLogiciel.demoexam.entities;


import ExamenLogiciel.demoexam.entities.embedded.ComposantId;
import jakarta.persistence.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Composant {
    @EmbeddedId
    private ComposantId id;
    private String description;
    private URL url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "nom"),
            @JoinColumn(name = "logiciel_version_id")
    })
    private Logiciel logicielCp;

    @ManyToMany(mappedBy = "composantsLicense")
    private List<Licence> licensesComposant = new ArrayList<>();

    public Composant() {

    }

    public Logiciel getLogicielCp() {
        return logicielCp;
    }

    public void setLogicielCp(Logiciel logicielCp) {
        this.logicielCp = logicielCp;
    }

    public List<Licence> getLicensesComposant() {
        return licensesComposant;
    }

    public void setLicensesComposant(List<Licence> licensesComposant) {
        this.licensesComposant = licensesComposant;
    }

    public Composant(ComposantId id, String description, URL url) {
        this.id = id;
        this.description = description;
        this.url = url;
    }

    public ComposantId getId() {
        return id;
    }

    public void setId(ComposantId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Composant{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", url=" + url +
                ", logicielCp=" + logicielCp +
                ", licensesComposant=" + licensesComposant +
                '}';
    }
}
