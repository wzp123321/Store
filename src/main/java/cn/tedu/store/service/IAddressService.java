package cn.tedu.store.service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.InsertDataException;

public interface IAddressService {
	
	/**
	 * ����µ��ջ���ַ��Ϣ
	 * @param currentUser ��ǰ�û����û���
	 * @param address �ջ���ַ��Ϣ
	 * @return �ɹ���ӵ��ջ���ַ��Ϣ������id
	 * @throws InsertDataException
	 */
	Address addnew(String currentUser, Address address) 
			throws InsertDataException;

	/**
	 * ���ݵ�ǰ�û�id����ѯ���û����ջ���ַ������
	 * @param uid ��ǰ�û�id
	 * @return ���û����ջ���ַ������
	 */
	Integer getCountByUid(Integer uid);
}




