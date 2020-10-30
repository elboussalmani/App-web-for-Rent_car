package com.car.mvc.dao;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface IFlickrDao {
	public String savePhoto(InputStream stream ,String file_name) throws FlickrException;
	

}
