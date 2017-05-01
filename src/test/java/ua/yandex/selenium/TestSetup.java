/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.selenium;

import org.junit.BeforeClass;

/**
 *
 * @author andrii
 */
public abstract class TestSetup {
    
    protected static String appURL;

    @BeforeClass
    public static void setUpTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\tmp\\chromedriver.exe");

        String baseUrl = System.getProperty("baseUrl", "http://localhost:8181");
        String appName = System.getProperty("appName", "SocNet");
        //System.out.println(appName);
        appURL = baseUrl + "/" + appName + "/";
        System.out.println(appURL);
    }      

}
