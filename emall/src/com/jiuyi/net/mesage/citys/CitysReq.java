package com.jiuyi.net.mesage.citys;

public class CitysReq {

	private String provice_id;//省ID
	private String city_id;//市
	private String county_id;//县、区ID
	private String town_id;//镇、村ID

	public String getProvice_id() {
		return provice_id;
	}

	public void setProvice_id(String provice_id) {
		this.provice_id = provice_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCounty_id() {
		return county_id;
	}

	public void setCounty_id(String county_id) {
		this.county_id = county_id;
	}

	public String getTown_id() {
		return town_id;
	}

	public void setTown_id(String town_id) {
		this.town_id = town_id;
	}

}
