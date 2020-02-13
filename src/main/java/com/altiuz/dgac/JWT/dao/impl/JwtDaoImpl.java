package com.altiuz.dgac.JWT.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.altiuz.dgac.JWT.dao.JwtDao;
import com.altiuz.dgac.JWT.entities.JwtServicioAccion;

@Repository
public class JwtDaoImpl implements JwtDao {
	private static final Logger logger  = LogManager.getLogger(JwtDaoImpl.class);
	protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	public void crearRegistro(String jwt_id, Integer expiration_time, String issuer,String
			preferred_username, Integer issued_at, String accion, String servicio) {	
		logger.info("Entity manager");
		   EntityTransaction tx = entityManager.getTransaction();
		   tx.begin();
		   try {
			   entityManager.persist( new JwtServicioAccion(jwt_id,expiration_time,issued_at,issuer,
					   preferred_username,accion,servicio));			   
		      tx.commit();
		   } catch (Exception e) {
		      e.printStackTrace();
		      tx.rollback();
		   }
	}
	
}
