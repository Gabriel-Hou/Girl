package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Girl;
import springboot.domain.Result;
import springboot.repository.GirlRepository;
import springboot.service.GirlService;
import springboot.util.ResultUtil;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Gabriel on 18/3/16.
 * 数据库的增删改查操作-daoImpl
 **/
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    @GetMapping(value="/girl")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value="/girls")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
      //  return girlRepository.save(girl);//save返回的是添加的对象

    }

    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                              @RequestParam("cupsize") String cupSize,
                              @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);//save返回的是添加的对象
    }

    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value="girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
