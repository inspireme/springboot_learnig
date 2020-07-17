package jp.whisper.sbproperties.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Compiler
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 11:00
 * @Version 1.0
 */
@Component
@PropertySource("classpath:app.properties")
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String error;
    private List<Menu> menus = new ArrayList<>();
    private Compiler compiler = new Compiler();

    private static class Menu {
        private String name;
        private String path;
        private String title;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "name='" + name + '\'' +
                    ", path='" + path + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
    private static class Compiler {
        private String timeout;
        private String outputFolder;

        public String getTimeout() {
            return timeout;
        }

        public void setTimeout(String timeout) {
            this.timeout = timeout;
        }

        @Override
        public String toString() {
            return "Compiler{" +
                    "timeout='" + timeout + '\'' +
                    ", outputFolder='" + outputFolder + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "error='" + error + '\'' +
                ", menus=" + menus +
                ", compiler=" + compiler +
                '}';
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Compiler getCompiler() {
        return compiler;
    }

    public void setCompiler(Compiler compiler) {
        this.compiler = compiler;
    }
}
