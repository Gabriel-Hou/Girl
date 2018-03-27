package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.domain.Girl;

import java.util.List;

/**
 * Created by Gabriel on 18/3/16.
 **/
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}
