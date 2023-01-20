package com.virgingames.bingogames;

import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBingoDetails extends TestBase {

    @Test
    public void getBingoGame() {

        RestAssured.registerParser("text/plain", Parser.JSON);
        Response response = given()
                .when()
                .get("/GetBingoLobbyFeed.do");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
