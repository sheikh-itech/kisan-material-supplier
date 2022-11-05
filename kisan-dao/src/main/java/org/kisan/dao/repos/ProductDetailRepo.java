package org.kisan.dao.repos;

import java.util.List;

import org.kisan.dto.product.ProductDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Hapheej
 *
 */
public interface ProductDetailRepo extends MongoRepository<ProductDetail, String> {

	List<ProductDetail> findByName(String name);
	List<ProductDetail> findByPid(String pid);
}
