package com.car.mvc.sevices.impl;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IAdminDao;
import com.car.mvc.sevices.IAdminService;
import com.car.mvc.sevices.IClientService;
@Transactional
public class AdminServiceImp  implements IAdminService{
	
	IAdminDao dao3;

	public void setDao3(IAdminDao dao3) {
		this.dao3 = dao3;
	}
	

}
