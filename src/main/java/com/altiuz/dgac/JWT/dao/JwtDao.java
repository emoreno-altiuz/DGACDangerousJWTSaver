package com.altiuz.dgac.JWT.dao;

public interface JwtDao {
	
	public void crearRegistro(String jwt_id, Integer expiration_time, String issuer,String
			preferred_username, Integer issued_at, String accion, String servicio);

}
