package com.jiuyi.jyplant.utils.Exception;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8581000951664153684L;

	public CustomException() {
	} // 用来创建无参数对象

	public CustomException(String message) { // 用来创建指定参数对象
		super(message); // 调用超类构造器
	}
}
