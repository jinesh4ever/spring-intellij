package com.ufs.batch.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufs.batch.model.UfsFulfillment;
import com.ufs.batch.service.UfsFulfillmentService;
 
@RestController
@RequestMapping("/ufs")
public class JobInvokerController {
 
    @Autowired
    UfsFulfillmentService ufsFulfillmentService;
 
    @RequestMapping("/invokejob")
    public String handle() throws Exception {
    	List<UfsFulfillment> list = ufsFulfillmentService.getUfsFulfillments();
    	System.out.println("List=========>>"+list.size());
        return "Batch job has been invoked";
    }
    

	@GetMapping("/getFulfillments")
	public List<UfsFulfillment> userAdd(Model model,
			@RequestParam String vendor) {
		List<UfsFulfillment> ufsFulfillments = null;
		if (vendor == null || vendor.trim().length() == 0) {
			ufsFulfillments = new ArrayList<UfsFulfillment>();
		} else {
			ufsFulfillments = ufsFulfillmentService.getUfsFulfillments();
		}

		return ufsFulfillments;
	}

}