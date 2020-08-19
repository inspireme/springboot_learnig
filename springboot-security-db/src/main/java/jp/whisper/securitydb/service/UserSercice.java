package jp.whisper.securitydb.service;

import jp.whisper.securitydb.bean.User;
import jp.whisper.securitydb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserSercice
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/19 15:22
 * @Version 1.0
 */
@Service
public class UserSercice implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("user not found!");
        }
        user.setRoles(userMapper.getRolesByUserId(user.getId()));
        return user;
    }
}
