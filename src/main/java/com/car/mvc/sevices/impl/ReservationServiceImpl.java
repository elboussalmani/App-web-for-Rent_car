package com.car.mvc.sevices.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IReservationDao;
import com.car.mvc.entites.Reservation;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IReservationService;
@Transactional
public class ReservationServiceImpl  implements IReservationService{
private IReservationDao dao2;
	

	public void setDao2(IReservationDao dao1) {
		this.dao2 = dao1;
	}

		@Override
		public Reservation save(Reservation entity) {
			
			return dao2.save(entity);
		}

		@Override
		public Reservation upadate(Reservation entity) {
			
			return dao2.upadate(entity);
		}

		@Override
		public List<Reservation> selectAll() {
			
			return dao2.selectAll();
		}

		@Override
		public Reservation getById(int id) {
			
			return dao2.getById(id);
		}

		@Override
		public Reservation finOne(String paramName, String paraVale) {
		
			return dao2.finOne(paramName, paraVale);
		}

		@Override
		public void remove(int id) {
			dao2.remove(id);
			
		}


}
