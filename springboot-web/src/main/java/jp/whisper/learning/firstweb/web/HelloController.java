package jp.whisper.learning.firstweb.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.whisper.learning.firstweb.domain.User;

/**
 *初めてのspring boot app
 *
 *
 * @author cndone
 *
 */

//デフォルトjsonデータを返却する
@RestController
public class HelloController {

	private Map<String, User> userDummyMap = new HashMap<String, User>() {
		{
			put("1", new User("1", "ユーザー１", "yuza1"));
			put("2", new User("2", "ユーザー２", "yuza2"));
			put("3", new User("3", "ユーザー３", "yuza3"));
		}
	};

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	//http://localhost:8080/index
	public String index() {
		return "hello XXXX, wellcome to the springboot's world";
	}

	@GetMapping(value = "/index1")
	//http://localhost:8080/index1?id=111
	public String index1(@RequestParam(name = "id") String userId) {
		User user = this.userDummyMap.get(userId);
		if(user == null) {
			return "ユーザーがみつかりません";
		}
		return String.format("hello %s, wellcome to the springboot's world", user.getName());
	}
}
