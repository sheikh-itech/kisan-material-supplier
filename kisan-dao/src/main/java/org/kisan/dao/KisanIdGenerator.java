package org.kisan.dao;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author Hapheej
 *
 */
public class KisanIdGenerator /* implements IdentifierGenerator */ {

	/* (non-Javadoc)
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SharedSessionContractImplementor, java.lang.Object)
	 */
	//@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) {
		
		System.out.println("Inside kisan id generator");
		return null;
	}

}
