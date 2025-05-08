package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.TableService;
import com.demo.dao.TableDao;
import com.demo.daoImpl.TableDaoImpl;
import com.demo.entity.RestaurantTable;

public class TableServiceImpl implements TableService 
{
	TableDao tableDao=new TableDaoImpl();
	
	@Override
	public RestaurantTable createTable(RestaurantTable table)
	{
		return tableDao.createTable(table);
	}
	@Override
	public RestaurantTable getTable(String TableId) 
	{
		return tableDao.getTable(TableId);
	}
	@Override
	public List<RestaurantTable> getAllRestaurantTable() {
		return tableDao.getAllRestaurantTable();
	}
	@Override
	public RestaurantTable updateRestaurantTable(String tableId, RestaurantTable updatedRestaurantTable) {
		return tableDao.updateRestaurantTable(tableId, updatedRestaurantTable);
	}
	@Override
	public String deleteRestaurantTable(String tableId) {
		return tableDao.deleteRestaurantTable(tableId);
	}
}
