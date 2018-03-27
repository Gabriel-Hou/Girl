package springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.domain.Result;
import springboot.exception.GirlException;
import springboot.util.ResultUtil;

/**
 * Created by Gabriel on 18/3/26.
 **/
@ControllerAdvice
public class ExceptionHandle {

    //声明要捕获的是哪个异常类
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException= (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        return ResultUtil.error(-1,"未知错误");
    }
}
