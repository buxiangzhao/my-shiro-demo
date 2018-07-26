package com.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SQ_BXZ on 2018-07-26.
 */
public class CommonRealmTest {

	@Test
	public void testAuthentication(){
		//1. 建立SecurityManager
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(new CommonRealm());
		//2. 主体请求认证
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("bxz","bxz021213");
		// 登录
		subject.login(token);
		//
		System.out.println("isAuthenticated:"+subject.isAuthenticated());
		subject.checkPermissions("user:add","user:del");
		subject.checkRole("admin");
		subject.hasRole("");
		// 登出
		subject.logout();
		System.out.println("isAuthenticated:"+subject.isAuthenticated());

	}
}
