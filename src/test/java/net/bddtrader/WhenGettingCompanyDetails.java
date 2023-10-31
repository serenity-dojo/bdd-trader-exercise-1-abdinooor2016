package net.bddtrader;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class WhenGettingCompanyDetails {

    @Before
    public void prepare_rest_config() {
        RestAssured.baseURI = "https://bddtrader.herokuapp.com/api";
    }

    @Test
    public void should_return_news_for_a_requested_company() {
        given().queryParam("symbols", "fb")
                .when()
                .get("/news")
                .then()
                .body("related", everyItem(containsString("FB")))
                .body("related", everyItem(containsString("AAPL")));

    }


    @Test
    public void should_return_name_and_sector() {

        given()
                .pathParam("symbol", "aapl")
                .when()
                .get("/stock/{symbol}/company")
                .then()
                .body("companyName", Matchers.equalTo("Apple, Inc."))
                .body("sector", Matchers.equalTo("Electronic Technology"));


    }



}
