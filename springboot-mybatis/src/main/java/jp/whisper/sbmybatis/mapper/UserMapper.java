package jp.whisper.sbmybatis.mapper;

import jp.whisper.sbmybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public User getUserById(@Param("id") Integer id);

    public User getUserById2(Integer id);
}
