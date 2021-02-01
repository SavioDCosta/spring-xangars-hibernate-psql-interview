package com.saviodcosta.xangars.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.saviodcosta.xangars.model.Policy;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;

@Repository
@Transactional
public class PolicyRepository {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public List<Policy> findByMobileNumber(String mobile_number) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		Criteria criteria = session.createCriteria(Policy.class);
		criteria.add(Restrictions.eq("mobileNumber", mobile_number));
		List<Policy> policies;
		try {
			policies = (List<Policy>) criteria.list();
		} catch(Exception e) {
			policies = null;
		}
		return policies;
		
	}
	
	public Policy findById(long id) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		return (Policy) session.get(Policy.class, id);
	}
	
	public Policy findByEmail(String email) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		Criteria criteria = session.createCriteria(Policy.class);
		criteria.add(Restrictions.eq("email", email));
		Policy policy;
		try {
			policy = (Policy) criteria.list().get(0);
		} catch(Exception e) {
			policy = null;
		}
		return policy;
	}

	public void update(Policy policy) {
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
		    session = sessionFactory.openSession();
		}
		
		session.saveOrUpdate(policy);
	}
}
