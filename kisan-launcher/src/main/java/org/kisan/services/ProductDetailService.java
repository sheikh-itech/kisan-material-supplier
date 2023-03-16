package org.kisan.services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.kisan.dao.Config;
import org.kisan.dao.repos.ProductDetailRepo;
import org.kisan.dto.product.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hapheej
 *
 */

@Service
public class ProductDetailService {

	@Autowired
	private ProductDetailRepo productDetailRepo;

	public String verifyAndSaveProductDetails(ProductDetail productDetail) {
		try {
			productDetailRepo.save(productDetail);
		} catch(DuplicateKeyException mex) {
			return "product already exist with this product id";
		} catch(Exception ex) {
			return "problem in loading product detail";
		}
		return productDetail.getPid();
	}

	/**
	 * @return
	 */
	public String verifyAndSaveImage(MultipartFile file, String pid) {
		String path = Config.ProductImageLocation+File.separator+pid;
		Path filepath;
        try {
        	/*
        	Path filepath = Paths.get(path, file.getOriginalFilename());
        	OutputStream os = Files.newOutputStream(filepath);
        	os.write(file.getBytes());
        	os.close();
        	*/
        	//Files.createDirectories(Paths.get(path));
        	new File(path).mkdirs();
        	filepath = Paths.get(path, file.getOriginalFilename());
        	file.transferTo(filepath);

        } catch (Exception e) {
              return "Not able to save product image";
        }
		return filepath.toString();
	}
	
	
}
