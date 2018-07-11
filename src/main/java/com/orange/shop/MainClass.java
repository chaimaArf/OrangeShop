package com.orange.shop;

import com.orange.shop.OrangeShopFinder;
public class MainClass {
	public static void main(String args[]){
		OrangeShopFinder orangeShopFinder=new OrangeShopFinderImpl();
		String shop = orangeShopFinder.findOrangeShopWithMobileAvailable(5, 87, "sunusng");
		System.out.println(shop);
	}


	

}
