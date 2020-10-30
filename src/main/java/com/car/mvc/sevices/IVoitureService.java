package com.car.mvc.sevices;

import java.util.List;

import com.car.mvc.entites.Voiture;

public interface IVoitureService {

	public Voiture save(Voiture entity);
	public Voiture upadate(Voiture entity);
	public List<Voiture> selectAll();
	public Voiture getById(int id);
	public Voiture finOne(String paramName,String paraVale);
	public void remove(int id);
}
