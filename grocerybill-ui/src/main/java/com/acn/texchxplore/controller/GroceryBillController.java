package com.acn.texchxplore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.acn.texchxplore.model.GroceryBill;

@Controller
@RequestMapping("/techxplore")
public class GroceryBillController {
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public String getIndexPage(Model model) {
		return "grocery";
	}

	@GetMapping("/grocery")
	public ModelAndView getGrocery() {
		ModelAndView mav = new ModelAndView("grocery");
		GroceryBill discountedBill = this.restTemplate.getForObject("http://webservice/items/bill/discounted", GroceryBill.class);
		GroceryBill regularBill = this.restTemplate.getForObject("http://webservice/items/bill/regular", GroceryBill.class);
		
		mav.addObject("discountedBill", discountedBill);
		mav.addObject("regularBill", regularBill);
		
		return mav;
	}
}
