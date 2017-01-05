package com.jiuyi.jyplant.seller.controller;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiuyi.jyplant.seller.entity.License;
import com.jiuyi.jyplant.seller.entity.OrgCode;
import com.jiuyi.jyplant.seller.entity.Tax;
import com.jiuyi.jyplant.seller.entity.VenderApply;
import com.jiuyi.jyplant.seller.service.LicenseService;
import com.jiuyi.jyplant.seller.service.OrgCodeService;
import com.jiuyi.jyplant.seller.service.ShopService;
import com.jiuyi.jyplant.seller.service.TaxService;
import com.jiuyi.jyplant.seller.service.VenderApplyService;


@Controller
@RequestMapping(value="/seller")
public class VenderApplyController {
	
	private static final Logger LOGGER = Logger.getLogger(VenderApplyController.class);
	@Autowired
	private VenderApplyService venderApplyService;
	@Autowired
	private LicenseService licenseService;
	
	@Autowired
	private TaxService taxService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OrgCodeService orgCodeService;
	
	
	
	/**
	 * 进入商户入驻
	 * @return
	 */
	@RequestMapping("/entrance")
	public String entrance(){
		LOGGER.info("开始进入入驻须知！");
		return "/seller/entrance";
		
	}
	/**
	 * 进入商户入驻-联系方式
	 * @return
	 */
	@RequestMapping("/contactWay")
	public String contactWay(@ModelAttribute("venderApply") VenderApply venderApply){
		LOGGER.info("开始进入商户入驻-联系方式！");
		return "/seller/contactWay";
	}
	/**
	 * 提交商户资质-公司信息
	 * @return
	 */
	@RequestMapping("/qualifications")
	public String qualifications(Model model,@ModelAttribute("venderApply") VenderApply venderApply){
		LOGGER.info("开始进入商户资质-公司信息！");
//		StoreDTO venderApplyStoreDTO;
//		try {
//			venderApplyStoreDTO = storeConnector.save("E:\\", ""+upFile.getName(), new MultipartFileResource(upFile),upFile.getOriginalFilename());
//			venderApply.setComFilePath(venderApplyStoreDTO.getKey());
//		} catch (Exception e) {
//			LOGGER.error("保存法人身份证失败！");
//			e.printStackTrace();
//		}
		venderApply = venderApplyService.saveVenderApply(venderApply);
		model.addAttribute("venderApply", venderApply);
		return "/seller/qualifications";
		
	}
	/**
	 * 提交商户资质-银行信息
	 * @return
	 */
	@RequestMapping("/bankInfo")
	public String bankInfo(@ModelAttribute("venderApply") VenderApply venderApply,
			@ModelAttribute("license") License license,
			@ModelAttribute("orgCode") OrgCode orgCode
			){
		LOGGER.info("开始进入商户资质-银行信息！");
//		try {
//				StoreDTO licenseStoreDTO = storeConnector.save("E:\\", ""+upFile[1].getName(), new MultipartFileResource(upFile[1]),upFile[1].getOriginalFilename());
//				license.setLicenseFilePath(licenseStoreDTO.getKey());
//				StoreDTO taxStoreDTO = storeConnector.save("E:\\", ""+upFile[2].getName(), new MultipartFileResource(upFile[2]),upFile[2].getOriginalFilename());
//				tax.setTaxFilePath(taxStoreDTO.getKey());
//			
//		} catch (Exception e) {
//			LOGGER.error("上传失败");
//			e.printStackTrace();
//		}
		licenseService.saveLicense(license);
		orgCodeService.saveOrgCode(orgCode);
		return "/seller/qualifications";
		
	}
	/**
	 * 提交商户资质-店铺信息
	 * @return
	 */
	@RequestMapping("/store")
	public String store(@ModelAttribute("tax") Tax tax){
		LOGGER.info("开始进入商户资质-店铺信息！");
		taxService.saveTax(tax);
		return "/seller/bankInfo";
		
	}
	
	
	
	
	
	
	
	
	
	
}
