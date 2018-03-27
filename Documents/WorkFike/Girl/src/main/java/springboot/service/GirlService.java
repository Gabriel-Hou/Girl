package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.domain.Girl;
import springboot.enums.ResultEnum;
import springboot.exception.GirlException;
import springboot.repository.GirlRepository;

import javax.transaction.Transactional;

/**
 * Created by Gabriel on 18/3/16.
 **/
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional  //事务管理--用于同时操作多条数据，只有查询的时候不需要加事务
    public void insertTwo(){
        Girl girlA=new Girl();
        Girl girlB=new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);

    }
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }


}
