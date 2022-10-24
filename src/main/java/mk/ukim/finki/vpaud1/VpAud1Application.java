package mk.ukim.finki.vpaud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class VpAud1Application {

    public static void main(String[] args) {
        SpringApplication.run(VpAud1Application.class, args);
    }

}
