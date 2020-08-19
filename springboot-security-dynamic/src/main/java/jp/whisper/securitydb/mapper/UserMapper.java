package jp.whisper.securitydb.mapper;

import jp.whisper.securitydb.bean.Role;
import jp.whisper.securitydb.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByUsername(String username);

    List<Role> getRolesByUserId(Integer id);
}
