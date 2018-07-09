package allegro.app;

import allegro.app.controller.ItemController;
import allegro.app.job.JobTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = ItemController.class)
@ComponentScan(basePackageClasses = JobTest.class)
@EnableJpaRepositories("allegro.app.repository")
public class Application {

    public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}
}
