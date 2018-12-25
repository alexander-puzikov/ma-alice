package pro.apuzikov.alice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication(scanBasePackages = {"pro.apuzikov.alice"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    Random random() {
        return new Random(System.currentTimeMillis() / 1432143215L);
    }
}
