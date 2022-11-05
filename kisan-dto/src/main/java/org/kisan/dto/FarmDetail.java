package org.kisan.dto;

/**
 * @author Hapheej
 *
 */
public class FarmDetail {
	
	private String khasaraNumber;
	private String farmArea;
	private String lacation;
	private boolean pumpFacility;
	private boolean roadForFarm;
	private String soilType;
	
	public FarmDetail() {}
	
	public String getKhasaraNumber() {
		return khasaraNumber;
	}
	public void setKhasaraNumber(String khasaraNumber) {
		this.khasaraNumber = khasaraNumber;
	}
	public String getFarmArea() {
		return farmArea;
	}
	public void setFarmArea(String farmArea) {
		this.farmArea = farmArea;
	}
	public String getLacation() {
		return lacation;
	}
	public void setLacation(String lacation) {
		this.lacation = lacation;
	}
	public boolean isPumpFacility() {
		return pumpFacility;
	}
	public void setPumpFacility(boolean pumpFacility) {
		this.pumpFacility = pumpFacility;
	}
	public boolean isRoadForFarm() {
		return roadForFarm;
	}
	public void setRoadForFarm(boolean roadForFarm) {
		this.roadForFarm = roadForFarm;
	}
	public String getSoilType() {
		return soilType;
	}
	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}	
}
