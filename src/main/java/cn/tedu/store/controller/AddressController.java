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
		// 从Session中获取当前登录的用户的用户名
		String currentUser = session.getAttribute("username").toString();

	    // 从Session中获取当前登录的用户的id
		Integer uid = getUidFromSession(session);
	    // 将用户id封装到参数address对象
		address.setUid(uid);

		// 调用业务层对象的addnew(String currentUser, Address address)
		addressService.addnew(currentUser, address);

	    // 返回ResponseResult对象
		return new ResponseResult<Void>();
	}

}







