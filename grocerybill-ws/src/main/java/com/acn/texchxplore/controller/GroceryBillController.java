package com.acn.texchxplore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.entity.Item;
import com.acn.texchxplore.entity.ShoppingClerk;
import com.acn.texchxplore.impl.DiscountedBill;
import com.acn.texchxplore.impl.RegularBill;
import com.acn.texchxplore.repository.ItemRepository;

@RestController
@RequestMapping("items/bill")
public class GroceryBillController {

	@Autowired
	private ItemRepository itemRepo;

	private ShoppingClerk shoppingClerk;

	public GroceryBillController() {
		shoppingClerk = new ShoppingClerk("TechXplore");
	}

	@GetMapping("/discounted")
	public GroceryBill getTotalDiscountedBill() {
		List<Item> items = (List<Item>)itemRepo.findAll();
		
		GroceryBill grocery = new DiscountedBill(shoppingClerk);
		grocery.setItemList(items);

		return grocery;
	}
	
	@GetMapping("/regular")
	public GroceryBill getTotalBill() {
		List<Item> items = (List<Item>)itemRepo.findAll();
		
		GroceryBill grocery = new RegularBill(shoppingClerk);
		grocery.setItemList(items);

		return grocery;
	}
}
