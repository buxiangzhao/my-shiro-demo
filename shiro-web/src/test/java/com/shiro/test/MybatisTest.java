package com.shiro.test;

import com.shiro.web.dao.UserMapper;
import com.shiro.web.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SQ_BXZ on 2018-07-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
public class MybatisTest {

	@Autowired
	UserMapper userMapper;
	@Test
	public void testGetUserByUserName(){
		User user = userMapper.getUserByUserName("bxz");
		System.out.println(user.toString());

	}
}
