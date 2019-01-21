package allegro.application.quartz;

import allegro.application.service.ItemService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemJob implements Job {

    @Autowired
    private ItemService itemService;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        itemService.populateDatabase();
    }
}
