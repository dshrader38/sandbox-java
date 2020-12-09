package com.shrader.namescore.cli.parser

import org.springframework.stereotype.Component
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.nio.CharBuffer
import java.nio.channels.FileChannel
import java.nio.charset.Charset
import java.util.regex.Pattern
import kotlin.streams.toList


@Component
class FileLoader : NameLoader<File> {

    private var fileEncoding: String? = null
        get() {
            if (field == null) {
                this.fileEncoding = System.getProperty("file.encoding")
            }
            return field
        }

    @Throws(IOException::class)
    override fun load(dataSource: File, delimiter: String): MutableList<String> {
        var chars: CharBuffer = CharBuffer.allocate(4096)

        FileInputStream(dataSource).use { fineInputStream ->
            fineInputStream.channel.use { fileChannel ->
                val fileByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size())
                chars = Charset.forName(this.fileEncoding!!).decode(fileByteBuffer).asReadOnlyBuffer()
            }
        }

        val result = Pattern
                .compile(delimiter)
                .splitAsStream(chars)
                .peek { println("Original value: $it") }
                .map { it.replace("\"", "") }
                .peek { println("Original value: $it") }
                .map { it.trim() }
                .peek { println("Mapped value: $it") }
                .toList()

        return result.toMutableList()
    }
}
