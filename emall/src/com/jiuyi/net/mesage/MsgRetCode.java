/**
 * 接口响应码定义
 * @author Huangwj & Wul
 * @version 1.0
 * Copyright @ 2009 - 2011  
 */
package com.jiuyi.net.mesage;

public class MsgRetCode {

	/** 交易成功 */
	public static final String Trans_Success_Code = "0000";
	/** 交易成功提示 */
	public static final String Trans_Success_Show = "交易成功";

	/** 数据查询操作失败。进行数据库查询操作时，若失败，则出现该提示 */
	public static final String Database_Query_Code = "0001";

	/** 数据查询已经存在。进行数据库查询操作时，若信息已存在，则出现该提示 */
	public static final String Database_Code = "0111";
	/** 数据查询操作失败失败 */
	public static final String Database_Query_Show = "数据库查询操作失败";

	/** 数据查询操作信息已存在 */
	public static final String Database_Show = "信息已存在不能重复添加";

	/** 无此客户记录 。根据凭证类型、凭证号，查询客户表，若无记录，则出现该提示 */
	public static final String Customer_Null_Code = "0002";
	/** 无此客户记录提示 */
	public static final String Customer_Null_Show = "客户信息不存在";

	/** 无此客户的积分账户信息。根据客户号，查询积分账户表，若无记录，则出现该提示 */
	public static final String PointsAcc_Null_Code = "0003";
	/** 无此客户的积分账户信息 */
	public static final String PointsAcc_Null_Show = "客户积分账户信息不存在";

	/** 原交易不存在。当根据系统跟踪号查询不到相关交易时，则出现该提示 */
	public static final String OldTrans_NotExist_Code = "0005";
	/** 原交易不存在 */
	public static final String OldTrans_NotExist_Show = "原交易不存在 ";

	/** 无法自动开户。凭证类型为C01且凭证号码以62开头才能自动开户 */
	public static final String AutoOpenAcc_Error_Code = "0007";
	/** 无法自动开户 */
	public static final String AutoOpenAcc_Error_Show = "凭证类型和凭证号码不匹配";

	/** 金额格式错误。若请求信息中的金额格式有问题，则出现该提示 */
	public static final String Amount_Format_Code = "0010";
	/** 金额格式错误提示 */
	public static final String Amount_Format_Show = "金额格式错误";

	/** 请求报文数据错误。当请求报文头、请求报文中的必输项数据为空时，则出现该提示 */
	public static final String Requset_Format_Code = "0011";
	/** 请求报文数据错误 */
	public static final String Requset_Format_Show = "请求报文数据不完整";

	/** 日期格式错误。若请求信息中的日期格式有问题，则出现该提示 */
	public static final String Date_Format_Code = "0012";
	/** 日期格式错误提示 */
	public static final String Date_Format_Show = "日期格式应为yyyyMMdd";

	/** 格式错误。当请求报文中的的格式错误时，则出现该提示 */
	public static final String Format_Error_Code = "0016";
	/** 数格式错误 */
	public static final String Format_Error_Show = "格式错误";

	/** 交易失败。各种调用交易方法时抛异常，则出现该提示 */
	public static final String Trans_Error_Code = "0031";
	/** 交易失败 */
	public static final String Trans_Error_Show = "交易时发生异常";

	/** 门户会员信息不存在。当根据查询不到门户会员信息时，则出现该提示 */
	public static final String MemberNo_Null_Code = "0051";
	/** 门户会员信息不存在 */
	public static final String MemberNo_Null_Show = "会员信息不存在";

	/** 无常用地址信息。当查询不到客户的常用地址信息时，则出现该提示 */
	public static final String Address_Null_Code = "0052";
	/** 无常用地址信息 */
	public static final String Address_Null_Show = "无常用地址信息";

	/** 订单信息为空。 当根据请求报文中的条件，查询不到订单信息时，则出现该提示 */
	public static final String OrderInfo_Null_Code = "0053";
	/** 订单信息为空 */
	public static final String OrderInfo_Null_Show = "订单信息为空";
	/** 订单信息为空 */
	public static final String OrderInfo_ORDER_Show = "订单客户信息与所给凭证号客户信息不一致";

	/** 地址信息为空。 当根据请求报文中的条件，查询不到地址信息时，则出现该提示 */
	public static final String UsualAddress_Null_Code = "0054";
	/** 地址信息为空 */
	public static final String UsualAddress_Null_Show = "地址信息为空";

