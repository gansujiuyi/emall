package com.jiuyi.net.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuyi.jyplant.category.entity.CategoryInfo;
import com.jiuyi.jyplant.category.service.CategoryInfoService;
import com.jiuyi.jyplant.cpEvaluate.entity.EvaluateInfo;
import com.jiuyi.jyplant.cpEvaluate.service.EvaluateService;
import com.jiuyi.jyplant.emaill.entity.EmaillInfo;
import com.jiuyi.jyplant.emaill.service.EmaillInfoService;
import com.jiuyi.jyplant.member.entity.MemberInfo;
import com.jiuyi.jyplant.member.service.MemberInfoService;
import com.jiuyi.jyplant.myCollection.entity.CollectionInfo;
import com.jiuyi.jyplant.myCollection.service.CollectionInfoService;
import com.jiuyi.jyplant.order.entity.AddressInfo;
import com.jiuyi.jyplant.order.entity.OrderInfo;
import com.jiuyi.jyplant.order.service.AddressInfoService;
import com.jiuyi.jyplant.order.service.OrderInfoService;
import com.jiuyi.jyplant.product.entity.ProductInfo;
import com.jiuyi.jyplant.product.service.ProductInfoService;
import com.jiuyi.jyplant.suggest.entity.SuggestInfo;
import com.jiuyi.jyplant.suggest.service.SuggestInfoService;
import com.jiuyi.jyplant.syscontrol.entity.Users;
import com.jiuyi.jyplant.syscontrol.service.UserService;
import com.jiuyi.jyplant.utils.Constant;
import com.jiuyi.jyplant.utils.EamilCodeUtils;
import com.jiuyi.jyplant.utils.MD5;
import com.jiuyi.jyplant.utils.PageResults;
import com.jiuyi.jyplant.utils.SendEmail;
import com.jiuyi.net.mesage.Head;
import com.jiuyi.net.mesage.category.Category;
import com.jiuyi.net.mesage.category.CategoryReqMsg;
import com.jiuyi.net.mesage.category.CategoryRsp;
import com.jiuyi.net.mesage.category.CategoryRspMsg;
import com.jiuyi.net.mesage.citys.CitysReq;
import com.jiuyi.net.mesage.citys.CitysReqMsg;
import com.jiuyi.net.mesage.citys.CitysRsp;
import com.jiuyi.net.mesage.citys.CitysRspMsg;
import com.jiuyi.net.mesage.citys.T_position_city;
import com.jiuyi.net.mesage.citys.T_position_county;
import com.jiuyi.net.mesage.citys.T_position_provice;
import com.jiuyi.net.mesage.citys.T_position_town;
import com.jiuyi.net.mesage.citys.T_position_village;
import com.jiuyi.net.mesage.cpEvaluate.Evaluate;
import com.jiuyi.net.mesage.cpEvaluate.EvaluateReq;
import com.jiuyi.net.mesage.cpEvaluate.EvaluateReqMsg;
import com.jiuyi.net.mesage.cpEvaluate.EvaluateRsp;
import com.jiuyi.net.mesage.cpEvaluate.EvaluateRspMsg;
import com.jiuyi.net.mesage.email.Emaill;
import com.jiuyi.net.mesage.email.EmaillReq;
import com.jiuyi.net.mesage.email.EmaillReqMsg;
import com.jiuyi.net.mesage.email.EmaillRsp;
import com.jiuyi.net.mesage.email.EmaillRspMsg;
import com.jiuyi.net.mesage.memberInfo.MemberInfoReq;
import com.jiuyi.net.mesage.memberInfo.MemberInfoReqMsg;
import com.jiuyi.net.mesage.memberInfo.MemberInfoRsp;
import com.jiuyi.net.mesage.memberInfo.MemberInfoRspMsg;
import com.jiuyi.net.mesage.memberInfo.MemberInfos;
import com.jiuyi.net.mesage.myCollection.CollectionReq;
import com.jiuyi.net.mesage.myCollection.CollectionReqMsg;
import com.jiuyi.net.mesage.myCollection.CollectionRsp;
import com.jiuyi.net.mesage.myCollection.CollectionRspMsg;
import com.jiuyi.net.mesage.orderInfo.Order;
import com.jiuyi.net.mesage.orderInfo.OrderReq;
import com.jiuyi.net.mesage.orderInfo.OrderReqMsg;
import com.jiuyi.net.mesage.orderInfo.OrderRsp;
import com.jiuyi.net.mesage.orderInfo.OrderRspMsg;
import com.jiuyi.net.mesage.orderInfo.address.Address;
import com.jiuyi.net.mesage.orderInfo.address.AddressReq;
import com.jiuyi.net.mesage.orderInfo.address.AddressReqMsg;
import com.jiuyi.net.mesage.orderInfo.address.AddressRsp;
import com.jiuyi.net.mesage.orderInfo.address.AddressRspMsg;
import com.jiuyi.net.mesage.product.Product;
import com.jiuyi.net.mesage.product.ProductReq;
import com.jiuyi.net.mesage.product.ProductReqMsg;
import com.jiuyi.net.mesage.product.ProductRsp;
import com.jiuyi.net.mesage.product.ProductRspMsg;
import com.jiuyi.net.mesage.suggest.Suggest;
import com.jiuyi.net.mesage.suggest.SuggestReq;
import com.jiuyi.net.mesage.suggest.SuggestReqMsg;
import com.jiuyi.net.mesage.suggest.SuggestRsp;
import com.jiuyi.net.mesage.suggest.SuggestRspMsg;
import com.jiuyi.net.mesage.userinfo.UserInfoReq;
import com.jiuyi.net.mesage.userinfo.UserInfoReqMsg;
import com.jiuyi.net.mesage.userinfo.UserInfoRsp;
import com.jiuyi.net.mesage.userinfo.UserInfoRspMsg;
import com.jiuyi.net.mesage.userinfo.Userinfo;
import com.jiuyi.net.service.IEmallEXChangesService;
import com.jiuyi.net.utils.SystemValueInit;
import com.sun.istack.internal.logging.Logger;

