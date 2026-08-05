package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao 
{

	
	int addMenu(Menu menu);

    Menu getMenu(int menuId);

    List<Menu> getMenusByRestaurant();

    void updateMenu(Menu menu);

    void deleteMenu(int menuId);
    
    List<Menu> getMenuByRestaurantId(int restaurantid);
	
}
