package springboot.util;

import org.apache.poi.ss.formula.functions.T;
import springboot.domain.Result;

/**
 * Created by Gabriel on 18/3/26.
 **/
public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData((T) object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