	/** 该订单号不存在 **/
	public static final String ORDER_CHECK_CUST = "该订单号不存在";
	/** 系统暂时不支持现金支付 **/
	public static final String ORDER_CHECK_PRICET = "系统暂时不支持现金支付";
	/** 该订单号非待支付 **/
	public static final String ORDER_CHECK_STATE = "该订单号非待支付";

	/** 订单明细信息为空。 当根据请求报文中的条件，查询不到订单明细信息时，则出现该提示 */
	public static final String OrderDetails_Null_Code = "0057";
	/** 订单明细信息为空 */
	public static final String OrderDetails_Null_Show = "订单明细信息为空";

	/** 地址ID不能为空。当请求报文中必输项地址ID为空时，则出现该提示 */
	public static final String UsualAddressNo_Null_Code = "0059";
	/** 地址ID不能为空 */
	public static final String UsualAddressNo_Null_Show = "地址ID不能为空";

	/** 商户信息不存在 */
	public static final String Cust_Null_Code = "0060";
	/** 商户信息不存在 */
	public static final String Cust_Null_Show = "商户信息不存在";

	/** 手机号不正确 */
	public static final String MobileNo_Error_Code = "0100";
	/** 手机号不正确 */
	public static final String MobileNo_Error_Show = "手机号不正确";

	/** 活动已经存在 **/
	public static final String GAME_CUST_Error_NONE_CODE = "2011";
	/** 活动已经存在 **/
	public static final String GAME_CUST_Error_NONE_SHOW = "商户不存在";
	/** 活动已经存在 **/
	public static final String GAME_DATE_Error_NONE_CODE = "2012";
	/** 活动已经存在 **/
	public static final String GAME_DATE_Error_NONE_SHOW = "活动不存在";

	public static final String Success_Code = "0000";
	public static final String Eoor_Code = "0001";

	public static final String CUSTOPER_LOGIN_FALSE_CODE = "0301";
	public static final String CUSTOPER_LOGIN_FALSE_SHOW = "查询用户信息异常";

	public static final String USERNAME_DISABLED_CODE = "0302";
	public static final String USERNAME_DISABLED_SHOW = "账号不存在";

	public static final String PASSWORD_DISABLED_CODE = "0303";
	public static final String PASSWORD_DISABLED_SHOW = "密码错误";

	public static final String CUSTOPER_USELESS_CODE = "0304";
	public static final String CUSTOPER_USELESS_SHOW = "您的账号已经被锁定";

	public static final String PASSWORD_PAY_DIS_CODE = "0306";
	public static final String PASSWORD_PAY_DIS_SHOW = "支付密码错误";

	public static final String CUSTOPER_LOCK__CODE = "0307";
	public static final String CUSTOPER_LOCK_SHOW = "您输入错误密码次数超过5次，账户被锁定";

	public static final String CUSTOPER_NOACTIVATION__CODE = "0308";
	public static final String CUSTOPER_NOACTIVATION_SHOW = "账户未激活";

	public static final String CUSTOPER_CANCELLATION__CODE = "0309";
	public static final String CUSTOPER_CANCELLATION_SHOW = "账户已注销";

	public static final String MEMBER_UPDATE__CODE = "0310";
	public static final String MEMBER_UPDATE_SHOW = "更新账户失败";

	public static final String MEMBER_PAY_PASSWORD__CODE = "0311";
	public static final String MEMBER_PAY_PASSWORD_SHOW = "支付密码输入超过3次，账户被锁定";

	public static final String OPER_SUCCESS_CODE = "0550";
	public static final String OPER_SUCCESS_SHOW = "操作成功";
	public static final String OPER_FAIL_CODE = "0551";
	public static final String OPER_FAIL_SHOW = "操作失败";
	public static final String OPER_EXCEPTION_CODE = "0552";
	public static final String OPER_EXCEPTION_SHOW = "操作发生异常";

	/** 业务异常 */
	public static final String BUSS_ERROR_CODE = "9999";

	public static final String CONVENIENCE_PARAMERROR_CODE = "2100";
	public static final String CONVENIENCE_PARAMERROR_SHOW = "非法参数";

	/** 针对验证web service 协议参数 head 中 认证码的验证 */
	public static String TRANS_AUTHCODE_ERROR_CODE = "01110";
	/** 针对验证web service 协议参数 head 中 认证码的验证 */
	public static String TRANS_AUTHCODE_ERROR_SHOW = "认证码错误，非法的调用";

	public static final String INCLUDE_KEYWORD_CODE = "1101";
	public static final String INCLUDE_KEYWORD_SHOW = "接口参数中包含敏感字";
	public static final String GETPARAM_ERROR_CODE = "1102";
	public static final String GETPARAM_ERROR_SHOW = "解析接口中的参数发生异常";

}
