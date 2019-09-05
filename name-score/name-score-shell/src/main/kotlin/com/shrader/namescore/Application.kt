package com.shrader.namescore

//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.ApplicationArguments
//import org.springframework.boot.ApplicationRunner
//import org.springframework.context.ApplicationContext

import org.jline.utils.AttributedString
import org.jline.utils.AttributedStyle
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
//open class Application : ApplicationRunner {
open class Application {

    //@Autowired
    //private val applicationContext: ApplicationContext? = null

    fun main(args: Array<String>) {
        runApplication<Application>(*args)
    }

    /*
    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        val beans = applicationContext!!.beanDefinitionNames
        Arrays.sort(beans)
        for (bean in beans) {
            println(bean)
        }
    }
    */

    @Bean
    open fun myPromptProvider(): () -> AttributedString {
        return {
            AttributedString("djs:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.CYAN))
        }
    }
}
