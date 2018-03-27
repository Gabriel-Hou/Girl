package springboot.exception;

import springboot.enums.ResultEnum;

/**
 * Created by Gabriel on 18/3/26.
 **/
public class GirlException extends RuntimeException{

    private Integer code;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
