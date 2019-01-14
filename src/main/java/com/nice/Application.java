package com.nice;


//import com.nice.model.think_java.Animal;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@MapperScan("com.nice.mapper*")
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(
                Application.class);
        application.run(args);

    }

//    public static void 多态(){
//        Animal animal=new Animal.Dog();
//        log.info("现在播放" + animal.getAnimalName() + "类的声音:");
//        animal.cry();
//        animal=new Animal.Cat();
//        log.info("现在播放" + animal.getAnimalName() + "类的声音:");
//        animal.cry();
//    }
}
