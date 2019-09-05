package com.shrader.namescore.shell.controller

import com.shrader.namescore.scoring.NameScoreStrategyFactory
import com.shrader.namescore.shell.parser.NameLoader
import com.shrader.namescore.shell.parser.NameParser
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
class ShellController @Autowired
constructor(private val nameLoader: NameLoader<File>, private val nameParser: NameParser<String>, private val nameScoreStrategyFactory: NameScoreStrategyFactory) {
    private val log = LogManager.getLogger(javaClass.name)

    @ShellMethod(value = "Score a flat file containing a single line csv of names")
    @Throws(IOException::class)
    fun scoreFile(@ShellOption("-c", "--csv-file") csvFile: String,
                  @ShellOption(defaultValue = "FIRST") strategy: String,
                  @ShellOption(defaultValue = ",") delimiter: String): Int {
        var result = -1

        try {
            val file = File(csvFile)
            val buffer = this.nameLoader.load(file)
            val names = this.nameParser.parse(buffer, delimiter)
            val nameScoreStrategy = this.nameScoreStrategyFactory.create(strategy)
            result = nameScoreStrategy.score(names)
        } catch (ex: Exception) {
            log.error(ex)

            throw ex
        }

        return result
    }
}
