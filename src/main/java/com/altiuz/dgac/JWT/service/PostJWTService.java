package com.altiuz.dgac.JWT.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altiuz.dgac.JWT.dao.JwtDao;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class PostJWTService {
	private static final Logger logger  = LogManager.getLogger(PostJWTService.class);
	@Autowired JwtDao jwtDao;

	public void postJWT(String jwtArg, String accion, String servicio) {
		try {
		    DecodedJWT jwt = JWT.decode(jwtArg);
		    String jti= jwt.getClaim("jti").asString();
		    Integer exp= jwt.getClaim("exp").asInt();
		    Integer iat= jwt.getClaim("iat").asInt();
		    String iss= jwt.getClaim("iss").asString();
		    String preferred_username= jwt.getClaim("preferred_username").asString();
	
		    logger.info("jti:"+jti);
		    logger.info("exp:"+exp);
		    logger.info("iat:"+iat);
		    logger.info("iss:"+iss);
		    logger.info("preferred_username:"+preferred_username);
		    logger.info("accion:"+accion);
		    logger.info("servicio:"+servicio);
		    jwtDao.crearRegistro(jti, exp, iss, preferred_username, iat, accion, servicio);




		} catch (JWTDecodeException exception){
			logger.error("Invalid Token");
		    //Invalid token
		}
	}
}
