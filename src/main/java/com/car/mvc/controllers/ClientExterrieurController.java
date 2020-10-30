package com.car.mvc.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.mvc.entites.Reservation;
import com.car.mvc.entites.Voiture;
import com.car.mvc.entites.Client;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IReservationService;
import com.car.mvc.sevices.IVoitureService;



@Controller
@RequestMapping(value="/client_exterieur")
public class ClientExterrieurController {
	/*@Autowired
	 IReservationService reservationService;
	@Autowired
	 IVoitureService voitureService;
	@Autowired
	 IClientService clientService;*/
	@RequestMapping(value="/")
	  public String voiture()
	  {
		
		return "client_exterieur/home";  
	  }
	//***************************************************
	//***************************************************
		
		
		//***************************************************
			

}
