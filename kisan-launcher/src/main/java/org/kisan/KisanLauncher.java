package org.kisan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Launcher class entry point
 *
 */

//@EntityScan(basePackages={"org.kisan.dto"})
//@ComponentScan(basePackages= {"org.kisan.dao"})
//@EnableMongoRepositories(basePackages = {"org.kisan.dao.repos"})
@SpringBootApplication
public class KisanLauncher
{	
    public static void main( String[] args )
    {
    	SpringApplication.run(KisanLauncher.class, args);
    }
}
