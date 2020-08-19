package jp.whisper.securitydb.mapper;

import jp.whisper.securitydb.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();
}
