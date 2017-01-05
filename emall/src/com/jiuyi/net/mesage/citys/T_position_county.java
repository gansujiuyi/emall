package com.jiuyi.net.mesage.citys;

/***
 * 地区市
 * 
 * @author baizilin
 * 
 */
public class T_position_county {

	private Integer id;// 地级市主键ID
	private String city_id;// 地级市id
	private String county_id;// 县级id
	private String county_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCounty_name() {
		return county_name;
	}

	public void setCounty_name(String county_name) {
		this.county_name = county_name;
	}

}
