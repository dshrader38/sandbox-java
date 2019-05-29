package com.shrader.namescore.parse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.MatchResult;


public class ABCNameSupplierFromFile implements Supplier<List<String>> {

    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private static final String SEPARATOR = ",";
    private static final String QUOTED_NAME_PATTERN = "\"(.*)\"";
    private final String filePath;

    public ABCNameSupplierFromFile(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> get() {
        final List<String> nameList = new ArrayList<>();
        try (final Scanner scanner = new Scanner(new File(filePath), ENCODING.name())) {
            scanner.useDelimiter(SEPARATOR);

            while (scanner.hasNext()) {
                final String quotedName = scanner.next(QUOTED_NAME_PATTERN);
                final MatchResult result = scanner.match();

                nameList.add(result.group(1));
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (InputMismatchException ime) {
            System.err.println("Given file is improperly formatted.");
        }

        return nameList;
    }
}
