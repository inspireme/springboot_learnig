package jp.whisper.sbservlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName MyRequestListener
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/29 22:47
 * @Version 1.0
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("requestInitialized");
    }
}
