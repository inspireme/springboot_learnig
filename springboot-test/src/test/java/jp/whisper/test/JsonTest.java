package jp.whisper.test;

import jp.whisper.test.bean.Project;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

/**
 * @ClassName JsonTest
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 15:05
 * @Version 1.0
 */
@org.springframework.boot.test.autoconfigure.json.JsonTest
public class JsonTest {

    @Autowired
    JacksonTester<Project> jacksonTester;

    @Test
    public void contextLoad() {

    }

    @Test
    public void testObjectToJson() throws IOException {
        Project project = new Project();
        project.setId(1);
        project.setName("dummy");

        Assertions.assertThat(jacksonTester.write(project)).isEqualToJson("project.json");
        Assertions.assertThat(jacksonTester.write(project)).hasJsonPathValue("@.name");
        Assertions.assertThat(jacksonTester.write(project)).extractingJsonPathStringValue("@.name").isEqualTo("dummy");
    }

    @Test
    public void testJsonToObject() throws IOException {
        String json = "{\"id\": 1, \"name\": \"dummy\"}";

        Assertions.assertThat(jacksonTester.parseObject(json).getName()).isEqualTo("dummy");
    }
}
