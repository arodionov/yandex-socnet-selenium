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
    private static String baseUrl = "http://localhost:8084";

    @BeforeClass
    public static void setUpTest() {
        String appName = System.getProperty("appName", "SocNet");
        //System.out.println(appName);
        appURL = baseUrl + "/" + appName + "/";
        System.out.println(appURL);
    }      

}
