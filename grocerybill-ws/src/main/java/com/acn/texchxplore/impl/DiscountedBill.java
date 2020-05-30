package com.acn.texchxplore.impl;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.entity.ShoppingClerk;

public class DiscountedBill extends GroceryBill {
	
	public DiscountedBill() {
	}
	
	public DiscountedBill(ShoppingClerk clerk) {
		super(clerk);
	}
	
	@Override
	public double getTotalBill() {
		return itemList.stream()
				.map(item -> 
					item.isDiscounted() ?
							item.getPrice() - (item.getPrice() * (item.getDiscountPercentage() / 100)) :
								item.getPrice()
				).reduce(0.0, Double::sum);
	}

}
