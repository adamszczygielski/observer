package allegro.app.job;

import allegro.app.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Configuration
@ComponentScan(basePackageClasses = ItemService.class)
public class JobTest {

    ItemService itemService;

    public JobTest(ItemService itemService) {
        this.itemService = itemService;
    }

    @Bean
    public JobTest taskBean() {
        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task started on " + new Date());
                itemService.populateDatabase();
                System.out.println("Task ended on " + new Date());
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 30000L;
        long period = 15000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);

        return null;
    }
}
