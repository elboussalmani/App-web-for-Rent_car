package com.car.mvc.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.car.mvc.entites.Admin;
import com.car.mvc.entites.Client;
import com.car.mvc.entites.Reservation;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IReservationService;
import com.car.mvc.sevices.IVoitureService;
@Controller
@RequestMapping(value="/voiture")
public class VoitureController {
	@Autowired
	 IVoitureService voitureService;
	@Autowired
	 IClientService clientService;
	@Autowired
	 IReservationService reservationService;
	//***********************************************************************
	@RequestMapping(value="/")
	  public String voiture(Model model)
	  {
		List<Voiture> voitures=voitureService.selectAll();
		if(voitures==null)
		{
			voitures=new ArrayList<Voiture>();
		}
		model.addAttribute("voitures",voitures);
		
		return "voiture/voiture";  
	  }
	//***********************************************************************
		@RequestMapping(value="/VoituresResevees/")
		  public String voitureRserver(Model model)
		  {
			
			List<Voiture> voitures=new ArrayList<Voiture>();
			List<Voiture> v=voitureService.selectAll();
			if(v==null)
			{
				v=new ArrayList<Voiture>();
			}
			else
			{
				 ListIterator<Voiture> it = v.listIterator();
			      while(it.hasNext()){
			    	  Voiture v1=(Voiture)it.next();
			        if(v1.isReserver())
			        {
			        	
			        	voitures.add(v1);
			        }
			      }
			}
			model.addAttribute("voitures",voitures);
			
			return "voiture/voitureReserver";  
		  }
	//*************************************
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterVoiture(Model model)
	{
		Voiture voiture=new Voiture();
		model.addAttribute("voiture",voiture);
		
		return "voiture/ajouterVoiture";
	}
	//***********************************************************************
	@RequestMapping(value="/enregistrer")
	public String enregistrerVoiture(Model model,Voiture voiture,@RequestParam("image") MultipartFile file)
	{

		 if(voiture!=null)
		 {
			if( file!=null && !file.isEmpty())
			{
				 System.out.println("bien passe");
				String url=file.getOriginalFilename();
				voiture.setImage(url);
				
			}
			if(voiture.getId()!=0)
			{
				voitureService.upadate(voiture);	
			}else
			{
			    voitureService.save(voiture);
			}
		 }
		
		return "redirect:/voiture/";
	}
	//***********************************************************************
	@RequestMapping(value="/connection")
	public String connection(Model model,Admin admin)
	{
        String ret="";
       
       String email=admin.getEmail();
       String password=admin.getPassword();
  
		 if(admin!=null)
		 {
			 System.out.print(email);
			  
			if(email.equals("walid@gmail.com") && password.equals("walid"))
			{
				
				  System.out.print(admin.getEmail());
			ret="redirect:/voiture/";
			}
			else
				ret= "redirect:/"; 
			
		 }
		 else
		 {
			ret="redirect:/"; 
		 }
		 System.out.print(ret);
		 return ret;
	}
	
	//***********************************************************************
	@RequestMapping(value="/modifier/{id}")
	public String modigierVoiture(Model model,@PathVariable int id) 
	{ if(id!=0)
		{
		 Voiture voiture=voitureService.getById(id);
		 if(voiture!=null)
		 {
			 model.addAttribute("voiture",voiture); 
		 }	
		}
		
		return  "voiture/ajouterVoiture";
	}
	//***********************************************************************
	@RequestMapping(value="/supprimer/{id}")
	public String supprimerVoiture(Model model,@PathVariable int id) 
	{
       
		if(id!=0)
		{
		voitureService.remove(id);;
		
		}
		return "redirect:/voiture/";
	}
	//***********************************************************************
	@RequestMapping(value="/reserver/{id}")
	public String ReserverVoiture(Model model,Model model1,Model model2,@PathVariable int id) 
	{
	List<Client> clients=clientService.selectAll();
	String ret="";
		if(id!=0)
		{
			Voiture voiture=voitureService.getById(id);
			
			 if(voiture.isReserver()==false)
			 { 
				 ret= "voiture/ajouterReservation";
				List<Voiture> voitures=new ArrayList<Voiture>();
			voitures.add(voiture);
			    Reservation reservation=new Reservation();
			model.addAttribute("voitures",voitures); 
				model1.addAttribute("clients",clients); 
				model2.addAttribute("reservation",reservation); 
			 }
			 else
				 ret="redirect:/voiture/";
		
		}
	
		return  ret;
	}
	//***********************************************************************
	@RequestMapping(value="/enregisterReservation")
	public String enregistrerReservation(Model model,Reservation reservation,MultipartFile file)
	{

		 if(reservation!=null)
		 {
			 Voiture voiture =voitureService.getById(reservation.getIdVoiture());
			 voiture.setReserver(true);
			 voitureService.upadate(voiture);
			
			if(reservation.getId()!=0)
			{
				reservationService.upadate(reservation);	
			}else
			{
				
				reservationService.save(reservation);
			}
		 }
		
		return "redirect:/reservation/";
	}
	//***********************************************************************
}
