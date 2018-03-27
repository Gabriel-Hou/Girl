package springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Gabriel on 18/3/16.
 **/
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private Integer id;

    private String cupSize;

    private Integer age;

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
