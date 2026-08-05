package com.tap.model;

public class OrderItems 
{
	private int orderItemId;
	private int orderId;
	private int menuId;
	private String itemName;
	private int quantity;
	private double totalPrice;
	private Menu menuItem;
	
	public OrderItems()
	{
		
	}
	
	public OrderItems(int orderItemId, int orderId, int menuId, String itemName, int quantity, double totalPrice,
			Menu menuItem) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.menuItem = menuItem;
	}

	public OrderItems(int orderItemId2, int orderId1, String name, int quantity2, double totalPrice2) {
		// TODO Auto-generated constructor stub
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Menu getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Menu menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId + ", itemName="
				+ itemName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", menuItem=" + menuItem + "]";
	}
	
	
	
}
