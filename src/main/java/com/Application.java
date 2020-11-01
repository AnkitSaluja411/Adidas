package com;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//@springbootapp requires starter-web dependancy
@SpringBootApplication
public class Application {

    public static void  main(String args[])
    {
        //SpringApplicationBuilder belongs from starter-web dependancy
        SpringApplicationBuilder springApplicationBuilder=new SpringApplicationBuilder(Application.class);
        springApplicationBuilder.run(args);
    }
}
