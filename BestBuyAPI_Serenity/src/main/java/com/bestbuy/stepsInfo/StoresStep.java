package com.bestbuy.stepsInfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductsPojo;
import com.bestbuy.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoresStep {
    /*
     *This product creates a record
     */
    @Step("Creating a new Stores with name : {0}, type:{1} , address:{2}, address2:{3}, city:{4}, state:{5}, zip:{6}, lat:{7},lng:{8} and hours:{9}")
   public ValidatableResponse createStores(String name, String type, String address, String address2, String city, String state, String zip, float lat,
                                             float lng, String hours) {
        StoresPojo storesPojo = new StoresPojo();
       storesPojo.setName(name);
       storesPojo.setType(type);
       storesPojo.setAddress(address);
       storesPojo.setAddress2(address2);
       storesPojo.setCity(city);
       storesPojo.setState(state);
       storesPojo.setZip(zip);
       storesPojo.setLat(lat);
       storesPojo.setLng(lng);
       storesPojo.setHours(hours);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(storesPojo)
                .post(EndPoints.POST_STORES)
                .then();

    }

    /*
     *This  is a  GET method which on request - brings all Stores information
     */
    @Step("Getting all stores information")
    public ValidatableResponse getAllStores() {
        return SerenityRest.rest()
                .given()
                .when()
                .get(EndPoints.GET_ALL_STORES)
                .then();
    }

    /*
     *This is a DELETE method which deletes a store by ID
     */
    @Step("Deleting a record")
    public ValidatableResponse getStoresByID(int storesID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", storesID)
                .when()
                .delete(EndPoints.GET_ALL_STORES_BY_ID)
                .then();
    }

    @Step("Deleting product information with stores ID")
    public ValidatableResponse deleteStores(int storesID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", storesID)
                .when()
                .delete(EndPoints.DELETE_STORES)
                .then();

    }

    @Step("Update stores information by name ")
    public ValidatableResponse updateStores(int storeID) {
        ProductsPojo productsPojo = new ProductsPojo();
        return SerenityRest.rest()
                .given()
                .pathParam("id", storeID)
                //.pathParam("productName", name)
                .when()
                .patch(EndPoints.PATCH_STORES)
                .then();
    }


}
