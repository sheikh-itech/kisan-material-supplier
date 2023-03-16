package org.kisan.apis;

import org.kisan.dto.product.ProductDetail;
import org.kisan.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hapheej
 *
 */

@RestController
@RequestMapping(value="/productDetail")
public class ProductDetailApi {

	@Autowired
	private ProductDetailService productDetailService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="text/plain")
	public String saveProductDetail(@RequestBody ProductDetail productDetail) {
		
		return productDetailService.verifyAndSaveProductDetails(productDetail);
	}
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST, consumes= {"multipart/form-data"}, produces="text/plain")
	public String saveImage(/*@RequestParam("file")*/@RequestBody MultipartFile file, @RequestParam String pid) {
		
		return productDetailService.verifyAndSaveImage(file, pid);
	}
}