@WebService(endpointInterface = "com.jiuyi.net.service.IEmallEXChangesService", serviceName = "EmallEXChangesService")
@Service
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class EmallEXChangesServiceImpl implements IEmallEXChangesService {
	@Autowired
	private UserService userService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private CategoryInfoService categoryInfoService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private AddressInfoService addressInfoService;
	@Autowired
	private EmaillInfoService emaillInfoService;
	@Autowired
	private CollectionInfoService collectionInfoService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private SuggestInfoService suggestInfoService;
	@Autowired
	private ProductInfoService productInfoService;
	
	@Autowired
    private SessionFactory sessionFactory;

	Logger logger = Logger.getLogger(EmallEXChangesServiceImpl.class);

	/**
	 * 后台登录 权限验证 webService接口实现
	 */
	@Override
	public UserInfoRspMsg queryUserInfo(UserInfoReqMsg infoReqMsg) {
		UserInfoRspMsg infoRspMsg = new UserInfoRspMsg();
		UserInfoRsp inofRsp = new UserInfoRsp();
		UserInfoReq inofReq = infoReqMsg.getInfoReq();
		// 添加验证信息
		Head head = infoReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
				infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return infoRspMsg;
			}
		}
		Users u = userService.queryByUP(inofReq.getUserName(),
				inofReq.getuPassword());
		Userinfo userinfo = null;
		if (null != u) {
			userinfo = new Userinfo();
			userinfo.setUserId(u.getUserId());
			userinfo.setUserMail(u.getUserMail());
			userinfo.setUserName(u.getUserName());
			userinfo.setUserPhone(u.getUserPhone());
			inofRsp.setUserinfo(userinfo);
			infoRspMsg.setInfoRsp(inofRsp);
			infoRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
			infoRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
		}

		return infoRspMsg;
	}

	/**
	 * 会员注册 webService接口实现
	 */
	@Override
	public MemberInfoRspMsg memberReg(MemberInfoReqMsg infoReqMsg) {
		MemberInfoRspMsg infoRspMsg = new MemberInfoRspMsg();
		MemberInfoRsp infoRsp = new MemberInfoRsp();
		MemberInfo memberInfo = new MemberInfo();
		// 添加验证信息
		Head head = infoReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				infoRspMsg.setRetCode("1111");
				infoRspMsg.setRetShow("权限不对!");
				return infoRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(memberInfo, infoReqMsg.getMemberInfoReq()
					.getMemberInfos());
			MemberInfo info = memberInfoService.saveMemberInfo(memberInfo,infoReqMsg.getMemberInfoReq().getContent());
			MemberInfos memberInfos = new MemberInfos();
			BeanUtils.copyProperties(memberInfos, info);
			infoRsp.setMemberInfos(memberInfos);
			infoRspMsg.setMemberInfoRsp(infoRsp);
			infoRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
			infoRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);

		} catch (Exception e) {
			infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
			infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return infoRspMsg;
		}
		return infoRspMsg;
	}

	/**
	 * 会员查询 webService接口实现
	 */
	@Override
	public MemberInfoRspMsg memberQuery(MemberInfoReqMsg memberInfoReqMsg) {
		MemberInfoRspMsg memberInfoRspMsg = new MemberInfoRspMsg();
		MemberInfoRsp memberInfoRsp = new MemberInfoRsp();
		MemberInfoReq memberInfoReq = memberInfoReqMsg.getMemberInfoReq();
		MemberInfos infos = memberInfoReq.getMemberInfos();
		// 添加验证信息
		Head head = memberInfoReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				memberInfoRspMsg.setRetCode(Constant.RETCODE_FAIL);
				memberInfoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return memberInfoRspMsg;
			}
		}
		MemberInfo m = memberInfoService.querySingleMemberInfo(infos.getMemberName());
		MemberInfos memberInfos = new MemberInfos();
		if (null != m) {
			try {
				BeanUtils.copyProperties(memberInfos, m);
				memberInfoRsp.setMemberInfos(memberInfos);
				memberInfoRspMsg.setMemberInfoRsp(memberInfoRsp);
				memberInfoRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				memberInfoRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return memberInfoRspMsg;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				memberInfoRspMsg.setRetCode(Constant.RETCODE_FAIL);
				memberInfoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return memberInfoRspMsg;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				memberInfoRspMsg.setRetCode(Constant.RETCODE_FAIL);
				memberInfoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return memberInfoRspMsg;
			}
		} else {
			memberInfoRspMsg.setRetCode(Constant.MEMBERNOEXITS_CODE);
			memberInfoRspMsg.setRetShow(Constant.MEMBERNOEXITS_SHOW);
			return memberInfoRspMsg;
		}
	}

	/**
	 * 校验会员 webService接口实现
	 */
	@Override
	public MemberInfoRspMsg memberCheck(MemberInfoReqMsg infoReqMsg) {
		logger.info("开始校验会员信息服务端接口!");
		MemberInfos memberInfos = infoReqMsg.getMemberInfoReq()
				.getMemberInfos();
		MemberInfo memberInfo = new MemberInfo();
		MemberInfoRspMsg infoRspMsg = new MemberInfoRspMsg();
		// 添加验证信息
		Head head = infoReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				infoRspMsg.setRetCode(Constant.RETSHOW_FAIL);
				infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return infoRspMsg;
			}
		}
		logger.info("正在验证校验会员功能的请求头!");
		try {
			BeanUtils.copyProperties(memberInfo, memberInfos);
			boolean check = memberInfoService.checkInfo(memberInfo);
			MemberInfoRsp infoRsp = new MemberInfoRsp();
			infoRsp.setCheck(check);
			infoRsp.setMemberInfos(memberInfos);
			infoRspMsg.setMemberInfoRsp(infoRsp);
			infoRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
			infoRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
			logger.info("校验会员信息服务端接口成功!");
			return infoRspMsg;

		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("服务端接口校验会员信息错误", e);
			infoRspMsg.setRetCode(Constant.RETSHOW_FAIL);
			infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return infoRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("服务端接口校验会员信息错误", e);
			infoRspMsg.setRetCode(Constant.RETSHOW_FAIL);
			infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return infoRspMsg;
		}
		
	}

	/**
	 * 查找所有商品分类信息
	 */
	@Override
	public CategoryRspMsg queryCategorys(CategoryReqMsg categoryReqMsg) {
		logger.info("开始查询商品分类信息服务端接口");
		CategoryRspMsg categoryRspMsg = new CategoryRspMsg();
		CategoryRsp categoryRsp = new CategoryRsp();
		List<Category> categorys = new ArrayList<Category>();
		List<CategoryInfo> categoryInfos = categoryInfoService
				.queryAllCategoryInfoByCategoryId(categoryReqMsg
						.getCategoryReq().getT_categoryId());
		// 添加验证信息
		Head head = categoryReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				categoryRspMsg.setRetCode(Constant.RETCODE_FAIL);
				categoryRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return categoryRspMsg;
			}
		}
		logger.info("查询商品分类信息请求头验证成功!");
		try {
			for (CategoryInfo source : categoryInfos) {
				Category target = new Category();
				BeanUtils.copyProperties(target, source);
				categorys.add(target);
			}
			categoryRsp.setCategorys(categorys);
			categoryRspMsg.setCategoryRsp(categoryRsp);
			categoryRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
			categoryRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("服务端接口查找商品分类信息错误", e);
			categoryRspMsg.setRetCode(Constant.RETCODE_FAIL);
			categoryRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return categoryRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("服务端接口查找商品分类信息错误", e);
			categoryRspMsg.setRetCode(Constant.RETCODE_FAIL);
			categoryRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return categoryRspMsg;
		}
		logger.info("服务端接口查找商品分类信息完成");
		categoryRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
		categoryRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
		return categoryRspMsg;
	}

	/**
	 * 修改会员信息
	 */
	@Override
	public MemberInfoRspMsg memberUpdate(MemberInfoReqMsg infoReqMsg) {
		logger.info("进入修改会员信息服务端接口");
		MemberInfoReq infoReq = infoReqMsg.getMemberInfoReq();
		MemberInfos infos = infoReq.getMemberInfos();
		MemberInfo info = new MemberInfo();
		MemberInfoRspMsg infoRspMsg = new MemberInfoRspMsg();
		MemberInfoRsp infoRsp = new MemberInfoRsp();
		// 添加验证信息
		Head head = infoReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
				infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return infoRspMsg;
			}
		}
		MemberInfos memberInfos = new MemberInfos();
		MemberInfo memberInfo = null;
		try {
			BeanUtils.copyProperties(info, infos);
			memberInfo = memberInfoService.updateMemberInfo(info);
			BeanUtils.copyProperties(memberInfos, memberInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("服务端接口修改会员信息错误", e);
			infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
			infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return infoRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("服务端接口修改会员信息错误", e);
			infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
			infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return infoRspMsg;
		}
		infoRsp.setMemberInfos(memberInfos);
		infoRspMsg.setMemberInfoRsp(infoRsp);
		infoRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
		infoRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
		logger.info("修改会员信息完成服务端接口");
		return infoRspMsg;
	}

	/**
	 * 查询用户订单信息
	 */
	@Override
	public OrderRspMsg orderQuery(OrderReqMsg orderReqMsg) {
		logger.info("进入查询用户订单信息服务端接口");
		OrderReq orderReq = orderReqMsg.getOrderReq();
		Order order = orderReq.getOrder();
		String memberId = order.getMemberId();
		String orderStatus = order.getOrderStatus();
		OrderRspMsg orderRspMsg = new OrderRspMsg();
		// 添加验证信息
		Head head = orderReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
			}
		}
		List<OrderInfo> orderInfos = orderInfoService.queryByMemberId(memberId,orderStatus);
		List<Order> orders = new ArrayList<Order>();
		try {
			for (OrderInfo orderInfo : orderInfos) {
				Order order2 = new Order();
				BeanUtils.copyProperties(order2, orderInfo);
				orders.add(order);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("查询用户订单信息错误:", e);
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("查询用户订单信息错误:", e);
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		}
		OrderRsp orderRsp = new OrderRsp();
		orderRsp.setOrders(orders);
		orderRspMsg.setOrderRsp(orderRsp);
		orderRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
		orderRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
		return orderRspMsg;
	}

	/**
	 * 查询收件人信息
	 */
	@Override
	public AddressRspMsg addressQuery(AddressReqMsg addressReqMsg) {
		logger.info("开始查询收件人信息服务端接口......");
		AddressReq addressReq = addressReqMsg.getAddressReq();
		String addressId = addressReq.getAddress().getAddressId();
		AddressRspMsg addressRspMsg = new AddressRspMsg();
		// 添加验证信息
		Head head = addressReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		if (null != addressId && !"".equals(addressId)) {
			try {
				List<AddressInfo> infos = addressInfoService.queryAddressInfo(
						null, addressId);
				List<Address> addresses = new ArrayList<Address>();
				for (AddressInfo addressInfo : infos) {
					Address address = new Address();
					BeanUtils.copyProperties(address, addressInfo);
					addresses.add(address);
				}
				AddressRsp addressRsp = new AddressRsp();
				addressRsp.setAddresses(addresses);
				addressRspMsg.setAddressRsp(addressRsp);
				addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return addressRspMsg;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				logger.info("查询用户收件信息错误:", e);
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				logger.info("查询用户收件信息错误:", e);
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		String memberId = addressReq.getAddress().getMemberId();
		if (null != memberId && !"".equals(memberId)) {
			try {
				List<AddressInfo> infos = addressInfoService.queryAddressInfo(
						memberId, null);
				List<Address> addresses = new ArrayList<Address>();
				for (AddressInfo addressInfo : infos) {
					Address address = new Address();
					BeanUtils.copyProperties(address, addressInfo);
					addresses.add(address);
				}
				AddressRsp addressRsp = new AddressRsp();
				addressRsp.setAddresses(addresses);
				addressRspMsg.setAddressRsp(addressRsp);
				addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return addressRspMsg;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				logger.info("查询用户收件信息错误:", e);
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				logger.info("查询用户收件信息错误:", e);
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		logger.info("查询用户收件信息异常");
		addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
		addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
		return addressRspMsg;
	}

	/**
	 * 保存收件人信息
	 */
	@Override
	public AddressRspMsg addressSave(AddressReqMsg addressReqMsg) {
		logger.info("开始保存用户收件信息");
		AddressReq addressReq = addressReqMsg.getAddressReq();
		Address address = addressReq.getAddress();
		AddressInfo addressInfo = new AddressInfo();
		AddressRspMsg addressRspMsg = new AddressRspMsg();
		AddressRsp addressRsp = new AddressRsp();
		// 添加验证信息
		Head head = addressReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(addressInfo, address);
			boolean save = addressInfoService.saveAddressInfo(addressInfo);
			if(save){
				addressRspMsg.setAddressRsp(addressRsp);
				addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return addressRspMsg;
			}
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("保存用户收件信息错误:", e);
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("保存用户收件信息错误:", e);
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		}
	}
	/**
	 * 删除收件人信息
	 */
	@Override
	public AddressRspMsg addressDel(AddressReqMsg addressReqMsg) {
		logger.info("开始删除收件人信息");
		AddressReq addressReq = addressReqMsg.getAddressReq();
		Address address = addressReq.getAddress();
		AddressInfo addressInfo = new AddressInfo();
		AddressRspMsg addressRspMsg = new AddressRspMsg();
		AddressRsp addressRsp = new AddressRsp();
		// 添加验证信息
		Head head = addressReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(addressInfo, address);
			boolean del = addressInfoService.delAddressInfo(addressInfo);
			if(del){
				addressRspMsg.setAddressRsp(addressRsp);
				addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return addressRspMsg;
			}
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("删除用户收件信息错误:", e);
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("删除用户收件信息错误:", e);
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		}
	}
	/**
	 * 修改收件人信息
	 */
	@Override
	public AddressRspMsg addressUpdate(AddressReqMsg addressReqMsg) {
		logger.info("开始修改收件人信息");
		AddressReq addressReq = addressReqMsg.getAddressReq();
		Address address = addressReq.getAddress();
		AddressInfo addressInfo = new AddressInfo();
		AddressRspMsg addressRspMsg = new AddressRspMsg();
		AddressRsp addressRsp = new AddressRsp();
		// 添加验证信息
		Head head = addressReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(addressInfo, address);
			boolean update = addressInfoService.updateAddressInfo(addressInfo);
			if(update){
				
				addressRspMsg.setAddressRsp(addressRsp);
				addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return addressRspMsg;
			}
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.info("修改用户收件信息错误:", e);
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			logger.info("修改用户收件信息错误:", e);
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return addressRspMsg;
		}
	}

	@Override
	public EmaillRspMsg sendEmaillCode(EmaillReqMsg emaillReqMsg) {
		logger.info("开始发送邮件验证码.......");
		EmaillRspMsg emaillRspMsg = new EmaillRspMsg();
		EmaillReq emaillReq = emaillReqMsg.getEmaillReq();
		Emaill emaill = emaillReq.getEmaill();
		String email = emaill.getToWhere(); 
		String code = EamilCodeUtils.getEmailCode();
		// 添加验证信息
		Head head = emaillReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
				emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return emaillRspMsg;
			}
		}
		if(null != email && !"".equals(email)){
				String str = "久义购邮箱验证码:</br>"+code+"</br> 请不要告诉别人";
				EmaillInfo emaillInfo = new EmaillInfo();
				emaillInfo.setToWhere(email);
				emaillInfo.setCodeStatus("0");
				emaillInfo.setEmContent(str);
				emaillInfo.setEmStatus("1");
				emaillInfo.setEmTimes(new Date());
				emaillInfo.setEmTitle("会员注册发送验证码！");
				emaillInfo.setVerificationCode(code);
				SendEmail.send(email,str);
				emaillInfo.setEmStimes(new Date());
				if(emaillInfoService.saveEmaillInfo(emaillInfo)){
					emaillRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
					emaillRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
					logger.info("发送邮件验证码成功.......");
					return emaillRspMsg;
				}
				emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
				emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				logger.info("发送邮件验证码失败.......");
				return emaillRspMsg;
		}else{
			emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
			emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return emaillRspMsg;
		}
		
		
	}
	/**
	 * 查询邮件验证码
	 */
	@Override
	public EmaillRspMsg emaillQuery(EmaillReqMsg emaillReqMsg) {
		logger.info("开始查询邮件验证码......");
		EmaillRspMsg emaillRspMsg = new EmaillRspMsg();
		EmaillRsp emaillRsp = new EmaillRsp();
		EmaillReq emaillReq = emaillReqMsg.getEmaillReq();
		Emaill emaill = emaillReq.getEmaill();
		String email = emaill.getToWhere(); 
		// 添加验证信息
		Head head = emaillReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
				emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return emaillRspMsg;
			}
		}
		try {
			EmaillInfo emaillInfos = emaillInfoService.queryEmaillCode(email);
			Emaill emaills = new Emaill();
			if(null!=emaillInfos){
				BeanUtils.copyProperties(emaills, emaillInfos);
				emaillRsp.setEmaill(emaills);
				emaillRspMsg.setEmaillRsp(emaillRsp);
				emaillRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				emaillRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				logger.info("查询邮件验证码成功.......");
				return emaillRspMsg;
			}else{
				emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
				emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				logger.info("查询邮件验证码失败.......");
				return emaillRspMsg;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
			emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("查询邮件验证码失败.......");
			return emaillRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
			emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("查询邮件验证码失败.......");
			return emaillRspMsg;
		}
	}

	@Override
	public EmaillRspMsg emaillUpdate(EmaillReqMsg emaillReqMsg) {
		logger.info("开始修改邮件验证码状态......");
		EmaillRspMsg emaillRspMsg = new EmaillRspMsg();
		EmaillReq emaillReq = emaillReqMsg.getEmaillReq();
		Emaill emaill = emaillReq.getEmaill();
		// 添加验证信息
		Head head = emaillReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
				emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return emaillRspMsg;
			}
		}
		EmaillInfo emaillInfo = new EmaillInfo();
		try {
			BeanUtils.copyProperties(emaillInfo, emaill);
			if(emaillInfoService.updateEmail(emaillInfo)){
				emaillRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				emaillRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				logger.info("修改邮件验证码状态成功.......");
				return emaillRspMsg;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
			emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("修改邮件验证码状态失败.......");
			return emaillRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
			emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("修改邮件验证码状态失败.......");
			return emaillRspMsg;
		}
		emaillRspMsg.setRetCode(Constant.RETCODE_FAIL);
		emaillRspMsg.setRetShow(Constant.RETSHOW_FAIL);
		logger.info("修改邮件验证码状态失败.......");
		return emaillRspMsg;
	}
	/**
	 * 会员激活
	 */
	@Override
	public MemberInfoRspMsg processActivate(MemberInfoReqMsg infoReqMsg) {
		logger.info("开始激活会员信息......");
		MemberInfoReq infoReq = infoReqMsg.getMemberInfoReq();
		MemberInfos infos = infoReq.getMemberInfos();
		MemberInfoRspMsg infoRspMsg = new MemberInfoRspMsg();
		// 添加验证信息
		Head head = infoReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
				infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return infoRspMsg;
			}
		}
		if(null == infos.getMemberEmail() && null == infos.getValidateCode()){
			infoRspMsg.setRetCode(Constant.RETCODE_FAIL);
			infoRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("会员信息不存在......");
			return infoRspMsg;
		}
		String str= memberInfoService.processActivate(infos.getMemberEmail(), infos.getValidateCode());
		infoRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
		infoRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
		logger.info("会员信息"+str);
		return infoRspMsg;
	}
	/**
	 * 校验地址信息是否重复
	 */
	@Override
	public AddressRspMsg addressCheck(AddressReqMsg addressReqMsg) {
		logger.info("开始校验收件人信息......");
		AddressReq addressReq = addressReqMsg.getAddressReq();
		Address address = addressReq.getAddress();
		AddressRspMsg addressRspMsg = new AddressRspMsg();
		AddressRsp addressRsp = new AddressRsp();
		// 添加验证信息
		Head head = addressReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
				addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return addressRspMsg;
			}
		}
		AddressInfo addressInfo = new AddressInfo();
		try {
			if(null != address && !"".equals(address)){
				BeanUtils.copyProperties(addressInfo, address);
				boolean ckeck = addressInfoService.checkAddressInfo(addressInfo);
				if(ckeck){
					addressRsp.setCheck(ckeck);
					addressRspMsg.setAddressRsp(addressRsp);
					addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
					addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
					logger.info("校验收件人信息成功,返回true......");
					return addressRspMsg;
				}
				addressRsp.setCheck(ckeck);
				addressRspMsg.setAddressRsp(addressRsp);
				addressRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				addressRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				logger.info("校验收件人信息成功,返回false......");
				return addressRspMsg;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("校验收件人信息异常......");
			return addressRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			addressRspMsg.setRetCode(Constant.RETCODE_FAIL);
			addressRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			logger.info("校验收件人信息异常......");
			return addressRspMsg;
		}
		
		return addressRspMsg;
	}
	/**
	 * 
	 */
	@Override
	public EvaluateRspMsg evaluateQuery(EvaluateReqMsg evaluateReqMsg) {
		logger.info("开始查询评价信息......");
		EvaluateRspMsg evaluateRspMsg = new EvaluateRspMsg();
		EvaluateRsp evaluateRsp = new EvaluateRsp();
		EvaluateReq evaluateReq = evaluateReqMsg.getEvaluateReq();
		Evaluate evaluate = evaluateReq.getEvaluate();
		// 添加验证信息
		Head head = evaluateReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return evaluateRspMsg;
			}
		}
		try {
			List<Evaluate> evaluates = new ArrayList<Evaluate>();
			if (null != evaluate.getEvalPersonId()
					&& null != evaluate.getEvalProducdId()) {
				List<EvaluateInfo> evaluateInfos = evaluateService
						.queryEvaluateInfo(evaluate.getEvalPersonId(),
								evaluate.getEvalProducdId());
				if (null != evaluateInfos && !"".equals(evaluateInfos)) {
					for (EvaluateInfo evaluateInfo : evaluateInfos) {
						Evaluate evaluate_1 = new Evaluate();
						BeanUtils.copyProperties(evaluate_1, evaluateInfo);
						evaluates.add(evaluate);
					}
					evaluateRsp.setEvaluates(evaluates);
					evaluateRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
					evaluateRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
					return evaluateRspMsg;
				}
				evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return evaluateRspMsg;
			}
			evaluateRspMsg.setRetCode(Constant.PARAM_FAIL_CODE);
			evaluateRspMsg.setRetShow(Constant.PARAM_FAIL_SHOW);
			return evaluateRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		}
	}

	/* (non-Javadoc)
	 * @see com.jiuyi.net.service.IEmallEXChangesService#queryCitys(com.jiuyi.net.mesage.citys.CitysReqMsg)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public CitysRspMsg queryCitys(CitysReqMsg citysReqMsg) {
		CitysReq citysReq = citysReqMsg.getCitysReq();
		CitysRspMsg citysRspMsg = new CitysRspMsg();
		CitysRsp citysRsp = new CitysRsp();
		// 添加验证信息
		Head head = citysReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				citysRspMsg.setRetCode(Constant.RETCODE_FAIL);
				citysRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return citysRspMsg;
			}
		}
		 List<T_position_provice> position_provices_ = new ArrayList<T_position_provice>();
		 List<T_position_city> position_cities_ = new ArrayList<T_position_city>();
		 List<T_position_county> position_counties_ = new ArrayList<T_position_county>();
		 List<T_position_town> position_towns_ = new ArrayList<T_position_town>();
		 List<T_position_village> position_villages_ = new ArrayList<T_position_village>();
		try {
			Session session = sessionFactory.openSession();
			//查询省 
			String provSql=" select a.provice_id , a.provice_name from t_position_provice a where 1=1";
			List list_1 =  session.createSQLQuery(provSql).list();
			if(null!=list_1 && list_1.size()>0){
				for (int i = 0; i < list_1.size(); i++) {
					T_position_provice provice = new T_position_provice();
					Object[] obj = (Object[]) list_1.get(i);
					provice.setProvice_id(obj[0]+"");
					provice.setProvice_name(obj[1]+"");
					position_provices_.add(provice);
				}
			}
			//查询市
			String citySql="  select b.city_id , b.city_name , b.province_id from t_position_city b where b.province_id = '"+citysReq.getProvice_id()+"'";
			List list_2 =  session.createSQLQuery(citySql).list();
			if(null!=list_2 && list_2.size()>0){
				for (int i = 0; i < list_2.size(); i++) {
					T_position_county county = new T_position_county();
					Object[] obj = (Object[]) list_2.get(i);
					county.setCounty_id(obj[0]+"");
					county.setCounty_name(obj[1]+"");
					position_counties_.add(county);
				}
			}
			//查询县\区
			String countySql="  select c.county_id , c.county_name  , c.city_id  from t_position_county c  where c.city_id = '"+citysReq.getCity_id()+"'";
			List list_3 =  session.createSQLQuery(countySql).list();
			if(null!=list_3 && list_3.size()>0){
				for (int i = 0; i < list_3.size(); i++) {
					T_position_city city = new T_position_city();
					Object[] obj = (Object[]) list_3.get(i);
					city.setCity_id(obj[0]+"");
					city.setCity_name(obj[1]+"");
					position_cities_.add( city);
				}
			}
			
			//查询镇\街道
			String townSql="select d.town_id , d.town_name  from t_position_town d where d.county_id = '"+citysReq.getCounty_id()+"' ";
			List list_4 =  session.createSQLQuery(townSql).list();
			if(null!=list_4 && list_4.size()>0){
				for (int i = 0; i < list_4.size(); i++) {
					T_position_town town = new T_position_town();
					Object[] obj = (Object[]) list_4.get(i);
					town.setTown_id(obj[0]+"");
					town.setTown_name(obj[1]+"");
					position_towns_.add(town);
				}
			}
			//查询村
			String villageSql="select e.village_id , e.village_name from t_position_village e   where e.town_id = '"+citysReq.getTown_id()+"'";
			List list_5 =  session.createSQLQuery(villageSql).list();
			if(null!=list_5 && list_5.size()>0){
				for (int i = 0; i < list_5.size(); i++) {
					T_position_village village = new T_position_village();
					Object[] obj = (Object[]) list_5.get(i);
					village.setVillage_id(obj[0]+"");
					village.setVillage_name(obj[1]+"");
					position_villages_.add(village);
				}
			}
			citysRsp.setCities(position_cities_);
			citysRsp.setCounties(position_counties_);
			citysRsp.setProvices(position_provices_);
			citysRsp.setTowns(position_towns_);
			citysRsp.setVillages(position_villages_);
			citysRspMsg.setCitysRsp(citysRsp);
			citysRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
			citysRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
			
		} catch (Exception e) {
			logger.info("查询省、市、县、区、镇、村异常");
			logger.info(e.getStackTrace().toString());
			citysRspMsg.setRetCode(Constant.RETCODE_FAIL);
			citysRspMsg.setRetShow(Constant.RETSHOW_FAIL);
		}
		return citysRspMsg;
	}

	@Override
	public CollectionRspMsg optCollectionInfo(CollectionReqMsg collectionReqMsg) {
		CollectionRspMsg collectionRspMsg = new CollectionRspMsg();
		CollectionRsp collectionRsp = new CollectionRsp();
		CollectionReq collectionReq = collectionReqMsg.getCollectionReq();
		// 添加验证信息
		Head head = collectionReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				collectionRspMsg.setRetCode(Constant.RETCODE_FAIL);
				collectionRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return collectionRspMsg;
			}
		}
		if(null== collectionReq.getOpt() || "".equals(collectionReq.getOpt()) || null ==collectionReq.getCollectionInfo()){
			collectionRspMsg.setRetCode(Constant.PARAM_FAIL_CODE);
			collectionRspMsg.setRetShow(Constant.PARAM_FAIL_SHOW);
			return collectionRspMsg;
		}
		//分页查询
		if("query".equals(collectionReq.getOpt())){
			logger.info("开始查询我的收藏");
			PageResults<CollectionInfo> pageResults;
			try {
				pageResults = collectionInfoService.queryPageCollectionInfo(
						collectionReq.getCollectionInfo(),
						collectionReq.getPageResults());
				collectionRsp.setPageResults(pageResults);
				collectionRspMsg.setCollectionRsp(collectionRsp);
				collectionRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				collectionRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return collectionRspMsg;
			} catch (Exception e) {
				collectionRspMsg.setRetCode(Constant.RETCODE_FAIL);
				collectionRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return collectionRspMsg;
			}
		}
		//保存
		if("save".equals(collectionReq.getOpt())){
			logger.info("保存我的收藏");
			if(collectionInfoService.saveCollectionInfo(collectionReq.getCollectionInfo())){
				collectionRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				collectionRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
			}else{
				collectionRspMsg.setRetCode(Constant.RETCODE_FAIL);
				collectionRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			}
			return collectionRspMsg;
		}
		//删除
		if("delete".equals(collectionReq.getOpt())){
			logger.info("删除我的收藏");
			if (collectionInfoService.deleteCollectionInfo(collectionReq.getCollectionInfo())) {
				collectionRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				collectionRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
			}else{
				collectionRspMsg.setRetCode(Constant.RETCODE_FAIL);
				collectionRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			}
			return collectionRspMsg;
		}
		return collectionRspMsg;
	}

	@Override
	public EvaluateRspMsg evaluateSave(EvaluateReqMsg evaluateReqMsg) {
		EvaluateReq evaluateReq = evaluateReqMsg.getEvaluateReq();
		Evaluate evaluate = evaluateReq.getEvaluate();
		EvaluateRspMsg evaluateRspMsg = new EvaluateRspMsg();
		EvaluateInfo emaillInfo = new EvaluateInfo();
		// 添加验证信息
		Head head = evaluateReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return evaluateRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(emaillInfo, evaluate);
			boolean save= evaluateService.saveEvaluateInfo(emaillInfo);
			if(save){
				evaluateRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return evaluateRspMsg;
			}
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		}
	}

	@Override
	public EvaluateRspMsg evaluateUpdate(EvaluateReqMsg evaluateReqMsg) {
		EvaluateReq evaluateReq = evaluateReqMsg.getEvaluateReq();
		Evaluate evaluate = evaluateReq.getEvaluate();
		EvaluateRspMsg evaluateRspMsg = new EvaluateRspMsg();
		EvaluateInfo emaillInfo = new EvaluateInfo();
		// 添加验证信息
		Head head = evaluateReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return evaluateRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(emaillInfo, evaluate);
			boolean update= evaluateService.updateEvaluateInfo(emaillInfo);
			if(update){
				evaluateRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return evaluateRspMsg;
			}
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		}			
	}

	@Override
	public EvaluateRspMsg evaluateDel(EvaluateReqMsg evaluateReqMsg) {
		EvaluateReq evaluateReq = evaluateReqMsg.getEvaluateReq();
		Evaluate evaluate = evaluateReq.getEvaluate();
		EvaluateRspMsg evaluateRspMsg = new EvaluateRspMsg();
		EvaluateInfo emaillInfo = new EvaluateInfo();
		// 添加验证信息
		Head head = evaluateReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return evaluateRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(emaillInfo, evaluate);
			boolean del = evaluateService.deleteEvaluateInfo(emaillInfo);
			if(del){
				evaluateRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				evaluateRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return evaluateRspMsg;
			}
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			evaluateRspMsg.setRetCode(Constant.RETCODE_FAIL);
			evaluateRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return evaluateRspMsg;
		}
	}

	@Override
	public SuggestRspMsg suggestQuery(SuggestReqMsg suggestReqMsg) {
		logger.info("开始查询建议信息......");
		SuggestRspMsg suggestRspMsg = new SuggestRspMsg();
		SuggestReq suggestReq = suggestReqMsg.getSuggestReq();
		String suggestPersonId = suggestReq.getSuggest().getSuggestPersonId();
		SuggestRsp suggestRsp = new SuggestRsp();
		// 添加验证信息
		Head head = suggestReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
				suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return suggestRspMsg;
			}
		}
		try {
			List<Suggest> suggests = new ArrayList<Suggest>();
			List<SuggestInfo> suggestInfos = suggestInfoService.querySuggestInfo(suggestPersonId);
			if(null != suggestInfos && !"".equals(suggestInfos)){
				for (SuggestInfo suggestInfo : suggestInfos) {
					Suggest suggest = new Suggest();
					BeanUtils.copyProperties(suggest, suggestInfo);
					suggests.add(suggest);
				}
				suggestRsp.setSuggests(suggests);
				suggestRspMsg.setSuggestRsp(suggestRsp);
				suggestRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				suggestRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return suggestRspMsg;
			}
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		}
	}

	@Override
	public SuggestRspMsg suggestSave(SuggestReqMsg suggestReqMsg) {
		SuggestReq suggestReq = suggestReqMsg.getSuggestReq();
		Suggest suggest = suggestReq.getSuggest();
		SuggestRspMsg suggestRspMsg = new SuggestRspMsg();
		SuggestInfo suggestInfo = new SuggestInfo();
		// 添加验证信息
		Head head = suggestReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
				suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return suggestRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(suggestInfo, suggest);
			boolean save = suggestInfoService.saveSuggestInfo(suggestInfo);
			if(save){
				suggestRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				suggestRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return suggestRspMsg;
			}
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		}
	}

	@Override
	public SuggestRspMsg suggestUpdate(SuggestReqMsg suggestReqMsg) {
		SuggestReq suggestReq = suggestReqMsg.getSuggestReq();
		Suggest suggest = suggestReq.getSuggest();
		SuggestRspMsg suggestRspMsg = new SuggestRspMsg();
		SuggestInfo suggestInfo = new SuggestInfo();
		// 添加验证信息
		Head head = suggestReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
				suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return suggestRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(suggestInfo, suggest);
			boolean update = suggestInfoService.updateSuggestInfo(suggestInfo);
			if(update){
				suggestRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				suggestRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return suggestRspMsg;
			}
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		}
	}

	@Override
	public SuggestRspMsg suggestDel(SuggestReqMsg suggestReqMsg) {
		SuggestReq suggestReq = suggestReqMsg.getSuggestReq();
		Suggest suggest = suggestReq.getSuggest();
		SuggestRspMsg suggestRspMsg = new SuggestRspMsg();
		SuggestInfo suggestInfo = new SuggestInfo();
		// 添加验证信息
		Head head = suggestReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
				suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return suggestRspMsg;
			}
		}
		try {
			BeanUtils.copyProperties(suggestInfo, suggest);
			boolean del = suggestInfoService.deleteSuggestInfo(suggestInfo);
			if(del){
				suggestRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
				suggestRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
				return suggestRspMsg;
			}
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			suggestRspMsg.setRetCode(Constant.RETCODE_FAIL);
			suggestRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return suggestRspMsg;
		}
	}
	@Override
	public OrderRspMsg orderSave(OrderReqMsg orderReqMsg) {
		logger.info("开始保存用户订单信息服务端接口");
		OrderReq orderReq = orderReqMsg.getOrderReq();
		Order order = orderReq.getOrder();
		OrderInfo orderInfo = new OrderInfo();
		OrderRspMsg orderRspMsg = new OrderRspMsg();
		// 添加验证信息
		Head head = orderReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
			}
		}
		try {
			if(null != order && !"".equals(order)){
				BeanUtils.copyProperties(orderInfo, order);
				boolean save = orderInfoService.saveOrderInfo(orderInfo);
				if(save){
					orderRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
					orderRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
					return orderRspMsg;
				}
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
				
			}else{
				orderRspMsg.setRetCode(Constant.PARAM_FAIL_CODE);
				orderRspMsg.setRetShow(Constant.PARAM_FAIL_SHOW);
				return orderRspMsg;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		}
	}
	
	@Override
	public OrderRspMsg orderUpdate(OrderReqMsg orderReqMsg) {
		logger.info("开始保存用户订单信息服务端接口");
		OrderReq orderReq = orderReqMsg.getOrderReq();
		Order order = orderReq.getOrder();
		OrderInfo orderInfo = new OrderInfo();
		OrderRspMsg orderRspMsg = new OrderRspMsg();
		// 添加验证信息
		Head head = orderReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword
					.equals(SystemValueInit.UPAWORD))) {
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
			}
		}
		try {
			if(null != order && !"".equals(order)){
				BeanUtils.copyProperties(orderInfo, order);
				boolean update = orderInfoService.updateOrderInfo(orderInfo);
				if(update){
					orderRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
					orderRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
					return orderRspMsg;
				}
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
			}else{
				orderRspMsg.setRetCode(Constant.PARAM_FAIL_CODE);
				orderRspMsg.setRetShow(Constant.PARAM_FAIL_SHOW);
				return orderRspMsg;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		}
	}
	
	@Override
	public OrderRspMsg orderDel(OrderReqMsg orderReqMsg) {
		logger.info("开始删除用户订单信息服务端接口");
		OrderReq orderReq = orderReqMsg.getOrderReq();
		Order order = orderReq.getOrder();
		OrderInfo orderInfo = new OrderInfo();
		OrderRspMsg orderRspMsg = new OrderRspMsg();
		// 添加验证信息
		Head head = orderReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
			}
		}
		try {
			if(null != order && !"".equals(order)){
				BeanUtils.copyProperties(orderInfo, order);
				boolean del = orderInfoService.delOrderInfo(orderInfo);
				if(del){
					orderRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
					orderRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
					logger.info("删除用户订单信息成功");
					return orderRspMsg;
				}
				orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
				orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return orderRspMsg;
			}else{
				orderRspMsg.setRetCode(Constant.PARAM_FAIL_CODE);
				orderRspMsg.setRetShow(Constant.PARAM_FAIL_SHOW);
				return orderRspMsg;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			orderRspMsg.setRetCode(Constant.RETCODE_FAIL);
			orderRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return orderRspMsg;
		}
	}

	@Override
	public ProductRspMsg productQuery(ProductReqMsg productReqMsg) {
		ProductReq productReq = productReqMsg.getProductReq();
		Product product = productReq.getProduct();
		ProductRspMsg productRspMsg = new ProductRspMsg();
		ProductRsp productRsp = new ProductRsp();
		// 添加验证信息
		Head head = productReqMsg.getMsghead();
		if (null != head) {
			String uName = MD5.HPEncode(head.getuName(), "GBK");
			String uPword = MD5.HPEncode(head.getpWord(), "GBK");
			if (!(uName.equals(SystemValueInit.UNAME) && uPword.equals(SystemValueInit.UPAWORD))) {
				productRspMsg.setRetCode(Constant.RETCODE_FAIL);
				productRspMsg.setRetShow(Constant.RETSHOW_FAIL);
				return productRspMsg;
			}
		}
		try {
			if(null != product.getStoreId() && !"".equals(product.getStoreId())){
				List<Product> products = new ArrayList<Product>();
				List<ProductInfo> productInfos = productInfoService.queryProduct(product.getStoreId());
				if(null != productInfos && !"".equals(productInfos)){
					for (ProductInfo productInfo : productInfos) {
						Product product2  = new Product();
						BeanUtils.copyProperties(product2, productInfo);
						products.add(product2);
						productRsp.setProducts(products);
						productRspMsg.setProductRsp(productRsp);
						productRspMsg.setRetCode(Constant.RETCODE_SUCCESS);
						productRspMsg.setRetShow(Constant.RETSHOW_SUCCESS);
						return productRspMsg;
					}
				}
				productRspMsg.setRetCode(Constant.PARAM_FAIL_CODE);
				productRspMsg.setRetShow(Constant.PARAM_FAIL_SHOW);
				return productRspMsg;
			}
			productRspMsg.setRetCode(Constant.RETCODE_FAIL);
			productRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return productRspMsg;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			productRspMsg.setRetCode(Constant.RETCODE_FAIL);
			productRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return productRspMsg;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			productRspMsg.setRetCode(Constant.RETCODE_FAIL);
			productRspMsg.setRetShow(Constant.RETSHOW_FAIL);
			return productRspMsg;
		}
	}
	
	
	
	
	
	
	
}
