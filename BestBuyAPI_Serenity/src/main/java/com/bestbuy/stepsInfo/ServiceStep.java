package com.bestbuy.stepsInfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ServiceStep {
    /*
     *This product creates a record
     */
    @Step("Creating a new service with name ")

    public ValidatableResponse createServices(String name) {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(servicesPojo)
                .post(EndPoints.POST_SERVICES)
                .then();

    }

    /*
     *This  is a  GET method which on request - brings all services information
     */
    @Step("Getting all services information")
    public ValidatableResponse getAllServices() {
        return SerenityRest.rest()
                .given()
                .when()
                .get(EndPoints.GET_ALL_SERVICES)
                .then();
    }

    @Step("getting service name")
    public ValidatableResponse getServicesName() {
        return SerenityRest.rest()
                .given()
                // .pathParam("name", servicesName)
                .when()
                .get(EndPoints.GET_ALL_SERVICES)
                .then();
    }
    /*
     *This is a DELETE method which deletes a Services by ID
     */
    @Step("deleting by name")
    public ValidatableResponse getServicesId(String name) {
        return SerenityRest.rest()
                .given()
                .pathParam("name", name)
                .when()
                .delete(EndPoints.GET_ALL_SERVICES)
                .then();
    }

    @Step("Deleting service information with services ID")
    public ValidatableResponse deleteCategories(String servicesName) {
        return SerenityRest.rest()
                .given()
                .pathParam("name",servicesName)
                .when()
                .delete(EndPoints.DELETE_SERVICES)
                .then();
    }
    @Step("Update services information by name ")
    public ValidatableResponse updateServices(String name) {
        return SerenityRest.rest()
                .given()
                .pathParam("name", name)
                .when()
                .patch(EndPoints.PATCH_PRODUCT_BY_ID)
                .then();
    }

}