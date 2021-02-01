package com.saviodcosta.xangars.repository;

import java.util.List;

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
import com.saviodcosta.xangars.model.WhatsappOptin;


@Repository
@Transactional
public class WhatsappOptinRepository {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public List<WhatsappOptin> getOptinForMobileNumber(String mobile_number) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		Criteria criteria = session.createCriteria(Policy.class);
		criteria.add(Restrictions.eq("mobileNumber", mobile_number));
		
		List<WhatsappOptin> whatsappOptins;
		try {
			whatsappOptins = (List<WhatsappOptin>) criteria.list(); 
		} catch (Exception e) {
			whatsappOptins = null;
		}
		return whatsappOptins;
	}
	
	public int createWhatsappOptin(WhatsappOptin whatsappOptin) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		return (int) session.save(whatsappOptin);
	}
}
