package jp.whisper.test;

import jp.whisper.test.bean.Project;
import jp.whisper.test.controller.HelloController;
import jp.whisper.test.service.ProjectService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringbootControllerTests {

    private MockMvc mockMvc;

    @MockBean
    private ProjectService mockProjectService;

    @Autowired
    private HelloController helloController;

    @Test
    void contextLoads() {
    }

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/home").
                        contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("msg", "project!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("message", "hello world"));
    }

    @Test
    public void testGetForm() throws Exception {
        // when
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/form").contentType(MediaType.APPLICATION_FORM_URLENCODED).
                        param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("demoForm"))
                .andReturn();
        // ここでmodelに詰められたformの値を取得
        Project resultForm = (Project) result.getModelAndView().getModel().get("form");

        // then
        assertEquals(resultForm.getName(), "hoge");
        assertEquals(resultForm.getId(), 1);
    }

    @Test
    public void testPostFormInValid() throws Exception {
        // given
        Project form = new Project();
        form.setName("");

        // when
        mockMvc.perform(post("/form").flashAttr("project", form))
                .andExpect(model().hasErrors())
                .andExpect(model().attribute("form", form))
                .andExpect(view().name("demoForm"));
    }

    @Test
    public void testPostFormValid() throws Exception {
        // given
        Project form = new Project();
        form.setName("1111");

        // when
        mockMvc.perform(post("/form").flashAttr("form", form))
                .andExpect(model().hasNoErrors())
                .andExpect(model().attribute("form", form))
                .andExpect(view().name("ok"));

        // then
        verify(mockProjectService, times(1)).saveData(any(Project.class));
    }
}
