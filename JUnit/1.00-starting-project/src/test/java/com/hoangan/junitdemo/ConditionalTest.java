package com.hoangan.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {

    @Test
    @Disabled("Don't run until JIRA #123 is resolved")
    void basicTest(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowOnly(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs({OS.MAC,OS.WINDOWS})
    void testForMacAndWindow(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForOnlyJava17(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void testForOnlyJava21(){
        // execute method and perform asserts
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_21)
    void testForOnlyJreRange(){
        // execute method and perform asserts
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17)
    void testForOnlyJreRangeMin(){
        // execute method and perform asserts
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV")
    void testOnlyForDevEnvironment(){
        // execute method and perform asserts
    }

    @Test
    @EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP", matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperty(){
        // execute method and perform asserts
    }
}