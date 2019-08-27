package com.shrader.namescore.shell.parser;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;


@Component
public class FileLoader implements NameLoader<File> {
    private String fileEncoding;

    @Override
    public CharBuffer load(File dataFile) throws IOException {
        CharBuffer result;

        try (final FileInputStream fineInputStream = new FileInputStream(dataFile);
             final FileChannel fileChannel = fineInputStream.getChannel()) {
            MappedByteBuffer fileByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            result = Charset.forName(this.getFileEncoding()).decode(fileByteBuffer).asReadOnlyBuffer();
        }

        return result;
    }

    /**
     * Returns this instances configured fileEncoding. Also lazy loads the default system file encoding if none was configured
     *
     */
    private String getFileEncoding() {
        if (this.fileEncoding == null) {
            this.setFileEncoding(System.getProperty("file.encoding"));
        }
        return this.fileEncoding;
    }

    /**
     * Sets file encoding to the supplied fileEncoding
     *
     */
    private void setFileEncoding(String fileEncoding) {
        this.fileEncoding = fileEncoding;
    }
}
