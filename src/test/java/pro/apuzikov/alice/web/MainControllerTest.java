package pro.apuzikov.alice.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pro.apuzikov.alice.math.NumberGenerator;
import pro.apuzikov.alice.service.AttitudeService;
import pro.apuzikov.alice.service.ResponseService;
import pro.apuzikov.alice.state.StateProcessorFactory;
import pro.apuzikov.alice.util.SessionStorage;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static pro.apuzikov.alice.web.data.ContentProvider.getTestDefaultContent;

@RunWith(SpringRunner.class)
@WebAppConfiguration()
public class MainControllerTest {

    private MockMvc mockMvc;
    private String defaultContent = getTestDefaultContent();
    private static String DEFAULT_PATH = "/ma/alice-webhook";

    @Before
    public void setup() {
        ResponseService responseService = new ResponseService();
        responseService.setSessionStorage(new SessionStorage());
        responseService.setProcessorFactory(new StateProcessorFactory());
        MainController mainController = new MainController(responseService);
        this.mockMvc = standaloneSetup(mainController).build();
    }

    @Test
    public void testSayHelloWorld() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post(DEFAULT_PATH).contentType(MediaType.APPLICATION_JSON_VALUE).content(defaultContent).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json; charset=utf-8")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }
}
