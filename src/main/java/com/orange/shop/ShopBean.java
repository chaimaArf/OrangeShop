package com.orange.shop;

public class ShopBean {
	
private double  longitude ;
private double latitude;
private String shopDescription;
private String nameMobile;
private int numberSotck;

public ShopBean() {
	super();
	
}
public ShopBean(String longitude, String latitude, String shopDescription, String nameMobile,String numberSotck) {
	super();
	this.longitude = Double.parseDouble(longitude);
	this.latitude = Double.parseDouble(latitude);
	this.shopDescription = shopDescription;
	this.nameMobile = nameMobile;
	this.numberSotck=Integer.parseInt(numberSotck);
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public String getShopDescription() {
	return shopDescription;
}
public void setShopDescription(String shopDescription) {
	this.shopDescription = shopDescription;
}
public String getNameMobile() {
	return nameMobile;
}
public void setNameMobile(String nameMobile) {
	this.nameMobile = nameMobile;
}
public int getNumberofSotck() {
	return numberSotck;
}
public void setNumberofSotck(int numberSotck) {
	this.numberSotck = numberSotck;
}


}
