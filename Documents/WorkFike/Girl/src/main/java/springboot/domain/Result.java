package springboot.domain;


import org.apache.poi.ss.formula.functions.T;

/**
 * Created by Gabriel on 18/3/26.
 **/

public class Result {
    //消息码
    private Integer code;
    //传送的消息
    private String msg;
    //具体内容
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
