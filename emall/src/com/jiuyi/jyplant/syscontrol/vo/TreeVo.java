package com.jiuyi.jyplant.syscontrol.vo;

@SuppressWarnings("serial")
public class TreeVo implements java.io.Serializable {

	private String mid;
	private String pId;// 父节点ID
	private String name;// 树上的节点的名称
	private boolean isParent;// 是否为文件夹节点
	private boolean open = false;// 是否展开树节点，默认不展开
	private boolean checked = false;// 是否选中

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
