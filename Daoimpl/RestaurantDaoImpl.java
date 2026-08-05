package com.tap.Daoimpl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.connection.DBconnection;
import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {

	private static final String INSERT_QUERY = "INSERT INTO restaurant(name,adminId,address,cuisineType,rating,eta,imageUrl,isAvailable) VALUES(?,?,?,?,?,?,?,?)";
	private static final String LIST_RESTAURANT = "SELECT * FROM restaurant";
	private static final String GET_RESTAURANT_BY_ID = "SELECT * FROM restaurant WHERE restaurantId=?";
	private static final String UPDATE_RESTAURANT = "UPDATE restaurant SET name=?,address=?,rating=?,isAvailable=? WHERE restaurantId=?";
	private static final String DELETE_BY_ID = "DELETE FROM restaurant WHERE restaurantId=?";
	
	   @Override
	   public int addResaturant(Restaurant restaurant)
	   {
		   int res=0;
		   
        
		   try (Connection connection=DBconnection.getConnection(); 
				   PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) 
		   {
			    statement.setString(1, restaurant.getRestaurantName());
			    statement.setInt(2, restaurant.getAdminId());
			   	statement.setString(3, restaurant.getAddress());
			   	statement.setString(4, restaurant.getCuisineType());
			   	statement.setDouble(5, restaurant.getRating());
			   	statement.setInt(6, restaurant.getETA());
			   	statement.setString(7, restaurant.getImageUrl());
			   	statement.setBoolean(8, restaurant.getIsAvailable());
            
			   	res= statement.executeUpdate();
		   } 
		   catch (SQLException e)
		   {
			   e.printStackTrace();
		   }
		   return res;

	}
	        
	    @Override
	    public Restaurant getRestaurant(int id) 
	    {
	    	Restaurant restaurant=null;
		       
	        try (Connection connection = DBconnection.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(GET_RESTAURANT_BY_ID)) 
	        {
	            statement.setInt(1, id);
	            
	            ResultSet set = statement.executeQuery();
	            
	            while(set.next()) 
	            {
	               
	                  int restaurantId = set.getInt("restaurantId");
	                  String name = set.getString("name");
	                  int adminid = set.getInt("adminId");
	                  String address = set.getString("address");
	                  String cuisineType = set.getString("cuisineType");
	                  double rating = set.getDouble("rating");
	                  int eta = set.getInt("eta");
	                  String imageUrl = set.getString("imageUrl");
	                  boolean isavailable = set.getBoolean("isAvailable");
	                  
	                  restaurant = new Restaurant(restaurantId, name, adminid, address, cuisineType, rating, eta, imageUrl, isavailable);
	            }
	            
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        
	        return restaurant;
	    }

//	    @Override
//	    public List<Restaurant> getAllRestaurants() 
//	    {
//	        List<Restaurant> list = new ArrayList<>();
//	        
//	        try (Connection connection = DBconnection.getConnection(); 
//	        		Statement statement = connection.createStatement();
//	        		ResultSet set = statement.executeQuery(LIST_RESTAURANT)) 
//	        {
//
//	        	while (set.next()) 
//	        	{	
//	                  int restaurantId = set.getInt("restaurantId");
//	                  String name = set.getString("name");
//	                  int adminid = set.getInt("adminId");
//	                  String address = set.getString("address");
//	                  String cuisineType = set.getString("cuisineType");
//	                  double rating = set.getDouble("rating");
//	                  int eta = set.getInt("eta");
//	                  String imageUrl = set.getString("imageUrl");
//	                  boolean isavailable = set.getBoolean("isAvailable");
//	                  
//	                  Restaurant restaurant = new Restaurant(restaurantId, name, adminid, address, cuisineType, rating, eta, imageUrl, isavailable);
//	                  list.add(restaurant);
//
//	        	}
//	        } 
//	        catch (SQLException e)
//	        {
//	            e.printStackTrace();
//	        }
//	        
//	        return list;
//	    }
	    
	    
	    @Override
	    public List<Restaurant> getAllRestaurants() {

	        List<Restaurant> list = new ArrayList<>();

	        try {
	            Connection connection = DBconnection.getConnection();
	            Statement statement = connection.createStatement();

	            ResultSet rs =
	                statement.executeQuery(LIST_RESTAURANT);

	            while (rs.next()) {

	                Restaurant r = new Restaurant();

	                r.setRestaurantId(rs.getInt("restaurantId"));
	                r.setRestaurantName(rs.getString("name"));
	                r.setAdminId(rs.getInt("adminId"));
	                r.setAddress(rs.getString("address"));
	                r.setCuisineType(rs.getString("cuisineType"));
	                r.setRating(rs.getDouble("rating"));
	                r.setETA(rs.getInt("eta"));
	                r.setImageUrl(rs.getString("imageUrl"));
	                r.setIsAvailable(rs.getBoolean("isAvailable"));

	                list.add(r);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

		@Override
	    public void updateRestaurant(Restaurant restaurant) {
	
	        Connection connection = DBconnection.getConnection();
	        try (PreparedStatement statement = connection.prepareStatement(UPDATE_RESTAURANT)) {
	            statement.setString(1, restaurant.getRestaurantName());
	            statement.setString(2, restaurant.getAddress());
	            statement.setDouble(3, restaurant.getRating());
	            statement.setBoolean(4, restaurant.getIsAvailable());
	            statement.setInt(5, restaurant.getRestaurantId());
	            
	            int res = statement.executeUpdate();
	            System.out.println(res);
	        } 
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteRestaurant(int id) 
	    {
	        try (Connection connection = DBconnection.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) 
	        {
	        	statement.setInt(1, id);
	            int res = statement.executeUpdate();
	            System.out.println(res);
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	       
	    }

		
	}

