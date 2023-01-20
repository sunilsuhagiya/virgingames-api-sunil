package com.virgingames.testsuite;

import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AssertionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com";
        RestAssured.registerParser("text/plain", Parser.JSON);
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .basePath("/bingo")
                .get("/GetBingoLobbyFeed.do")
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        response.body("bingoLobbyInfoResource.streams[5].defaultGameFrequency",equalTo(300000));
    }
}
