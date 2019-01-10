package com.ufs.batch.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ufs.batch.model.UfsFulfillment;

@Repository
public class UfsFulfillmentDaoImpl implements UfsFulfillmentDao {

	@Autowired
	private SessionFactory sessionFactory;
   
	public String saveUfsFulfillment(UfsFulfillment ufsFulfillment) {
	   try{
			sessionFactory.getCurrentSession().save(ufsFulfillment);
	   }catch(ConstraintViolationException e)
	   {
		 return e.getConstraintName()+" already Exists";

		}
		return null;
	}

	
	public String updateUfsFulfillment(UfsFulfillment ufsFulfillment) {
	   try{
			sessionFactory.getCurrentSession().merge(ufsFulfillment);
	   }catch(ConstraintViolationException e)
	   {
		 return e.getConstraintName()+" already Exists";

		}
		return null;
	}

	
	public String delUfsFulfillment(UfsFulfillment ufsFulfillment) {
	   try{
		    ufsFulfillment.setStatus(false);
			sessionFactory.getCurrentSession().update(ufsFulfillment);
	   }catch(Exception e)
	   {
			return "Deletion failed";

		}
		return null;
	}

	public List<UfsFulfillment> getUfsFulfillment() {
		@SuppressWarnings("unchecked")
      TypedQuery<UfsFulfillment> query = this.sessionFactory.getCurrentSession().createQuery("from UfsFulFillment p order by p.permission_updated_dt desc");
		return query.getResultList();
	}

	
	public List<UfsFulfillment> getUfsFulfillmentsByVendor(String vendor) {
		@SuppressWarnings("unchecked")
      TypedQuery<UfsFulfillment> query = this.sessionFactory.getCurrentSession().createQuery("from UfsFulFillment p  where ufsFulfillment.vendor=:vendor");
		return query.getResultList();
	}

	
	public List<UfsFulfillment> getUfsFulfillments() {
		@SuppressWarnings("unchecked")
      TypedQuery<UfsFulfillment> query = this.sessionFactory.getCurrentSession().createQuery("from UfsFulfillment r where r.status =true ");
		return query.getResultList();
	}

	
	public UfsFulfillment getUfsFulfillmentByName(String name) {
		@SuppressWarnings("unchecked")
      TypedQuery<UfsFulfillment> query = this.sessionFactory.getCurrentSession().createQuery("from UfsFulfillment ufsFulfillment where ufsFulfillment.vendor=:vendor");
		query.setParameter("ufsFulfillmentname", name);
		List<UfsFulfillment> ufsFulfillmentList = query.getResultList();
      if(ufsFulfillmentList!=null && ufsFulfillmentList.size()>0){
      return ufsFulfillmentList.get(0);}
      else{
			return null;
		}
	}

	
	public UfsFulfillment getUfsFulfillmentById(String id) {
		if (id != null) {
			@SuppressWarnings("unchecked")
			TypedQuery<UfsFulfillment> query = this.sessionFactory.getCurrentSession()
					.createQuery("from UfsFulfillment ufsFulfillment where ufsFulfillment.status =true and ufsFulfillment.ufsFulfillment_id=:ufsFulfillment_id");
			query.setParameter("ufsFulfillment_id", Long.parseLong(id));
			List<UfsFulfillment> ufsFulfillmentList = query.getResultList();
			if (ufsFulfillmentList != null && ufsFulfillmentList.size() > 0) {
				return ufsFulfillmentList.get(0);
			}
		}
		return null;

	}

}
