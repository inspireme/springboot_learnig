package jp.whisper.sbjdbctemplate.service;

import jp.whisper.sbjdbctemplate.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/03 11:51
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("jdbcTemplateFirst")
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("jdbcTemplateSecond")
    JdbcTemplate jdbcTemplateSecond;

    public void addUser(User user) {
        jdbcTemplate.update("insert into user(name, department) values (?, ?);", user.getName(), user.getDepartment());
    }

    public void deleteUser(Integer id){
        jdbcTemplate.update("delete from user where id = ?;", id );
    }

    public void updateUser(User user){
        jdbcTemplate.update("update user set name = ? , department = ? where id = ?;", user.getName(), user.getDepartment(), user.getId());
    }

    public List<User> getUserList(){
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDepartment(resultSet.getString("department"));

                return user;
            }
        });
    }

    public User  getUserById(Integer id ){
        List<User> userList = jdbcTemplateSecond.query("select * from user where id = ?;", new BeanPropertyRowMapper<>(User.class), id);

        return !(userList == null || userList.isEmpty()) ? userList.get(0) : null;
    }
}
