package com.shrader.namescore

import org.jline.utils.AttributedStringBuilder
import org.jline.utils.AttributedStyle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.shell.jline.PromptProvider
import java.util.*


@SpringBootApplication
class Application : ApplicationRunner {

    @Value("debug")
    var isDebug: String = "false"

    @Autowired
    private val applicationContext: ApplicationContext? = null

    override fun run(args: ApplicationArguments?) {
        if(this.isDebug.toBoolean()) {
            val beans = applicationContext!!.beanDefinitionNames
            Arrays.sort(beans)
            for (bean in beans) {
                println(bean)
            }
        }
    }

    @Bean
    fun myPromptProvider(): PromptProvider {
        val prompt: AttributedStringBuilder = AttributedStringBuilder()
                .style(AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN))
                .append("foo")
                .style(AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW))
                .append("@bar")
                .style(AttributedStyle.DEFAULT)
                .append("> ")

        return PromptProvider { prompt.toAttributedString() }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Application>(*args)
        }
    }
}