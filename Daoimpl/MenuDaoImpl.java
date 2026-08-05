package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.connection.DBconnection;
import com.tap.dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoImpl implements MenuDao 
{
	    
    private static final String INSER_MENU = "INSERT INTO menu(restaurantId,name,description,price,rating,imageUrl,type,isAvailable) VALUES(?,?,?,?,?,?,?,?)";
    private static final String GET_MENU_BY_ID = "SELECT * FROM menu WHERE menuId=?";
    private static final String DELETE_MENU="DELETE FROM menu WHERE menuId=?";
    private static final String GET_ALL_MENU = "SELECT * FROM menu";
    private static final String UPDATE_MENu = "UPDATE menu SET name=?,price=?,isAvailable=? WHERE menuId=?";

    
    
	    @Override
	    public int addMenu(Menu menu) 
	    
	    {
	    	int res=0;
	   
	        try (Connection connection = DBconnection.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(INSER_MENU)) {
	            statement.setInt(1, menu.getRestaurantId());
	            statement.setString(2, menu.getName());
	            statement.setString(3, menu.getDescription());
	            statement.setDouble(4, menu.getPrice());
	            statement.setDouble(5, menu.getRating());
	            statement.setString(6, menu.getImageUrl());
	            statement.setString(7, menu.getType());
	            statement.setBoolean(8, menu.getIsAvailable());
	            
	            res = statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return res;
	    }

	    @Override
	    public Menu getMenu(int menuId) 
	    {
	       
	    	Menu menu=null;

	        try (Connection connection = DBconnection.getConnection();
	        		PreparedStatement ps = connection.prepareStatement(GET_MENU_BY_ID)) {
	            ps.setInt(1, menuId);
	            ResultSet res = ps.executeQuery();
	            while (res.next())
	            {
	            	int menuId1 = res.getInt("menuId");
	    			int restaurantId1 = res.getInt("restaurantId");
	    			String restaurantName = res.getString("name");
	    			String description = res.getString("description");
	    			int price = res.getInt("price");
	    			double rating = res.getDouble("rating");
	    			String imageUrl = res.getString("imageUrl");
	    			String type = res.getString("type");
	    			boolean isAvailable = res.getBoolean("isAvailable");
	    			
	    			menu = new Menu(menuId1, restaurantId1, restaurantName, description, price, rating, imageUrl, type, isAvailable);
	    			
	                 
	       
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return menu;
	    }

	    @Override
	    public void deleteMenu(int menuId)
	    {
	        try (Connection connection = DBconnection.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(DELETE_MENU)) 
	        {
	        	statement.setInt(1, menuId);
	        	
	            int res=statement.executeUpdate();
	            System.out.println(res);
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	 
	    }
	    @Override
	    public void updateMenu(Menu menu) 
	    {
	        try (Connection connection = DBconnection.getConnection();
	        		PreparedStatement statement = connection.prepareStatement(UPDATE_MENu)) 
	        {
	        	statement.setString(1, menu.getName());
	        	statement.setDouble(2, menu.getPrice());
	        	statement.setBoolean(3, menu.getIsAvailable());
	        	statement.setInt(4, menu.getMenuId());
	            int res=statement.executeUpdate(); 
	            System.out.println(res);
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        
	     
	    }

	

	    @Override
	    public List<Menu> getMenusByRestaurant() 
	    {
	    	List<Menu> list = new ArrayList<>();
	    	

	    	try (Connection connection = DBconnection.getConnection();
	    			PreparedStatement statement = connection.prepareStatement(GET_ALL_MENU))
	    	{

	    		ResultSet res = statement.executeQuery();

	    		while (res.next())
	    		{
	    			
	    			int menuId1 = res.getInt("menuId");
	    			int restaurantId1 = res.getInt("restaurantId");
	    			String restaurantName = res.getString("restaurantName");
	    			String description = res.getString("description");
	    			int price = res.getInt("price");
	    			double rating = res.getDouble("rating");
	    			String imageUrl = res.getString("imageUrl");
	    			String type = res.getString("type");
	    			boolean isAvailable = res.getBoolean("isAvailable");
	    			
	    			Menu menu = new Menu(menuId1, restaurantId1, restaurantName, description, price, rating, imageUrl, type, isAvailable);	    			
	    			list.add(menu);
	    			
	    		}
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return list;		
	    }

	    @Override
	    public List<Menu> getMenuByRestaurantId(int restaurantId) {

	        List<Menu> menuList = new ArrayList<>();

	        String sql = "SELECT * FROM menu WHERE restaurantId = ?";

	        try (Connection con = DBconnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, restaurantId);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Menu menu = new Menu();

	                menu.setMenuId(rs.getInt("menuId"));
	                menu.setRestaurantId(rs.getInt("restaurantId"));
	                menu.setName(rs.getString("name"));
	                menu.setDescription(rs.getString("description"));
	                menu.setPrice(rs.getInt("price"));
	                menu.setRating(rs.getDouble("rating"));
	                menu.setImageUrl(rs.getString("imageUrl"));
	                menu.setType(rs.getString("type"));
	                menu.setIsAvailable(rs.getBoolean("isAvailable"));
	           

	                menuList.add(menu);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return menuList;
	    }


	
	}


