package sumdu.edu.ua.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "sumdu.edu.ua")
@EnableJpaRepositories(basePackages = "sumdu.edu.ua.persistence.repository")
@EntityScan(basePackages = "sumdu.edu.ua.core.domain")
@EnableAsync
public class AppInit {
    public static void main(String[] args) {
        SpringApplication.run(AppInit.class, args);
        System.out.println("Started at http://localhost:8080/books");
    }
}
