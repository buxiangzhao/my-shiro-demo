package com.shiro.web.controller;

import com.shiro.web.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by SQ_BXZ on 2018-07-26.
 */
@Controller
public class UserController {

	@RequestMapping(value = "/submitLoign",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String submitLogin(User user){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			if (e instanceof IncorrectCredentialsException) return "登录失败：密码错误";
			if (e instanceof UnknownAccountException) return "登录失败：账户不存在";
			e.printStackTrace();
			return "登录失败："+e.getMessage();
		}
		return "登录成功";
	}

	@RequiresRoles("admin")
	@RequestMapping(value = "/checkRole")
	@ResponseBody
	public String checkRoels(){
		return "success";
	}

	@RequiresRoles("admin1")
	@RequestMapping(value = "/checkRole1")
	@ResponseBody
	public String checkRoels1(){
		return "success";
	}
}
