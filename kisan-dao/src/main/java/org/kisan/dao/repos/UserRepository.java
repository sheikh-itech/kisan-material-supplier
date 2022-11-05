package org.kisan.dao.repos;

import java.util.Optional;

import org.kisan.dto.beans.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDetail, Integer> {

	public abstract Optional<UserDetail> findByUsername(String username);
}
