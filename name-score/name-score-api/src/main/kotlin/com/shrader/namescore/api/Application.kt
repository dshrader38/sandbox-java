package com.shrader.namescore.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import java.util.*


@SpringBootApplication
open class Application : ApplicationRunner {

    @Autowired
    private val applicationContext: ApplicationContext? = null

    @Override
    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        val beans = applicationContext!!.beanDefinitionNames
        Arrays.sort(beans)
        for (bean in beans) {
            println(bean)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Application>(*args)
        }
    }
}
