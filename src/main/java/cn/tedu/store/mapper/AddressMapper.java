package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;

public interface AddressMapper {

	/**
	 * 插入收货地址数据
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	
	/**
	 * 根据当前用户id，查询该用户的收货地址的数量
	 * @param uid 当前用户id
	 * @return 该用户的收货地址的数量
	 */
	Integer getCountByUid(Integer uid);
	
}










