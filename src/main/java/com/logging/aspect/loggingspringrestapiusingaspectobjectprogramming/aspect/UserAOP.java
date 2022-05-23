package com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.aspect;

import com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.utile.DataType;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 Component: The aspect class must be Component Bean inside the spring context.
 Aspect: We need to write @Aspect above the class to interrupt each advice inside it.
 Log4j2: from Lombok for logger any message and debug the code
 **/

@Component
@Aspect
@Log4j2
public class UserAOP {
    /**
     * the following code will represent api Point cut value to set and reuse it inside any point cut method
     * log controller is a point cut method
     **/
    private final String apiPointCut="execution(* com.logging.aspect.loggingspringrestapiusingaspectobjectprogramming.controller.*.*(..))";

    @Pointcut(apiPointCut)
    public void logController(){}

    /**
     *
     * @param joinPoint we can find inside it all the details of the method called inisde the join point
     *
     */
    @Before("logController()")
    public void logRequest(JoinPoint joinPoint){
        // for log the controller name
        log.info(joinPoint.getSignature().getName());
        log.info(createJoinPointForLogs(joinPoint,DataType.REQUEST));
    }

    @AfterReturning("logController()")
    public void logsResponse(JoinPoint joinPoint){
        // for log the controller name
        log.info(joinPoint.getSignature().getName());
        log.info(createJoinPointForLogs(joinPoint,DataType.RESPONSE));
    }


    /**
     *
     * @param joinPoint we need to use it to see attributes in the original method
     * @return will return String after building all the attributes
     */
    private String createJoinPointForLogs(JoinPoint joinPoint, DataType dataType) {
        if (joinPoint.getArgs().length < 1) {
            return joinPoint.getSignature().getName()
                    .concat(" method don`t have parameters");
        }
        Object[] obj = joinPoint.getArgs();
        StringBuilder requestValue = new StringBuilder();
        if(dataType.equals(DataType.REQUEST)){
            requestValue.append("\r\n========== The request values ==========");
        }
        else {
            requestValue.append("\r\n========== The response values ==========");
        }
        Arrays.stream(obj).forEach(x -> {
            requestValue.append("\r\n");
            requestValue.append(x.toString());
        });
        requestValue
                .append("\r\n============= ======="
                        + "====== =============");
        return requestValue.toString();
    }
}