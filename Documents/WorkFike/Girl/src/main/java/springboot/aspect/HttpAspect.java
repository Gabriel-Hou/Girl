package springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gabriel on 18/3/26.
 **/
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义切面
     */
    @Pointcut("execution(public * com.gsafc.wechatbackend.controller..*(..))")
    public void controllerExecution() {
    }


    @Before("controllerExecution()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("进入控制器之前执行");
        //记录日志111
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        //获取类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringType()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("controllerExecution()")
    public void doAfterController(){

    }

    //                入参                    切面
    @AfterReturning(returning = "object",pointcut = "controllerExecution()")
    public void doAfterReturrning(Object object){
        logger.info("response={}",object.toString());
    }

}
