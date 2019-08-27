package com.shrader.namescore

import org.springframework.shell.CommandRegistry
import org.springframework.shell.MethodTarget

import javax.validation.constraints.NotNull

import static org.springframework.util.ReflectionUtils.invokeMethod


class SpecUtils {

    static <T> T invoke(final MethodTarget methodTarget, final Object... args) {
        return (T) invokeMethod(methodTarget.getMethod(), methodTarget.getBean(), args)
    }

    static MethodTarget lookupCommand(@NotNull final CommandRegistry registry,
                                      @NotNull final String command) {
        return registry.listCommands().get(command)
    }
}
