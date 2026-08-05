package com.tap.model;

public class Restaurant 
{

	private int restaurantId;
	private String restaurantName;
	private int adminId;
	private String address;
	private String cuisineType;
	private double rating;
	private int ETA;
	private String imageUrl;
	private boolean isAvailable;
	
	public Restaurant(int restaurantId, String restaurantName, int adminId, String address, String cuisineType,
			double rating, int ETA, String imageUrl, boolean isAvailable) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.adminId = adminId;
		this.address = address;
		this.cuisineType = cuisineType;
		this.rating = rating;
		this.ETA = ETA;
		this.imageUrl = imageUrl;
		this.isAvailable = isAvailable;
	}


	public Restaurant()
	{
		
	}


	public int getRestaurantId() 
	{
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) 
	{
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName()
	{
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) 
	{
		this.restaurantName = restaurantName;
	}


	public int getAdminId() 
	{
		return adminId;
	}


	public void setAdminId(int adminId) 
	{
		this.adminId = adminId;
	}


	public String getAddress() 
	{
		return address;
	}


	public void setAddress(String address) 
	{
		this.address = address;
	}


	public String getCuisineType() 
	{
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) 
	{
		this.cuisineType = cuisineType;
	}


	public double getRating() 
	{
		return rating;
	}


	public void setRating(double rating) 
	{
		this.rating = rating;
	}


	public int getETA() 
	{
		return ETA;
	}


	public void setETA(int ETA) 
	{
		this.ETA = ETA;
	}


	public String getImageUrl() 
	{
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) 
	{
		this.imageUrl = imageUrl;
	}


	public boolean getIsAvailable() 
	{
		return isAvailable;
	}


	public void setIsAvailable(boolean isAvailable) 
	{
		this.isAvailable = isAvailable;
	}


	@Override
	public String toString() 
	{
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", adminId="
				+ adminId + ", address=" + address + ", cuisineType=" + cuisineType + ", rating=" + rating
				+ ", ETA=" + ETA + ", imageUrl=" + imageUrl + ", isAvailable="
				+ isAvailable + "]";
	}
	
	
}
