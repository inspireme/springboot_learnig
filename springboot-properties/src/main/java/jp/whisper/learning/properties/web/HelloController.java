package jp.whisper.learning.properties.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.whisper.learning.properties.domain.UserConfig;

@RestController
public class HelloController {

	@Autowired
	private UserConfig userConfig;

	@Value("${app-name}")
	private String appName;

	@GetMapping(value = "index")
	public String index() {
		return String.format("wellcome to %s ", appName);
	}

	@GetMapping(value = "index1")
	public UserConfig index1() {
		return this.userConfig;
	}


}
