package jp.whisper.sbjdbctemplate.service;

import jp.whisper.sbjdbctemplate.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        jdbcTemplate.update("insert into user(name, department) values (?, ?);", user.getName(), user.getDepartment());
    }

    public void addUser2(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int updatedCount = this.jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement("insert into user(name, department) values (?, ?);", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getDepartment());
                    return  ps;
                },
                keyHolder
        );
        user.setId(keyHolder.getKey().intValue());

        System.out.println(user);
        System.out.println(String.format("insert %s records by adduser2, id = %s", updatedCount, user.getId()));
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
        List<User> userList = jdbcTemplate.query("select * from user where id = ?;", new BeanPropertyRowMapper<>(User.class), id);

        return !(userList == null || userList.isEmpty()) ? userList.get(0) : null;
    }
}
