package observer.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@EnableJpaRepositories("observer.application.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);
        app.build().addListeners(new ApplicationPidFileWriter("./shutdown.pid"));
        app.run(args);
    }
}
