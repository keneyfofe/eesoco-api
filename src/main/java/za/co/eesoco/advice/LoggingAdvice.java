package za.co.eesoco.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {
	
	//step 2
	// Create the Logger instance, sl4j
	 Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	//Step 3.
	//The use of pointcut provided in spring AOP to identify the path, where this aspect will be implemented, in this case we want to implement AOP accross the application
	 @Pointcut(value = "execution(* za.co.eesoco.*.*.*(..) )")
	 public void myPointcut() {
		 
		 	 
	 }
	
	//Step 1./Step4
	 @Pointcut("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object [] array = pjp.getArgs(); // to get what is comming from the controllers methods
		
		// use log, this will be the Before Advice
		log.info( "method invoked"+ className + " : " + methodName + "()" + "arguments:" + mapper.writeValueAsString(array));
		
		Object object = pjp.proceed(); // holds the response from the controller method calls
		// use log, this will be the After and Around Advice
		log.info( className + " : " + methodName + "()" + "Response" + mapper.writeValueAsString(object));
		return object;
		
		
	}

}
