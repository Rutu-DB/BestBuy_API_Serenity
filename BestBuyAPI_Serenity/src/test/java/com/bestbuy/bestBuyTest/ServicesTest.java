package com.bestbuy.bestBuyTest;

import com.bestbuy.stepsInfo.ServiceStep;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(SerenityRunner.class)
public class ServicesTest extends TestBase {

    static String name = "string"+ TestUtils.getRandomValue();
    static String serviceName;
    @Steps
    ServiceStep serviceStep;
    @Title("This will create a record")
    @Test
    public void Test001(){
        serviceStep.createServices(name).statusCode(201);
    }


    @Title("This will read services- By name ")
    @Test
    public void test002() {
        serviceName = serviceStep.getAllServices().extract().path("data[0].name");
        serviceStep.getServicesName().statusCode(200);

    }

    @Title("This will get all services")
    @Test
    public void test003() {
        serviceStep.getAllServices().log().all().statusCode(200);
    }

   @Title("This will delete and verify if services is deleted")
    @Test
    public void test004() {
        serviceName = serviceStep.getAllServices().extract().path("data[0].id");
        serviceStep.getServicesId(serviceName).statusCode(200);
        serviceStep.getServicesId(serviceName).log().all().statusCode(404);
    }

    @Title("This will update services")
    @Test
    public void test005() {
        serviceName = serviceStep.getAllServices().extract().path("data[0].id");
        serviceStep.getServicesId(serviceName).statusCode(200);
        serviceStep.updateServices(serviceName).statusCode(500);
    }
}
