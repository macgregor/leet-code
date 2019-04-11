package com.github.macgregor.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;

@Slf4j
public class SolutionProfilerExtension implements ParameterResolver, BeforeEachCallback, AfterEachCallback {

    private Profiler profiler;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        log.debug("Starting profiler");
        profiler = new Profiler();
        profiler.begin();
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        profiler.end();
        log.info(profiler.toString());
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType()
                .equals(Profiler.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return profiler;
    }
}
