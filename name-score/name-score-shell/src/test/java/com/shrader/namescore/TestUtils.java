package com.shrader.namescore;

import org.springframework.shell.CommandRegistry;
import org.springframework.shell.MethodTarget;

import javax.validation.constraints.NotNull;

import java.io.File;

import static org.springframework.util.ReflectionUtils.invokeMethod;


public class TestUtils {
    static public <T> T invoke(final MethodTarget methodTarget, final Object... args) {
        return (T) invokeMethod(methodTarget.getMethod(), methodTarget.getBean(), args);
    }

    static public MethodTarget lookupCommand(@NotNull final CommandRegistry registry,
                                             @NotNull final String command) {
        return registry.listCommands().get(command);
    }

    static public String getResourceFilePath(@NotNull final Class<?> clazz,
                                             @NotNull final String fileName) {
        ClassLoader classLoader = clazz.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file.getAbsolutePath();
    }
}
