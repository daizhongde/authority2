package com.asiainfo.authority.spring.service;

import java.util.List;

import com.asiainfo.authority.hibernate.pojo.TAuthorityUser;

import person.daizhongde.virtue.spring.BaseService;

public interface TAuthorityFuncService extends BaseService{

	public abstract int add( String jdata, TAuthorityUser user );
	
	public abstract String getCBBData_CodeAndName(String jdata);
}