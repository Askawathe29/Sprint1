package com.demo.dao;

import java.util.List;
import com.demo.entity.RestaurantTable;

public interface TableDao {
	RestaurantTable createTable(RestaurantTable Table);
	RestaurantTable getTable(String tableId);
	List<RestaurantTable> getAllRestaurantTable();
	RestaurantTable updateRestaurantTable(String tableId,RestaurantTable updatedRestaurantTable);
	String deleteRestaurantTable(String tableId);
}
