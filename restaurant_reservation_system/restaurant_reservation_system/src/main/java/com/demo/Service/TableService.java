package com.demo.Service;

import java.util.List;

import com.demo.entity.RestaurantTable;

public interface TableService 
{
	RestaurantTable createTable(RestaurantTable table);	
	RestaurantTable getTable(String tableId);
	List<RestaurantTable> getAllRestaurantTable();
	RestaurantTable updateRestaurantTable(String customerId,RestaurantTable updatedRestaurantTable);
	String deleteRestaurantTable(String tableId);
}
