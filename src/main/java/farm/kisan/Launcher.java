package farm.kisan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Launcher class entry point
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"org.kisan.dao"})
@EntityScan(basePackages={"org.kisan.dto"})
public class Launcher 
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(Launcher.class, args);
    }
}
