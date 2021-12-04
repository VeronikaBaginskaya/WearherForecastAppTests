package service;

import groovy.util.logging.Log4j;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.LinkedHashMap;

import static constants.Constants.*;

@Log4j

public class WeatherTestService {
    public RequestSpecification getWeatherURL(String city) {
        return RestAssured.given()
                .baseUri(URL)
                .basePath(BASE_PATH)
                .queryParam("access_key", ACCESS_KEY)
                .queryParam("query", city)
                .log().uri();

    }

    public LinkedHashMap getRequestValuesByCity(String city) {
        return getWeatherURL(city)
                .when().get()
                .then().extract().jsonPath().get("request");
    }


    public LinkedHashMap geLocationValuesByCity(String city) {
        return getWeatherURL(city)
                .when().get()
                .then().extract().jsonPath().get("location");
    }

    public LinkedHashMap getWeatherResponseCurrentByCity(String city) {
        return getWeatherURL(city)
                .when().get()
                .then().extract().jsonPath().get("current");
    }



}
