package com;

import com.Application;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

//Springbootcontextloader belongs from spring boot test and when you add starter parent dependancy it will get automatically added
//or add starter test
@ContextConfiguration(classes = Application.class,loader = SpringBootContextLoader.class)
public abstract class AbstractCucumberTest
{

}
