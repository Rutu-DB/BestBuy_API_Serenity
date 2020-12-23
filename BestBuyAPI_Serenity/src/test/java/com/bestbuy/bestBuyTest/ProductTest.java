package com.bestbuy.bestBuyTest;

import com.bestbuy.stepsInfo.ProductStep;
import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProductTest extends TestBase {
    static int productId;

    static String name = "string";
    static String type = "string";
    static double price = 0.00;
    static double shipping = 0.0;
    static String description = "string";
    static String image = "string";
    static String manufacturer = "string";
    static String setUpc = "string";
    static String model = "string";
    static String setUrl = "string";
    @Steps
    ProductStep productStep;


    @Title("This will create product ")
    @Test
    public void Test001() {

        productStep.createProduct(name, type, price, shipping, description, image, manufacturer, setUpc, model, setUrl).statusCode(201);
    }

    @Title("This will read product- By product ID ")
    @Test
    public void test002() {

        productId = productStep.getAllProducts().extract().path("data[0].id");
        productStep.getProductByID(productId).statusCode(200);

    }

    @Title("This will get all products")
    @Test
    public void test003() {
        productStep.getAllProducts().log().all().statusCode(200);
    }


    @Title("This will delete and verify if product is deleted")
    @Test
    public void test004() {
        productId = productStep.getAllProducts().extract().path("data[0].id");
        productStep.deleteProduct(productId).statusCode(200);
        productStep.getProductByID(productId).log().all().statusCode(404);
    }

    @Title("This will update product")
    @Test
    public void test005() {

      /*  productId = productStep.getAllProducts().extract().path("data[0].id");
        productStep.getProductByID(productId).statusCode(200);
productStep.updateProduct(productId,name,type,price,shipping,setUpc,description,manufacturer,model,setUrl).statusCode(500);
    */
    }

}