package com.p2.recApp.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.p2.recApp.login.LoginPOJO;

//import ch.qos.logback.classic.Logger;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
//	AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(ConfigClass.class);
//	LoginPOJO login = context.getBean("loginPOJO", LoginPOJO.class);
//	login.loginData();
	
	public final static Logger logger = Logger.getLogger("AOP Logger");
//	@Before("execution(public String login1(...)) ")
	public LoggingAspect() {
		logger.info("***********from loging");
	}
	
//	private Logger logger = Logger.getLogger("LoggingAspect");

}
