package com.jiuyi.net.mesage.citys;

/***
 * 省市县镇村
 * 
 * @author baizilin
 * 
 */
public class T_position_village {

	private Integer id;
	private String town_id;// 镇id
	private String village_id;// 村id--唯一
	private String village_name;//

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTown_id() {
		return town_id;
	}

	public void setTown_id(String town_id) {
		this.town_id = town_id;
	}

	public String getVillage_id() {
		return village_id;
	}

	public void setVillage_id(String village_id) {
		this.village_id = village_id;
	}

	public String getVillage_name() {
		return village_name;
	}

	public void setVillage_name(String village_name) {
		this.village_name = village_name;
	}

}
