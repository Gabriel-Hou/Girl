package springboot.test.java;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.domain.Girl;
import springboot.service.GirlService;

/**
 * Created by Gabriel on 18/3/26.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void findOneTest(){
        Girl girl=girlService.findOne(3);
//        Assert.assertArrayEquals(new Integer(3),girl.getAge());
    }

}
