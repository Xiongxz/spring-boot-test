package com.xxz.shiro;

import com.xxz.model.UserInfo;
import com.xxz.serviceimpl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoShiro extends AuthorizingRealm {

    private static final Logger LOG = LoggerFactory.getLogger(UserInfoShiro.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 重写授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 重写认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOG.info("run shiro 认证 ---------------------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 通过表单接收的用户名
        String userAccount = token.getPrincipal().toString();
        String passWord = token.getCredentials().toString();
        LOG.info("account : {} and password : {} ", userAccount, passWord);
        if (StringUtils.isBlank(userAccount)) {
            throw new UnknownAccountException();
        }
        UserInfo userInfo = this.userServiceImpl.getUserInfoByUserAndPassword(userAccount, passWord);
        // 如果查询库中后，用户信息对时，根据需要相应的抛出 UnknownAccountException IncorrectCredentialsException
        if (org.springframework.util.StringUtils.isEmpty(userInfo)) {
            throw new UnknownAccountException("用户不存在");
        }
        if (!userInfo.getPassWord().equals(String.valueOf(token.getPassword()))) {
            throw new IncorrectCredentialsException("用户密码错误");
        }

        List<Object> principals = CollectionUtils.asList(userInfo, userAccount);
        PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, getName());

        return new SimpleAuthenticationInfo(principalCollection, token.getPassword());
    }

}
