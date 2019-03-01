package cn.tedu.store.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ex.InsertDataException;

@Service("addressService")
public class AddressServiceImpl 
	implements IAddressService {
	
	@Autowired
	private AddressMapper addressMapper;

	public Address addnew(
		String currentUser, Address address) 
			throws InsertDataException {
		// 业务：当前尝试添加的是该用户的第1条收货地址
		Integer count = getCountByUid(address.getUid());
		// if (count == 0) {
		// 	// 是：设置为默认收货地址：address.setIsDefault(1);
		// 	address.setIsDefault(1);
		// } else {
		// 	// 否：设置为非默认收货地址：address.setIsDefault(0);
		// 	address.setIsDefault(0);
		// }
		address.setIsDefault(count == 0 ? 1: 0);
		// 执行
		insert(currentUser, address);
		return address;
	}
	
	public Integer getCountByUid(Integer uid) {
		return addressMapper.getCountByUid(uid);
	}
	
	/**
	 * 插入收货地址数据
	 * @param address 收货地址数据
	 * @throws InsertDataException
	 */
	private void insert(
		String currentUser, Address address) 
			throws InsertDataException {
		// 添加日志数据
		Date now = new Date();
		address.setCreatedUser(currentUser);
		address.setCreatedTime(now);
		address.setModifiedUser(currentUser);
		address.setModifiedTime(now);
		// 执行
		Integer rows = addressMapper.insert(address);
		// 判断是否出错
		if (rows != 1) {
			throw new InsertDataException(
				"增加收货地址时出现未知错误！请联系系统管理员！");
		}
	}

}



