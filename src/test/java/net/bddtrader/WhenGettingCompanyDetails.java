package net.bddtrader;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class WhenGettingCompanyDetails {

    @Test
    public void should_return_name_and_sector() {

        RestAssured.get("https://bddtrader.herokuapp.com/api/stock/aapl/company")
                .then()
                .body("companyName", Matchers.equalTo("Apple, Inc."))
                .body("sector", Matchers.equalTo("Electronic Technology"));
    }
}
