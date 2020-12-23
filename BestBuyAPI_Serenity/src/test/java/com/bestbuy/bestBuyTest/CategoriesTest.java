package com.bestbuy.bestBuyTest;

import com.bestbuy.stepsInfo.CategoriesStep;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CategoriesTest extends TestBase {
    static String categoryID;

    static String name = "string" + TestUtils.getRandomValue();
    static String id = "string" + TestUtils.getRandomValue();
    @Steps
    CategoriesStep categoriesStep;

    @Title("This will create category ")
    @Test
    public void Test001() {
        categoriesStep.createCategories(name, id).statusCode(201);
    }

    @Title("This will read category- By category ID ")
    @Test
    public void test002() {

        categoryID = categoriesStep.getAllCategories().extract().path("data[0].id");
        categoriesStep.getCategoriesByID(categoryID).statusCode(200);

    }

    @Title("This will get all categories")
    @Test
    public void test003() {
        categoriesStep.getAllCategories().log().all().statusCode(200);
    }


    @Title("This will delete and verify if category is deleted")
    @Test
    public void test004() {
        categoryID = categoriesStep.getAllCategories().extract().path("data[0].id");
        categoriesStep.deleteCategories(categoryID).statusCode(200);
        categoriesStep.getCategoriesByID(categoryID).log().all().statusCode(404);
    }

    @Title("This will update category")
    @Test
    public void test005() {
        categoryID = categoriesStep.getAllCategories().extract().path("data[0].id");
        categoriesStep.getCategoriesByID(categoryID).statusCode(200);
        categoriesStep.updateCategory(id).statusCode(500);


    }

}

