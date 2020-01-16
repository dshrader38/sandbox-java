package com.shrader.namescore.api

import com.shrader.namescore.NameScoreAdd

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotNull


@RestController
class AddApiController : AddApi {
    @GetMapping("/add")
    override fun add(@NotNull @Valid @RequestParam(value = "lhs", required = true) lhs: Long,
                     @NotNull @Valid @RequestParam(value = "rhs", required = true) rhs: Long): String =
            NameScoreAdd.add(lhs, rhs).toString()
}


/*
package com.shrader.namescore.api

import com.shrader.namescore.NameScoreAlgorithmFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.concurrent.atomic.AtomicLong

const val LARGE_FILE_NUM_BYTES = 100 * (0x1 shl (20))

data class FileResponse(val name: String, val message: String)

@RestController
class AddApiController(@Autowired private val nameScoreAlgorithmFactory: NameScoreAlgorithmFactory) {

    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) {
        Greeting(counter.incrementAndGet(), "Hello, $name")
        val nameScoreAlgorithm = this.nameScoreAlgorithmFactory.create("first")
    }

    @PostMapping("/upload")
    fun uploadFile(@RequestParam(value = "dataFile") file: MultipartFile) : FileResponse {
        val job = try {
            //val future = submitJob(jobQueue, file.bytes.inputStream())

            val isLargeFile = file.bytes.size > LARGE_FILE_NUM_BYTES
            //if (isLargeFile) {
            //    return FileResponse(file.name, "The file was too large for loading")
            //}

            //future
        } catch( ex: Exception) {
            return FileResponse(name = file.name, message = ex.message.toString())
        }

        return FileResponse(file.name, "The file was too large for loading")
    }
}
*/