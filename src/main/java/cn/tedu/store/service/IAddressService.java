package cn.tedu.store.service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.InsertDataException;

public interface IAddressService {
	
	/**
	 * 添加新的收货地址信息
	 * @param currentUser 当前用户的用户名
	 * @param address 收货地址信息
	 * @return 成功添加的收货地址信息，包括id
	 * @throws InsertDataException
	 */
	Address addnew(String currentUser, Address address) 
			throws InsertDataException;

	/**
	 * 根据当前用户id，查询该用户的收货地址的数量
	 * @param uid 当前用户id
	 * @return 该用户的收货地址的数量
	 */
	Integer getCountByUid(Integer uid);
}




