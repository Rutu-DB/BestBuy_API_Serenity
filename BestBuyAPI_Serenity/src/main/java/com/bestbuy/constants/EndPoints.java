package com.bestbuy.constants;

public class EndPoints {

    /*
    *This is the EndPoint of BestBuy Product
    */


    public static final String GET_ALL_PRODUCTS="/products";
    public static final String POST_PRODUCTS="/products";
    public static final String DELETE_PRODUCTS_BY_ID="/products/{id}";
    public static final String GET_PRODUCTS_BY_ID="/products/{id}";
    public static final String PATCH_PRODUCT_BY_ID="/products/{id}";

//These Are End Points for stores


    public static final String GET_ALL_STORES="/stores";
    public static final String POST_STORES="/stores";
    public static final String DELETE_STORES="/stores/{id}";
    public static final String GET_ALL_STORES_BY_ID="/stores/{id}";
    public static final String PATCH_STORES="/stores/{id}";

    //These Are Endpoints of Services
    public static final String GET_ALL_SERVICES = "/services";
    public static final String POST_SERVICES = "/services";
    public static final String DELETE_SERVICES = "/services/{id}";
    public static final String GET_SERVICES_BY_ID = "/services/{id}";
    public static final String PATCH_SERVICES_BY_ID = "/services/{id}";


    //These are Endpoints of Categories
    public static final String GET_ALL_CATEGORIES = "/categories";
    public static final String POST_CATEGORIES = "/categories";
    public static final String DELETE_CATEGORIES = "/categories/{id}";
    public static final String GET_CATEGORIES_BY_ID = "/categories/{id}";
    public static final String PATCH_CATEGORIES_BY_ID = "/categories/{id}";








}
