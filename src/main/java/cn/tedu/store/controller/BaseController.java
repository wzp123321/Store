package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateDataException;
import cn.tedu.store.service.ex.UploadAvatarException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameConflictException;

public abstract class BaseController {

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public ResponseResult<Void> handleException(Exception e) {
		// 判断异常的类型
		if (e instanceof UsernameConflictException) {
			// 用户名冲突，例如注册时，用户名已经被占用
			return new ResponseResult<Void>(401, e);
		} else if (e instanceof UserNotFoundException) {
			// 尝试访问的用户数据不存在
			return new ResponseResult<Void>(402, e);
		} else if (e instanceof PasswordNotMatchException) {
			// 验证密码时，密码不匹配
			return new ResponseResult<Void>(403, e);
		} else if (e instanceof UploadAvatarException) {
			// 上传头像时异常
			return new ResponseResult<Void>(408, e);
		} else if (e instanceof InsertDataException) {
			// 增加数据时异常，原因未知
			return new ResponseResult<Void>(501, e);
		}  else if (e instanceof UpdateDataException) {
			// 修改数据时异常，原因未知
			return new ResponseResult<Void>(502, e);
		} else {
			// 其它可能遗漏没有处理的异常
			return new ResponseResult<Void>(600, e);
		}
	}
	
	/**
	 * 从Session中获取当前登录的用户的id
	 * @param session
	 * @return 当前登录的用户的id
	 */
	protected final Integer getUidFromSession(
			HttpSession session) {
		return Integer.valueOf(
			session.getAttribute("uid").toString());
	}
	
}









