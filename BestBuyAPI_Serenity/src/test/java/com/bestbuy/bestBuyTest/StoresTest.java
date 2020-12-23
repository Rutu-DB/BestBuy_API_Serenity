package com.bestbuy.bestBuyTest;

import com.bestbuy.stepsInfo.StoresStep;
import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class StoresTest extends TestBase {

    static int storeName;
    static String name = "string";
    static String type = "string";
    static String address = "string";
    static String address2 = "string";
    static String city = "string";
    static String state = "string";
    static String zip = "string";
    static float lat = 44.969658f;
    static float lng = -93.449539f;
    static String hours = "string";

    @Steps
    StoresStep storesStep;

    @Title("This will create stores ")
    @Test
    public void Test001() {
    storesStep.createStores(name,type,address,address2,city,state,zip,lat,lng,hours).statusCode(201);
    }

    @Title("This will read Store by Name ")
    @Test
    public void test002() {
        storeName = storesStep.getAllStores().extract().path("data[0].id");
        storesStep.getStoresByID(storeName).statusCode(200);
           }

    @Title("This will get all stores")
    @Test
    public void test003() {
        storesStep.getAllStores().log().all().statusCode(200);
    }


    @Title("This will delete and verify if store is deleted")
    @Test
    public void test004() {
        storeName = storesStep.getAllStores().extract().path("data[0].id");
        storesStep.deleteStores(storeName).statusCode(200);
        storesStep.getStoresByID(storeName).log().all().statusCode(404);
    }
/*
    @Title("This will update stores")
    @Test
    public void test005() {
        storeName = storesStep.getAllStores().extract().path("data[0].id");
        storesStep.getStoresByID(storeName).statusCode(200);
        storesStep.updateStores(name, type, address, address, city, state, zip, lat, lng, hours).statusCode(500);

    }*/

}
