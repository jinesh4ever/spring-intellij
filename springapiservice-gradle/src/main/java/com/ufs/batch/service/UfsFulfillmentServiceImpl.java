package com.ufs.batch.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufs.batch.dao.UfsFulfillmentDao;
import com.ufs.batch.model.UfsFulfillment;

@Service
public class UfsFulfillmentServiceImpl implements UfsFulfillmentService {
	private static final Logger logger = Logger.getLogger(UfsFulfillmentService.class);
   @Resource
   private UfsFulfillmentDao ufsFulFillmentDao;

 
  @Transactional
  public String saveUfsFulfillment(UfsFulfillment ufsFulFillment) {
     return ufsFulFillmentDao.saveUfsFulfillment(ufsFulFillment);
  }

  @Transactional
  public String updateUfsFulfillment(UfsFulfillment ufsFulfillment) {
	  try{
		  return ufsFulFillmentDao.updateUfsFulfillment(ufsFulfillment);  
	  }catch(Exception e){
		  logger.error(e.getMessage());
	  }
	return null;
  }

  @Transactional
  public String delUfsFulfillment(UfsFulfillment ufsFulFillment) {
	  return ufsFulFillmentDao.delUfsFulfillment(ufsFulFillment);
  }

  @Transactional(readOnly=true)
  public List<UfsFulfillment> getUfsFulfillmentsByVendor(String ufsFulFillmentname) {
     return ufsFulFillmentDao.getUfsFulfillmentsByVendor(ufsFulFillmentname);
  }

   
   @Transactional(readOnly=true)
   public UfsFulfillment getUfsFulfillmentByName(String name) {
      return ufsFulFillmentDao.getUfsFulfillmentByName(name);
   }

   @Transactional(readOnly = false, value="transactionManager") 
   public List<UfsFulfillment> getUfsFulfillments() {
      return ufsFulFillmentDao.getUfsFulfillments();
   }
   
   @Transactional(readOnly=true)
   public UfsFulfillment getUfsFulfillmentById(String id) {
      return ufsFulFillmentDao.getUfsFulfillmentById(id);
   }
   
}
