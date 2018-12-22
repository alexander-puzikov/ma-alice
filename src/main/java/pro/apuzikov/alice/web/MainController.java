package pro.apuzikov.alice.web;

import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.apuzikov.alice.service.ResponseService;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/ma")
public class MainController {
    private ResponseService responseService;
    private GsonBuilder gsonBuilder = new GsonBuilder();

    @RequestMapping(value = "/alice-webhook", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public String process(
            @RequestBody LinkedHashMap data
    ) {
        return gsonBuilder.create().toJson(responseService.getResponse(data));
    }

    public void setResponseService(ResponseService responseService) {
        this.responseService = responseService;
    }
}
