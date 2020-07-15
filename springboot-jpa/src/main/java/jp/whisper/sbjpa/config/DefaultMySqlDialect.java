package jp.whisper.sbjpa.config;

import org.hibernate.dialect.MySQL57Dialect;

/**
 * @ClassName MySqlConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/04 22:53
 * @Version 1.0
 */
public class DefaultMySqlDialect extends MySQL57Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci";
    }
}
