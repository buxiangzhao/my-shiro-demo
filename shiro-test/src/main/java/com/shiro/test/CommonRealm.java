package com.shiro.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by SQ_BXZ on 2018-07-26.
 */
public class CommonRealm extends AuthorizingRealm {

	Map<String,String> userMap = new HashMap<String, String>(16);
	{
		userMap.put("bxz","bxz021213");
		super.setName("custName");
	}

	/**
	 * 授权
	 * @param principalCollection
	 * @return
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("开始授权--------------------------");
		String userName = ((String) principalCollection.getPrimaryPrincipal());
		System.out.println("授权-userName-"+userName);
		Set<String> roles = getRolesByUserName(userName);
		Set<String> permissions = getPermissionsByUserName(userName);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(roles);
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}

	/**
	 * 模拟数据库获得权限
	 *
	 * @return
	 */
	private Set<String> getPermissionsByUserName(String userName) {
		Set<String> permissionsSet = new HashSet<String>();
		permissionsSet.add("user:add");
		permissionsSet.add("user:del");
		return permissionsSet;
	}

	/**
	 * 模拟用户获得角色数据
	 * @param userName
	 * @return
	 */
	private Set<String> getRolesByUserName(String userName) {
		Set<String> rolesSet = new HashSet<String>();
		rolesSet.add("admin");
		rolesSet.add("user");
		return rolesSet;
	}

	/**
	 * 认证
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("开始认证--------------------------");
		String userName = ((String) authenticationToken.getPrincipal());

		String password = getPasswordByUserName(userName);
		if (password==null){
			return null;
		}

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,"custName");

		System.out.println("userName:"+userName);
		System.out.println("password:"+password);
		return authenticationInfo;
	}

	/**
	 * 模拟数据库查询凭证
	 *
	 * @param userName
	 * @return
	 */
	private String getPasswordByUserName(String userName) {
		return userMap.get(userName);
	}
}
