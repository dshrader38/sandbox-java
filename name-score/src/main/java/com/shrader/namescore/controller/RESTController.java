package com.shrader.namescore.controller;

import com.shrader.namescore.scoring.NameScoreStrategyFactory;
import com.shrader.namescore.scoring.strategy.NameScoreStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;


@ConditionalOnProperty(prefix = "app", name = "mode", havingValue = "rest")
@RestController
@Slf4j
public final class RESTController {

    @Autowired
    private NameScoreStrategyFactory nameScoreStrategyFactory;

    @PostConstruct
    public void init() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            log.info("host:" + inetAddress);
        } catch (UnknownHostException e) {
            log.error("Exception", e);
        }
        log.info("init");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name-score")
    public String controllerMethod(@RequestParam Map<String, String> query)
            throws NumberFormatException, NullPointerException {

        for (Map.Entry<String, String> pair : query.entrySet()) {
            log.info(pair.getKey() + ":" + pair.getValue());
        }

        String strategy = null;
        if (query.containsKey("strategy")) {
            strategy = query.get("strategy");
        }
        log.info("strategy:" + strategy);

        NameScoreStrategy nameScoreStrategy = this.nameScoreStrategyFactory.createStrategy(strategy);
        //result = nameScoreStrategy.score(names);

        return "Hello World\n";
    }
}