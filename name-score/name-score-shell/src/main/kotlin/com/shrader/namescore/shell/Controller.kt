package com.shrader.namescore.shell

import com.shrader.namescore.NameScoreAlgorithmFactory
import com.shrader.namescore.shell.parser.NameLoader
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellCommandGroup
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption
import java.io.File
import java.io.IOException


@ShellComponent
@ShellCommandGroup("Name Score Commands")
class Controller
@Autowired constructor(private val nameLoader: NameLoader<File>,
                       private val nameScoreAlgorithmFactory: NameScoreAlgorithmFactory) {
    private val log = LogManager.getLogger(javaClass.name)

    @ShellMethod(value = "Score a flat file containing a single line csv of names")
    @Throws(IOException::class)
    fun scoreFile(@ShellOption("-c", "--csv-file") csvFile: String,
                  @ShellOption(defaultValue = "FIRST") strategy: String,
                  @ShellOption(defaultValue = ",") delimiter: String): Long {
        var result: Long

        try {
            val file = File(csvFile)
            val names = this.nameLoader.load(file, delimiter)
            val nameScoreAlgorithm = this.nameScoreAlgorithmFactory.create(strategy)
            result = nameScoreAlgorithm.score(names)
        } catch (ex: Exception) {
            log.error(ex)

            result = 0
            //throw ex
        }

        return result
    }
}
