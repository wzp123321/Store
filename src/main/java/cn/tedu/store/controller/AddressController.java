package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value="/handle_addnew.do",
		method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAddnew(
			Address address, HttpSession session) {
		// ��Session�л�ȡ��ǰ��¼���û����û���
		String currentUser = session.getAttribute("username").toString();

	    // ��Session�л�ȡ��ǰ��¼���û���id
		Integer uid = getUidFromSession(session);
	    // ���û�id��װ������address����
		address.setUid(uid);

		// ����ҵ�������addnew(String currentUser, Address address)
		addressService.addnew(currentUser, address);

	    // ����ResponseResult����
		return new ResponseResult<Void>();
	}

}







