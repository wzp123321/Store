package cn.tedu.store.mapper;

import cn.tedu.store.entity.Address;

public interface AddressMapper {

	/**
	 * �����ջ���ַ����
	 * @param address �ջ���ַ����
	 * @return ��Ӱ�������
	 */
	Integer insert(Address address);
	
	/**
	 * ���ݵ�ǰ�û�id����ѯ���û����ջ���ַ������
	 * @param uid ��ǰ�û�id
	 * @return ���û����ջ���ַ������
	 */
	Integer getCountByUid(Integer uid);
	
}










