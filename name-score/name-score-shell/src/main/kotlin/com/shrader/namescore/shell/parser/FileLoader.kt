package com.shrader.namescore.shell.parser

import org.springframework.stereotype.Component
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.nio.CharBuffer
import java.nio.channels.FileChannel
import java.nio.charset.Charset


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
    override fun load(dataFile: File): CharBuffer {
        var result: CharBuffer = CharBuffer.allocate(1024)

        FileInputStream(dataFile).use { fineInputStream ->
            fineInputStream.channel.use { fileChannel ->
                val fileByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size())
                result = Charset.forName(this.fileEncoding!!).decode(fileByteBuffer).asReadOnlyBuffer()
            }
        }

        return result
    }
}
