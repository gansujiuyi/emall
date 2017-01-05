package com.jiuyi.net.mesage.citys;

/**
 * 县级市
 * 
 * @author baizilin
 * 
 */
public class T_position_city {

	private Integer id;// 主键
	private Integer province_id;// 地级市id
	private String city_id;// 县级市id
	private String city_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

}
