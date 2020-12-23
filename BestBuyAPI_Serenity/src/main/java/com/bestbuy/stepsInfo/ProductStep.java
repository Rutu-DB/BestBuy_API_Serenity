package com.bestbuy.stepsInfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ProductStep {
    /*
     *This product creates a record
     */
    @Step("Creating a new  product with name : {0}, type:{1} , price:{2}, shipping:{3}, upc:{4}, description:{5}, manufacturer:{6}, model:{7},url:{8} and image:{9}")

    public ValidatableResponse createProduct(String name, String type, double price, double shipping, String upc, String description, String manufacturer, String model,
                                             String url, String image) {
        ProductsPojo productPojo = new ProductsPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(productPojo)
                .post(EndPoints.POST_PRODUCTS)
                .then();

    }

    /*
     *This  is a  GET method which on request - brings all Product information
     */
    @Step("Getting all product information")
    public ValidatableResponse getAllProducts() {
        return SerenityRest.rest()
                .given()
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then();
    }

    /*
     *This is a DELETE method which deletes a product by ID
     */
    @Step("Deleting a record")
    public ValidatableResponse getProductByID(int productID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", productID)
                .when()
                .delete(EndPoints.GET_PRODUCTS_BY_ID)
                .then();
    }

    @Step("Deleting product information with product ID")
    public ValidatableResponse deleteProduct(int productID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", productID)
                .when()
                .delete(EndPoints.DELETE_PRODUCTS_BY_ID)
                .then();

    }

    @Step("Update product information by name ")
    public ValidatableResponse updateProduct(int productID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", productID)
                .when()
                .patch(EndPoints.PATCH_PRODUCT_BY_ID)
                .then();
    }

}
