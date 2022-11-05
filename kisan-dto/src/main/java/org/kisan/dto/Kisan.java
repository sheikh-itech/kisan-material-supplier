package org.kisan.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Kisan")
public class Kisan 
{
	@Transient
	private String prefix = "kisan_";
	@Indexed(unique = true)
	private String kid;
    private String name;
    private int mobileNumber;
    private int age;
    private String email;
    
    @OneToMany(cascade = CascadeType.REMOVE)
    private Address address;
    @OneToMany(cascade = CascadeType.REMOVE)
    private FarmDetail farmDetail;
    
    public Kisan() { }
    
    public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public FarmDetail getFarmDetail() {
		return farmDetail;
	}

	public void setFarmDetail(FarmDetail farmDetail) {
		this.farmDetail = farmDetail;
	}
	
	public void updateId() {
		kid = prefix+kid;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
