package com.car.mvc.sevices.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IVoitureDao;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IVoitureService;
@Transactional
public class VoitureServiceImpl implements IVoitureService{
   private IVoitureDao dao;
	

public void setDao(IVoitureDao dao) {
	this.dao = dao;
}

	@Override
	public Voiture save(Voiture entity) {
		
		return dao.save(entity);
	}

	@Override
	public Voiture upadate(Voiture entity) {
		
		return dao.upadate(entity);
	}

	@Override
	public List<Voiture> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Voiture getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public Voiture finOne(String paramName, String paraVale) {
	
		return dao.finOne(paramName, paraVale);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

}
