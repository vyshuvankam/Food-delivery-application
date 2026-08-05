package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDao 
{
	int addResaturant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurants();
}
	
