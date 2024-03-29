package org.kisan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Hapheej
 *
 */

@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalConfig {

	public static String ProductImageLocation;
	public static String ProductCategory;
	
	public GlobalConfig() { }
	
	public String getProductImageLocation() {
		return ProductImageLocation;
	}
	public void setProductImageLocation(String productImageLocation) {
		ProductImageLocation = productImageLocation;
	}

	public static String getProductCategory() {
		return ProductCategory;
	}
	public static void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
}
