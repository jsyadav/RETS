package com.irets.scheduler.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.irets.bl.service.ResidentialPropertyServices;
import com.irets.logging.domain.AppLogger;

public class FullDataFetcher extends QuartzJobBean {
	
	private AppLogger logger = AppLogger.getLogger(FullDataFetcher.class);
	
	@Override
	protected void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException {
		ApplicationContext context = null;
		try {
			context = getApplicationContext(ctx);
		} catch (JobExecutionException jee) {
			logger.error(jee.getMessage(), jee);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		ResidentialPropertyServices rps = (ResidentialPropertyServices) context.getBean("ResidentialPropertyServices");
		rps.fetchFullData();
	}
	
	private ApplicationContext getApplicationContext(JobExecutionContext context ) throws Exception {

		ApplicationContext appCtx = null;
	    appCtx = (ApplicationContext)context.getScheduler().getContext().get("applicationContext");
	    if (appCtx == null) {
	    	throw new JobExecutionException(
	    		   	"No application context available in scheduler context for key \" applicationContext \"");
	    }
	    return appCtx;		
	}

}
