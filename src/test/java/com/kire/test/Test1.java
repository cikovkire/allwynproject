package com.gjore.test;

import io.qameta.allure.*;
import org.testng.annotations.Test;


public class Test1 {

    @Test
    public void test1(){
        System.out.println("This is my test");
        Allure.description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.");
        Allure.label("severity", "critical");
        Allure.label("owner", "John Doe");
        Allure.link("Website", "https://dev.example.com/");
        Allure.issue("AUTH-123", "https://example.com/issues/AUTH-123");
        Allure.tms("TMS-456", "https://example.com/tms/TMS-456");
    }
}
