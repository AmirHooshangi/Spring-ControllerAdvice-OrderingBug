package com.bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author amirhoshangi@gmail.com
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.bug")
public class MainClass {
        public static void main(String[] args) throws InterruptedException {
      SpringApplication.run(new Object[]{MainClass.class}, args);
      System.out.println("Let's enjoy the bug machine");
    }

}

