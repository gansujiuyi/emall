package com.jiuyi.net.mesage.citys;

/**
 * 镇
 * 
 * @author baizilin
 * 
 */
public class T_position_town {

	private Integer id;
	private String county_id;// 县级市id
	private String town_id;// 镇id
	private String town_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTown_name() {
		return town_name;
	}

	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}

}
