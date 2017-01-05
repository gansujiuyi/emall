package com.jiuyi.net.mesage.citys;

/**
 * 省份
 * 
 * @author baizilin
 * 
 */
public class T_position_provice {

	private String id;// 主键ID
	private String provice_id;// 省份id、省份编号
	private String provice_name;// 省份名称

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvice_id() {
		return provice_id;
	}

	public void setProvice_id(String provice_id) {
		this.provice_id = provice_id;
	}

	public String getProvice_name() {
		return provice_name;
	}

	public void setProvice_name(String provice_name) {
		this.provice_name = provice_name;
	}

}
