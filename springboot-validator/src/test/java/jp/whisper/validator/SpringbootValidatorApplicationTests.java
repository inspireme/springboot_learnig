package jp.whisper.validator;

import jp.whisper.validator.bean.Project;
import jp.whisper.validator.controller.HelloController;
import jp.whisper.validator.validation.CommonValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringbootValidatorApplicationTests {

    @Autowired
    private HelloController helloController;
    private MockMvc mockMvc;

//    @Autowired
//    private MessageSource messageSource;

    @Test
    void contextLoads() {
    }

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void test1() throws Exception {
        Project project = new Project();
        MvcResult result = mockMvc.perform(post("/form").flashAttr("project", project))
                .andExpect(model().hasErrors())
                .andExpect(model().attribute("project", project))
                .andExpect(view().name("demoForm"))
                .andReturn();
        Project actualProject = ((Project) result.getModelAndView().getModel().get("project"));
        List<FieldError> errors = (List<FieldError>) result.getModelAndView().getModel().get("errors");

        System.out.println(actualProject);

    }

    @Test
    public void test2() {
        Project project = new Project();

        Set<ConstraintViolation<Project>> validateResult = CommonValidator.validate(project);
        String s = validateResult.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
        System.out.println(s);

        assertEquals(4, validateResult.size());
    }

    @Test
    public void testCustomSize() throws Exception {
        Project project = Project.builder().contact("11").contactType("222").id(1)
                .name("test").uid("uid").remark("remark1111111111111").remark2("111111").build();

        MvcResult result = mockMvc.perform(post("/form").flashAttr("project", project))
                .andExpect(model().hasErrors())
                .andExpect(model().attribute("project", project))
                .andExpect(view().name("demoForm"))
                .andReturn();
        Project actualProject = ((Project) result.getModelAndView().getModel().get("project"));
        List<FieldError> errors = (List<FieldError>) result.getModelAndView().getModel().get("errors");

        errors.forEach((fieldError -> {
            System.out.println(fieldError.getObjectName() + " - " + fieldError.getDefaultMessage());
        }));

    }

    @Test
    public void testCustomSizeWithGlobalMessages() throws Exception {
        Project project = Project.builder().contact("11").contactType("222").id(1)
                .name("test").uid("uid").remark("remark1111111111111").remark2("111111").build();

        MvcResult result = mockMvc.perform(post("/form").flashAttr("project", project))
                .andExpect(model().hasErrors())
                .andExpect(model().attribute("project", project))
                .andExpect(view().name("demoForm"))
                .andReturn();
        Project actualProject = ((Project) result.getModelAndView().getModel().get("project"));
        List<FieldError> errors = (List<FieldError>) result.getModelAndView().getModel().get("errors");

        errors.forEach((fieldError -> {
            System.out.println(fieldError.getObjectName() + " - " + fieldError.getDefaultMessage());
        }));
    }

}
