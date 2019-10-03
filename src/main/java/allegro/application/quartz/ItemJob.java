package allegro.application.quartz;

import allegro.application.service.ApplicationService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemJob implements Job {

    @Autowired
    private ApplicationService itemService;
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public void execute(JobExecutionContext arg0) {
        log.log(Level.INFO, "---------- Job started at: " + new Timestamp(System.currentTimeMillis()));
        itemService.updateDatabase();
        log.log(Level.INFO, "---------- Job stopped at: " + new Timestamp(System.currentTimeMillis()));
    }
}
