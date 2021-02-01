package com.saviodcosta.xangars.repository;

import org.springframework.stereotype.Repository;

import com.saviodcosta.xangars.model.Policy;
import com.saviodcosta.xangars.model.TempUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;


@Repository
@Transactional
public class TempUserRepository {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public int createTempUser(TempUser tempUser) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		return (int) session.save(tempUser);
	}
	
	public TempUser findByMobileNumber(String mobile_number) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		Criteria criteria = session.createCriteria(Policy.class);
		criteria.add(Restrictions.eq("mobileNumber", mobile_number));
		TempUser tempUser;
		try {
			tempUser = (TempUser) criteria.list().get(0);
		} catch(Exception e) {
			tempUser = null;
		}
		return tempUser;
	}
	
	public TempUser findByToken(String token) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		Criteria criteria = session.createCriteria(Policy.class);
		criteria.add(Restrictions.eq("token", token));
		TempUser tempUser;
		try {
			tempUser = (TempUser) criteria.list().get(0);
		} catch(Exception e) {
			tempUser = null;
		}
		return tempUser;
	}
	
	public TempUser findByOtp(String OTP) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		Criteria criteria = session.createCriteria(Policy.class);
		criteria.add(Restrictions.eq("otp", OTP));
		TempUser tempUser;
		try {
			tempUser = (TempUser) criteria.list().get(0);
		} catch(Exception e) {
			tempUser = null;
		}
		return tempUser;
	}
}
