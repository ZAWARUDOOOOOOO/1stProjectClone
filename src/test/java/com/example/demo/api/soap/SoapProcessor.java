package com.example.demo.api.soap;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class SoapProcessor {

    private String xmlToString(String filePath) {
        StringBuilder str = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(fileInputStream, StandardCharsets.UTF_8
                     ))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                str.append(line);
                str.append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str.toString();
    }

    public XmlPath sendXml(String filePath, String url) {
        String body = xmlToString(filePath);

        Response response = RestAssured.given()
                .header("Content-Type", "text/xml")
                .body(body)
                .post(url);

        return new XmlPath(response.asString()).using(xmlPathConfig().namespaceAware(true));
    }
}
