package com.moskalev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 01.02.22
 * Class for running spring boot application
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args)  {
        SpringApplication.run(Application.class,args);
        System.out.println("ok");

    }
}
