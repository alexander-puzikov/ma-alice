package pro.apuzikov.alice.web;

import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.apuzikov.alice.service.ResponseService;
import pro.apuzikov.alice.util.exception.ResponseException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

@RestController
@RequestMapping("/ma")
public class MainController {
    private ResponseService responseService;
    private GsonBuilder gsonBuilder = new GsonBuilder();

    @RequestMapping(value = "/alice-webhook", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public String process() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "OK");
        Objects.requireNonNull(responseService);
        return gsonBuilder.create().toJson(response);
    }

    @RequestMapping(value = "/alice-webhook", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public String process(
            @RequestBody LinkedHashMap data
    ) throws ResponseException {
        return gsonBuilder.create().toJson(responseService.getResponse(data));
    }

    public MainController(ResponseService responseService) {
        this.responseService = responseService;
    }
}
