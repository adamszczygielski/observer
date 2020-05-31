package allegro.application.quartz;

import allegro.application.service.JobService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemJob implements Job {

    @Autowired
    private JobService jobService;

    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public void execute(JobExecutionContext arg0) {
        log.log(Level.INFO, "---------- Job started at: " + new Timestamp(System.currentTimeMillis()));
        jobService.execute();
        log.log(Level.INFO, "---------- Job stopped at: " + new Timestamp(System.currentTimeMillis()));
    }
}
