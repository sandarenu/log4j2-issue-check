package org.sansoft.log4j2issuecheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * With slf4j logger also the same issue is available
     */
    private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String  testEndpoint(@RequestParam("userParam") String userParam){
        LOGGER.info("Input received: " + userParam);
        return "SUCCESS";
    }
}
