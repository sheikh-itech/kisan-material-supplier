package org.kisan.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class AppConfig {

	@Value("${cross.origin}")
	private String crossOrigin;
	
	public List<String> getCrossOrigins() {
		
		List<String> cors = new ArrayList<>();
		
		if(crossOrigin!=null && !crossOrigin.isBlank())
			cors.addAll(Arrays.asList(crossOrigin.split(",")));
		//else 
			//cors.add("/**");
		
		return cors;
	}
}
