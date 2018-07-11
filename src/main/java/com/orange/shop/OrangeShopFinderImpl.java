package com.orange.shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrangeShopFinderImpl implements OrangeShopFinder {

	@Override
	public String findOrangeShopWithMobileAvailable(double longitude, double latitude, String nameMobile) {

		List<Line> shopLineList = getShopsFromFileCsv();

		List<ShopBean> shopUpperThenZeroList = new ArrayList<ShopBean>();

		shopUpperThenZeroList = transformLineShopToBeanShop(shopLineList, nameMobile).stream().filter(l -> l.getNumberofSotck() > 0)
				.collect(Collectors.toList());

		return getClosestShopFromListShops(longitude, latitude, shopUpperThenZeroList);
	}



	@Override
	public String getClosestShopFromListShops(double longitude, double latitude, List<ShopBean> newLineList) {
		Map<String, Double> sortedMap = new HashMap<>();
		for (ShopBean shop : newLineList) {

			sortedMap.put(shop.getShopDescription(),
					distance(longitude, latitude, shop.getLongitude(), shop.getLatitude()));

		}
		sortedMap = sortShopWithDescendingDistance(sortedMap);

		return sortedMap.entrySet().iterator().next().getKey();
	}

	@Override
	public LinkedHashMap<String, Double> sortShopWithDescendingDistance(Map<String, Double> map) {
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	}

	private double distance(double lat1, double lon1, double lat2, double lon2) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		dist = dist * 1.609344;

		return (dist);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	private List<Line> getShopsFromFileCsv() {
		FileShopReader fileShopReader = new FileShopReader();
		List<Line> lineList = fileShopReader.setAllLine();

		return lineList;
	}

	private List<ShopBean> transformLineShopToBeanShop(List<Line> lineShopList, String nameMobile) {
		List<ShopBean> shopBeanList = new ArrayList<>();
		switch (nameMobile) {
		case "sunusng":
			shopBeanList = lineShopList.stream()
					.map(l -> new ShopBean(l.getField1(), l.getField2(), l.getField3(), nameMobile, l.getField4()))
					.collect(Collectors.toList());
		case "ipom":
			shopBeanList = lineShopList.stream()
					.map(l -> new ShopBean(l.getField1(), l.getField2(), l.getField3(), nameMobile, l.getField5()))
					.collect(Collectors.toList());
		case "weiwei":
			shopBeanList = lineShopList.stream()
					.map(l -> new ShopBean(l.getField1(), l.getField2(), l.getField3(), nameMobile, l.getField6()))
					.collect(Collectors.toList());
		}
		return shopBeanList;

	}

}
