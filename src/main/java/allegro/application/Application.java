package allegro.application;

import allegro.application.controller.ItemController;
import allegro.application.job.JobTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = ItemController.class)
@ComponentScan(basePackageClasses = JobTest.class)
@EnableJpaRepositories("allegro.application.repository")
public class Application {

    public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}
}
