package com.orange.shop;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Recherche de boutiques Orange.
 * 
 * Le point d'entrée doit implémenter cette interface.
 * 
 * 
 */
public interface OrangeShopFinder {

	/**
	 * retourne la boutique la plus proche du client 
	 * @param longitude
	 * @param latitude
	 * @param nameMobile
	 * @return String : nom de la boutique 
	 * 
	 */
	String findOrangeShopWithMobileAvailable(double longitude, double latitude, String nameMobile);

	/**
	 * Trier les stockes par leur  distance par apport à la distance du client  ( trie décroissant) 
	 * @param map : clé : shop Description, valeur distance 
	 * ( calculer en fonction de longitude et latitude de boutique et de position de client )  
	 * @return LinkedHashMap
	 * 
	 */
	LinkedHashMap<String, Double> sortShopWithDescendingDistance(Map<String, Double> map);
	/**
	 * retourne la boutique la plus proche du client 
	 * @param longitude
	 * @param latitude
	 * @param newShopList list des botiques 
	 * @return String : nom de la boutique 
	 * 
	 */
	String getClosestShopFromListShops(double longitude, double latitude, List<ShopBean> newShopList);
	


	
}
