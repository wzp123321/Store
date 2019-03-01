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
		// ҵ�񣺵�ǰ������ӵ��Ǹ��û��ĵ�1���ջ���ַ
		Integer count = getCountByUid(address.getUid());
		// if (count == 0) {
		// 	// �ǣ�����ΪĬ���ջ���ַ��address.setIsDefault(1);
		// 	address.setIsDefault(1);
		// } else {
		// 	// ������Ϊ��Ĭ���ջ���ַ��address.setIsDefault(0);
		// 	address.setIsDefault(0);
		// }
		address.setIsDefault(count == 0 ? 1: 0);
		// ִ��
		insert(currentUser, address);
		return address;
	}
	
	public Integer getCountByUid(Integer uid) {
		return addressMapper.getCountByUid(uid);
	}
	
	/**
	 * �����ջ���ַ����
	 * @param address �ջ���ַ����
	 * @throws InsertDataException
	 */
	private void insert(
		String currentUser, Address address) 
			throws InsertDataException {
		// �����־����
		Date now = new Date();
		address.setCreatedUser(currentUser);
		address.setCreatedTime(now);
		address.setModifiedUser(currentUser);
		address.setModifiedTime(now);
		// ִ��
		Integer rows = addressMapper.insert(address);
		// �ж��Ƿ����
		if (rows != 1) {
			throw new InsertDataException(
				"�����ջ���ַʱ����δ֪��������ϵϵͳ����Ա��");
		}
	}

}



