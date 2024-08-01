package io.dorum.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.apache.logging.log4j.ThreadContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseTest {

    @BeforeEach
    public void beforeEach() {
        ThreadContext.put("threadName", String.valueOf(Thread.currentThread().threadId()));
    }

    @AfterEach
    public void afterEach() {
        ThreadContext.clearAll();
    }

}