package org.kisan.dao.repos;

import java.util.List;

import org.kisan.dto.Kisan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hapheej
 */

@Repository
public interface KisanRepo extends MongoRepository<Kisan, String> {
	List<Kisan> findByName(String name);
	List<Kisan> findByKidAndEmail(String kid, String email);
	List<Kisan> findByKid(String kid);
	List<Kisan> findByEmail(String email);
}
