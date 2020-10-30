package com.car.mvc;

import com.car.mvc.dao.impl.FlickrDaoImpl;

public abstract class test {

	public static void main(String[] args) {
		FlickrDaoImpl fl=new FlickrDaoImpl();
		fl.auth();

	}

}
