package com.shrader.namescore.shell.controller
/*
import com.shrader.namescore.shell.scoring.parser.FileLoader
import com.shrader.namescore.shell.scoring.parser.NameLoader
import com.shrader.namescore.shell.scoring.parser.NameParser
import com.shrader.namescore.shell.scoring.parser.StreamParser
import com.shrader.namescore.shell.scoring.NameScoreStrategyFactory
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import org.springframework.shell.ConfigurableCommandRegistry
import org.springframework.shell.MethodTarget
import org.springframework.shell.Shell
import org.springframework.shell.standard.StandardMethodTargetRegistrar
import spock.lang.Shared
import spock.lang.Specification


@Import(TestConfig)
@SpringBootTest(classes = CLIController.class)
class ShellControllerSpec extends Specification {

    @TestConfiguration
    static class TestConfig {
        @Bean
        NameLoader getNameLoader() {
            return new FileLoader()
        }

        @Bean
        NameParser getNameParser() {
            return new StreamParser()
        }

        @Bean
        NameScoreStrategyFactory getNameScoreStrategyFactory() {
            return new NameScoreStrategyFactory()
        }
    }

    @Shared
    def registrar = new StandardMethodTargetRegistrar()

    @Shared
    def registry = new ConfigurableCommandRegistry()


    def setup() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CLIController.class);
        registrar.setApplicationContext(context);
        registrar.register(registry);
    }

    def "test"() {
        when:
            def result = 38
        then:
            result == 38
    }

    def "myfirsttest"() {
        given:
            Map<String, MethodTarget> commands = registry.listCommands()
        when:
            MethodTarget methodTarget = commands.get("score-file")
        then:
            methodTarget != null
    }
}
*/


    /*
    @Shared
    def cliController = new CLIController(new FileLoader(), new StreamParser(), new NameScoreStrategyFactory())

    @Shared
    def registrar = new StandardMethodTargetRegistrar()

    @Shared
    def registry = new ConfigurableCommandRegistry()

    def "myfirsttest"() {
            given:
                Map<String, MethodTarget> commands = registry.listCommands()
            when:
                MethodTarget methodTarget = commands.get("score-file")
            then:
                methodTarget != null
        }


            def "test"() {
                given:
                    def command = "score-file --strategy FIRST --csv-file src/main/resources/SmallFile.csv"
                when:
                    //def result = shell.evaluate({ () -> command })
                    def ds = 38
                then:
                    ds == 38
            }

            def "testes123"() {
                Object result = shell.evaluate(new Input(){
                    @Override
                    String rawText() {
                        return "add 1 3";
                    }
                });
            }

            def "test score e2e"() {
                given:
                    def file = loadFileFromResource("SmallFile.csv")
                    def strategy = "FIRST"
                    def delimiter = ","
                when:
                    def result = cliController.scorefile(file, strategy, delimiter)
                then:
                    result == 2927
            }

            def loadFileFromResource(String fileName) throws URISyntaxException {
                def resource = getClass().getClassLoader().getResource(fileName)
                return Paths.get(resource.toURI()).toFile().getAbsolutePath()
            }
            */

//    @Autowired
//    Shell shell

//    @Test
//    public void playerCanRecordEntireScoreOfGame() {
    //       assertThat(shell.evaluate(() -> "record 7")).isEqualTo("Your bowling game score is 7! Well done!");
    //   }
