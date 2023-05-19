package io.github.cHenrique0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IntroApplication {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(IntroApplication.class, args);
    }
}
