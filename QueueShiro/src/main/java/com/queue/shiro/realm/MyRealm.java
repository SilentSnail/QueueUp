package com.queue.shiro.realm;

import com.queue.entity.RoleUser;
import com.queue.service.UserService;
import com.queue.shiro.bean.SecurityUserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liusong on 2018/4/24.
 */
public class MyRealm extends AuthorizingRealm {

    private Logger log = LogManager.getLogger(MyRealm.class);

    @Autowired
    private UserService userService;

    public MyRealm(CacheManager cacheManager){
        super(cacheManager);
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("Shiro开始角色授权");
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("Shiro开始登录认证");
        SecurityUserEntity entity = (SecurityUserEntity) token;
        RoleUser user = userService.getUserByEntity(new RoleUser(entity.getUsername()));
        if(user == null){
            throw new UnknownAccountException("用户或或密码不正确");
        }
        if(user.getIsDelete() == 1){
            throw new LockedAccountException("用户已被锁定，请联系管理员。");
        }
        entity.setUser(user);
        return new SimpleAuthenticationInfo(entity, user.getPassword(), getName());
    }

    //logout 清除缓存
    @Override
    public void onLogout(PrincipalCollection principal){
        super.clearCachedAuthorizationInfo(principal);
        SecurityUserEntity user = (SecurityUserEntity) principal.getPrimaryPrincipal();
        removeUserCache(user);
    }

    public void removeUserCache(SecurityUserEntity user){
        removeUserCache(user.getLoginName());
    }

    public void removeUserCache(String loginName){
        SimplePrincipalCollection authen = new SimplePrincipalCollection();
        authen.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(authen);
    }
}
