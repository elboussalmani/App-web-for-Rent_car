package com.car.mvc.dao.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.car.mvc.dao.IFlickrDao;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;

public class FlickrDaoImpl implements  IFlickrDao{
		String sharedSecret="6e368191ac60f224";
		Flickr flickr;
		String apiKey="6a4a85772111c8fc972292b4e3f553b6";
		UploadMetaData uploadMetaData=new UploadMetaData();
		public void connect()
		{
			Flickr flickr = new Flickr(apiKey,sharedSecret,new REST());
			Auth auth=new Auth();
			auth.setPermission(Permission.READ);
			auth.setToken("");
			auth.setTokenSecret("");
			RequestContext requestContext=RequestContext.getRequestContext();
			requestContext.setAuth(auth);
			flickr.setAuth(auth);				
		}
	public void auth()
	{
		
		
		
		flickr = new Flickr(apiKey, sharedSecret, new REST());
        
        AuthInterface authInterface = flickr.getAuthInterface();
       // OAuthService s=(OAuthService) new ServiceBuilder(apiKey);
        Token token=new Token(apiKey,sharedSecret);
      
        System.out.println("token: " + token);

        String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
        System.out.println("Follow this URL to authorise yourself on Flickr");
        System.out.println(url);
        System.out.println("Paste in the token it gives you:");
        System.out.print(">");

        String tokenKey = JOptionPane.showInputDialog(null);

        Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));
        System.out.println("Authentication success");

        Auth auth = null;
        try {
            auth = authInterface.checkToken(requestToken);
        } catch (FlickrException e) {
            e.printStackTrace();
        }

        // This token can be used until the user revokes it.
        System.out.println("Token: " + requestToken.getToken());
        System.out.println("Secret: " + requestToken.getSecret());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());
	}
	@Override
	public String savePhoto(InputStream stream, String file_name) throws FlickrException {
	        connect();
		uploadMetaData.setTitle(file_name);
		String photoId=flickr.getUploader().upload(stream, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}

}
