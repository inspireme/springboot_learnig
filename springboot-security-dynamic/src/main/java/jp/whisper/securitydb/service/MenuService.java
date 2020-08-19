package jp.whisper.securitydb.service;

import jp.whisper.securitydb.bean.Menu;
import jp.whisper.securitydb.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/19 20:03
 * @Version 1.0
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }

}
