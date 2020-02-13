package com.altiuz.dgac.JWT.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="jwt")
public class JwtServicioAccion {
	
	public JwtServicioAccion () {
		
	}
	
	public JwtServicioAccion (String jwt_id, Integer exp_time, Integer issued_at, String creador_realm,
	 String pref_username, String accion, String servicio) {
		this.jwt_id = UUID.fromString(jwt_id);
		this.exp_time = exp_time;
		this.issued_at = issued_at;  
		this.creador_realm =creador_realm;
		this.pref_username = pref_username;
		this.accion = accion;
		this.servicio = servicio;
	}
	
	@Id
	private UUID jwt_id;
	@Column
	private Integer exp_time;
	@Column
	private Integer issued_at;
	@Column
	private String creador_realm;
	@Column
	private String pref_username;
	@Column
	private String accion;
	@Column
	private String servicio;
	
	public UUID getJwt_id() {
		return jwt_id;
	}
	public void setJwt_id(UUID jwt_id) {
		this.jwt_id = jwt_id;
	}
	public Integer getExp_time() {
		return exp_time;
	}
	public void setExp_time(Integer exp_time) {
		this.exp_time = exp_time;
	}
	public Integer getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(Integer issued_at) {
		this.issued_at = issued_at;
	}
	public String getCreador_realm() {
		return creador_realm;
	}
	public void setCreador_realm(String creador_realm) {
		this.creador_realm = creador_realm;
	}
	public String getPref_username() {
		return pref_username;
	}
	public void setPref_username(String pref_username) {
		this.pref_username = pref_username;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

}
