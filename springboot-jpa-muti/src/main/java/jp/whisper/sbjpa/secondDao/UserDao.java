package jp.whisper.sbjpa.secondDao;

import jp.whisper.sbjpa.bean.Project;
import jp.whisper.sbjpa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/04 22:43
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User, Integer> {
    public User findUserById(Integer id);
}
