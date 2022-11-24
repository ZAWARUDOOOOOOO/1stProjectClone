package com.example.demo.api.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class RestApiTest {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void postmanGetTest() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
        String args = response.getBody().as(JSONObject.class).toString();

        softly.assertThat(response.getStatusCode())
                .as("Проверка статус-кода постмана")
                .isEqualTo(200);
        softly.assertThat(args)
                .as("Проверка аргумента foo2 в ответе")
                .contains("\"foo2\":\"bar2\"");
    }

    @Test
    public void reqresGetTest() {
        RestAssured.
                when().get("https://reqres.in/api/unknown/2").
                then().assertThat().statusCode(200).
                and().body("data.year", is(2001));
    }


    @Test
    public void reqresPostTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password", "pistol");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toJSONString());

        Response response = request.post("https://reqres.in/api/register");
        ResponseBody<?> responseBody = response.getBody();
        JSONObject body = responseBody.as(JSONObject.class);

        softly.assertThat(response.getStatusCode())
                .as("Проверка статус-кода регистрации")
                .isEqualTo(200);
        softly.assertThat(body.get("id"))
                .as("Проверка айди регистрации")
                .isEqualTo(4);
        softly.assertThat(body.get("token"))
                .as("Проверка токена регистрации")
                .isEqualTo("QpwL5tke4Pnpja7X4");

    }

    @Test
    public void reqresPutTest() {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "testPutRequestName");
        requestParams.put("job", "testPutRequestJob");
        request.body(requestParams.toJSONString());

        Response response = request.put("https://reqres.in/api/users/2");
        JSONObject body = response.getBody().as(JSONObject.class);

        softly.assertThat(response.getStatusCode())
                .as("Проверка статус-кода апдейта")
                .isEqualTo(200);
        softly.assertThat(body.get("updatedAt"))
                .as("Проверка времени апдейта в ответе")
                .isNotNull();
    }

    @Test
    public void reqresDeleteTest() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Response response = request.delete();

        assertThat(response.getStatusCode())
                .as("Проверка статус-кода")
                .isEqualTo(204);
    }
}
