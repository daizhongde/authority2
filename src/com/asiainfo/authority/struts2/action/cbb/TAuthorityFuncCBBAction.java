package com.asiainfo.authority.struts2.action.cbb;

import java.io.UnsupportedEncodingException;

import com.asiainfo.authority.spring.service.TAuthorityFuncService;
import com.asiainfo.authority.struts2.action.BaseAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 按钮(功能)信息相关下拉框数据
 * combobox data
 * @author dzd
 *
 */
public class TAuthorityFuncCBBAction extends ActionSupport implements Action  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1625277481198555717L;

	protected String jdata;
	
	private String sResponse;

	protected TAuthorityFuncService dataService;
	
	/**
	 * 下拉框Json数据
	 * <p>cbb : combobox
	 * @return JSONObject 
	 */
	public String getCBBData_CodeAndName(){
//		log.debug("action............getCBBData_Id........");
		if( null == jdata || jdata.trim().equalsIgnoreCase("")){
			jdata = "{ act: \"queryCBB\",condition: {},operator : {} }";
		}
		sResponse = dataService.getCBBData_CodeAndName(jdata);
		return "sResponse";
	}

	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
//		log.debug("decoded jdata:" + decode.toString());
		this.jdata = decode;
	}
	public void setSResponse(String sResponse) {
		this.sResponse = sResponse;
	}
	public String getSResponse() {
		return sResponse;
	}
	public void setDataService(TAuthorityFuncService dataService) {
		this.dataService = dataService;
	}
}
