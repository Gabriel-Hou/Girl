package springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by Gabriel on 18/3/16.
 **/
@Entity //表示该类对应数据库里的一个表

public class Girl {
    @Id
    @GeneratedValue //自增字段
    private Integer id;

    private String cupSize;

    //   验证的值       若不满足这个值则返回的信息
    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;

    public Girl(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
