package com.car.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.mvc.entites.Admin;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value="/connection")
	public String connection(Model model,Admin admin)
	{
        String ret="";
       
  System.out.print(admin.getPassword());
  System.out.print(admin.getEmail());
  
		 if(admin!=null)
		 {
			if(admin.getEmail()=="walid@gamil.com" && admin.getPassword()=="walid123")
			ret="voiture/voiture";
			else
				ret="login/login"; 
		 }
		 else
		 {
			ret="login/login"; 
		 }
		 return ret;
	}
	

}
