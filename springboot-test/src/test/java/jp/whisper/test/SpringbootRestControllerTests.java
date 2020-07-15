package jp.whisper.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jp.whisper.test.bean.Project;
import jp.whisper.test.controller.HelloRestController;
import jp.whisper.test.service.ProjectService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringbootRestControllerTests {

    private MockMvc mockMvc;

    @MockBean
    private ProjectService mockProjectService;

    @Autowired
    private HelloRestController helloRestController;

    @Test
    void contextLoads() {
    }

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloRestController).build();
    }

    @Test
    public void testGetProject() throws Exception {

        Project prj = new Project();
        prj.setId(2);
        prj.setName("test name");
        Mockito.when(mockProjectService.get(2)).thenReturn(prj);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/project/get/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();
        Project project = om.readValue(result.getResponse().getContentAsString(), Project.class);

        assertEquals(project.getId(), 2);
        assertEquals(project.getName(), "test name");
    }

    @Test
    public void testUpdateProject() throws Exception {
        Project project = new Project();
        project.setName("dummy1");
        project.setId(3);

        Mockito.when(mockProjectService.updateData(any(project.getClass()))).thenReturn(project);

        String reqJson = new ObjectMapper().writeValueAsString(project);
        MvcResult result = mockMvc.perform(
                post("/project/update").contentType(MediaType.APPLICATION_JSON).content(reqJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

        Mockito.verify(mockProjectService, times(1)).updateData(any(Project.class));

    }

}
