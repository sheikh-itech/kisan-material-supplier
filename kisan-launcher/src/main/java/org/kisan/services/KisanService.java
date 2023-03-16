package org.kisan.services;

import java.util.List;

import org.kisan.dao.repos.KisanRepo;
import org.kisan.dto.Kisan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hapheej
 *
 */

@Service
public class KisanService {

	@Autowired
	private KisanRepo kisanRepo;
	
	public boolean verifyAndSaveKisanDetails(Kisan kisan) throws Exception {
		kisan.updateId();
		validateKisanName(kisan);
		kisanRepo.save(kisan);
		return true;
	}
	
	void validateKisanName(Kisan kisan) throws Exception {
		
		if(null==kisan.getName()||kisan.getName()==""||kisan.getName().matches(".*\\d.*")) 
			throw new Exception("wrong name detected");
		if(kisan.getMobileNumber()<-1)
			throw new Exception("wrong mobile detected");
	}
	
	public String findByKidAndEmail(String kid, String email) {
		String successURL="http://localhost:8082/kisan/_products";
		String failureURL="http://localhost:8082/kisan/error";
		List<Kisan> k1 = kisanRepo.findByKid(kid);
		List<Kisan> k2 = kisanRepo.findByEmail(email);
		
		if(k1.get(0).getKid().equalsIgnoreCase(kid) && k2.get(0).getEmail().equalsIgnoreCase(email))
			return successURL;
		else return failureURL;
	}
	
	public Kisan findByKid(String kid) {
		
		List<Kisan> kikan = kisanRepo.findByKid(kid);
		return kikan.get(0);
	}
	
	public Kisan findByEmail(String email) {
		
		List<Kisan> kikan = kisanRepo.findByEmail(email);
		return kikan.get(0);
	}
}
