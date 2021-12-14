package org.sansoft.log4j2issuecheck;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Logger LOGGER = LogManager.getLogger(TestController.class);

    @GetMapping("/test")
    public String  testEndpoint(@RequestParam("userParam") String userParam){
        LOGGER.info("Input received: " + userParam);
        return "SUCCESS";
    }
}
