package jp.whisper.learning.properties.domain;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix="userconfig")
@PropertySource(value="classpath:setting.properties",encoding="utf-8") //カスタムされたプロパティファイルを利用する
@Data
@Component
public class UserConfig {

	private List<String> option;

	private List<String> sex;

}
