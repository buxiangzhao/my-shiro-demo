package com.shiro.web.dao;

import com.shiro.web.vo.User;

/**
 * Created by SQ_BXZ on 2018-07-26.
 */
public interface UserMapper {

	User getUserByUserName(String userName);
}
