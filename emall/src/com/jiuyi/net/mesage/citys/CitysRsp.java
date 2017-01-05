package com.jiuyi.net.mesage.citys;

import java.util.List;

public class CitysRsp {

	private List<T_position_provice> provices;
	private List<T_position_city> cities;
	private List<T_position_county> counties;
	private List<T_position_town> towns;
	private List<T_position_village> villages;

	public List<T_position_provice> getProvices() {
		return provices;
	}

	public void setProvices(List<T_position_provice> provices) {
		this.provices = provices;
	}

	public List<T_position_city> getCities() {
		return cities;
	}

	public void setCities(List<T_position_city> cities) {
		this.cities = cities;
	}

	public List<T_position_county> getCounties() {
		return counties;
	}

	public void setCounties(List<T_position_county> counties) {
		this.counties = counties;
	}

	public List<T_position_town> getTowns() {
		return towns;
	}

	public void setTowns(List<T_position_town> towns) {
		this.towns = towns;
	}

	public List<T_position_village> getVillages() {
		return villages;
	}

	public void setVillages(List<T_position_village> villages) {
		this.villages = villages;
	}

}
