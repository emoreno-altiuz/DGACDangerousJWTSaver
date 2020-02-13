package com.altiuz.dgac.JWT.controler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altiuz.dgac.JWT.dto.RequestToken;
import com.altiuz.dgac.JWT.service.PostJWTService;


@RestController
@RequestMapping("/api/v1")
public class JWTControler {
	private static final Logger logger  = LogManager.getLogger(JWTControler.class);
	@Autowired 
	private PostJWTService postJWTServ;	
	
	
	@RequestMapping(value="/jwts",
    method=RequestMethod.POST,
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody String agregarJwt(@ModelAttribute  RequestToken formData) {
		logger .info("req:"+formData.getAccion());
		logger .info("req:"+formData.getServicio());
		logger .info("req:"+formData.getJwt());
		postJWTServ.postJWT(formData.getJwt(),formData.getServicio(),formData.getAccion());
		logger .info("");
		return null;
	}


}
