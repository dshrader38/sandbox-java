package com.shrader.namescore

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest(classes = com.shrader.namescore.shell.scoring.NameScoreStrategyFactory.class)
class ApplicationSpec extends Specification {

    @Autowired
    ApplicationContext context

    def "test context loads"() {
        expect:
            System.out.println(context.toString())
            context != null
            context.containsBean("nameScoreStrategyFactory")
            context.containsBean("cliController")
            context.containsBean("scopedHelloWorldService")
    }
}