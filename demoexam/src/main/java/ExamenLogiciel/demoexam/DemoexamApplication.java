package ExamenLogiciel.demoexam;

import ExamenLogiciel.demoexam.entities.Catégorie;
import ExamenLogiciel.demoexam.entities.Logiciel;
import ExamenLogiciel.demoexam.entities.Version;
import ExamenLogiciel.demoexam.entities.embedded.LogicielId;
import ExamenLogiciel.demoexam.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoexamApplication {
	@Autowired
	LogicielRepository logicielRepository;
	@Autowired
	VersionRepository versionRepository;
	@Autowired
	CatégorieRepository catégorieRepository;
	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	LibrairieRepository librairieRepository;
	@Autowired
	LicenceRepository licenceRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoexamApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			Version version1 = new Version(1, 0);
			Version version2 = new Version(2, 3);
			versionRepository.saveAll(List.of(version1, version2));
			Logiciel logiciel1 = new Logiciel(new LogicielId("Vs Code", version1), "Description of vs code", new URL("https://vscode.dev/"));
			Logiciel logiciel2 = new Logiciel(new LogicielId("Intellij", version2), "Description of Intellij", new URL("https://www.jetbrains.com/idea"));
			Logiciel logiciel3 = new Logiciel(new LogicielId("Fortnite", version2), "Description of Fortnite", new URL("https://www.fortnite.com/"));
			this.logicielRepository.saveAll(List.of(logiciel1, logiciel2, logiciel3));
			System.out.println(this.logicielRepository.findAll());
			Catégorie ide = new Catégorie("IDEs");
			Catégorie games = new Catégorie("Games");
			Catégorie applications = new Catégorie("Applications");
			catégorieRepository.saveAll(List.of(ide, games, applications));
			logiciel1.setPrincipalCategory(ide);
			logiciel1.setCategories(Arrays.asList(applications));
			logiciel3.setPrincipalCategory(games);
			logiciel3.setCategories(Arrays.asList(applications));
			logiciel2.setPrincipalCategory(ide);
			logiciel2.setCategories(Arrays.asList(applications));
			System.out.println(this.catégorieRepository.findAll());
			System.out.println(this.logicielRepository.findAll());

		};
	}
}

