package ExamenLogiciel.demoexam.entities;


import ExamenLogiciel.demoexam.entities.embedded.LogicielId;
import jakarta.persistence.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Application extends Logiciel {
    @Id
    @Column(name="url",nullable = false,unique = true)
    private URL url;
    @ManyToMany(mappedBy = "applications",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Logiciel> logiciels = new ArrayList<>();


    public Application(LogicielId id, String description, URL url) {
        super(id, description, url);
    }

    public Application() {
        super();

    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public void setUrl(URL url) {
        this.url = url;
    }

    public List<Logiciel> getLogiciels() {
        return logiciels;
    }

    public void setLogiciels(List<Logiciel> logiciels) {
        this.logiciels = logiciels;
    }
}
