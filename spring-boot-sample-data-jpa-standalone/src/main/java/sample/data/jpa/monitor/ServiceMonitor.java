package sample.data.jpa.monitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class ServiceMonitor {
	
	private static Logger LOGGER = LogManager.getLogger(ServiceMonitor.class);
	@Before("execution(public * sample.data.jpa.web.*.*(..))")
	public void traceService(JoinPoint joinPoint) {
		LOGGER.info("Completed: " + joinPoint);
	}
	
	
}
