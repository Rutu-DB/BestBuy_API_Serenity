package com.bestbuy.stepsInfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CategoriesStep {

    /*
     *This product creates a record
     */
    @Step("Creating a new category with name ")
    public ValidatableResponse createCategories(String name, String id) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(categoriesPojo)
                .post(EndPoints.POST_CATEGORIES)
                .then();

    }

    /*
     *This  is a  GET method which on request - brings all categories information
     */
    @Step("Getting all categories information")
    public ValidatableResponse getAllCategories() {
        return SerenityRest.rest()
                .given()
                .when()
                .get(EndPoints.GET_ALL_CATEGORIES)
                .then();
    }

    /*
     *This is a DELETE method which deletes a Categories by ID
     */
    @Step("Deleting a record")
    public ValidatableResponse getCategoriesByID(String categoriesID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", categoriesID)
                .when()
                .delete(EndPoints.GET_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Deleting product information with categories ID")
    public ValidatableResponse deleteCategories(String categoryID) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", categoryID)
                .when()
                .delete(EndPoints.DELETE_CATEGORIES)
                .then();

    }

    @Step("Update categories information by name ")
    public ValidatableResponse updateCategory(String id) {
        return SerenityRest.rest()
                .given()
               // .pathParam("name" , name)
                .pathParam("id", id)
                .when()
                .patch(EndPoints.PATCH_CATEGORIES_BY_ID)
                .then();
    }

}