package org.kisan.apis;

import org.kisan.dto.Kisan;
import org.kisan.services.KisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hapheej
 *
 */

@RestController
@RequestMapping(value="/kisan")
public class KisanApi {
	
	@Autowired
	private KisanService kisanService;

	@RequestMapping(value="/register", method=RequestMethod.POST, consumes="application/json")
	public String registerKisan(@RequestBody Kisan kisan) {
		try {
			kisanService.verifyAndSaveKisanDetails(kisan);
		} catch(DuplicateKeyException mex) {
			return "user already exist with this kisan id";
		} catch(Exception ex) {
			return "problem in registering user";
		}
		
		return "registration success";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes="multipart/form-data", produces="text/plain")
	public String kisanLogin(@RequestParam("kid") String kid, @RequestParam("email") String email)  {
		return kisanService.findByKidAndEmail(kid, email);
	}
	
	@RequestMapping(value="/detail/kid", method=RequestMethod.POST, consumes="multipart/form-data", produces="application/json")
	public Kisan kisanDetailByKid(@RequestParam("kid") String kid)  {
		return kisanService.findByKid(kid);
	}
	
	@RequestMapping(value="/detail/email", method=RequestMethod.POST, consumes="multipart/form-data", produces="application/json")
	public Kisan kisanDetailByEmail(@RequestParam("email") String email)  {
		return kisanService.findByEmail(email);
	}	
}
