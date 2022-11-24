package com.example.demo.api.soap;

import io.restassured.path.xml.XmlPath;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

//Ссылка на различные SOAP API
//https://www.postman.com/cs-demo/workspace/postman-customer-org-s-public-workspace/request/8854915-0238915b-fa9c-409f-bf9f-b9d98f588c16
public class UsersSoapApiTest {

    private final SoapProcessor soapProcessor = new SoapProcessor();

    @Test
    public void numberToWordsTest() {
        XmlPath xmlResponse = soapProcessor.sendXml("src/test/resources/soapRequests/numberToWords.xml", "https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        assertThat(xmlResponse.getString("AddResult").trim())
                .as("Проверка результата сложения")
                .isEqualTo("fifteen");
    }

    @Test
    public void addTest() {
        XmlPath xmlResponse = soapProcessor.sendXml("src/test/resources/soapRequests/add.xml", "http://www.dneonline.com/calculator.asmx");
        assertThat(xmlResponse.getInt("AddResult"))
                .as("Проверка результата сложения")
                .isEqualTo(3);
    }

    @Test
    public void divideTest() {
        XmlPath xmlResponse = soapProcessor.sendXml("src/test/resources/soapRequests/divide.xml", "http://www.dneonline.com/calculator.asmx");
        assertThat(xmlResponse.getInt("DivideResult"))
                .as("Проверка результата деления")
                .isEqualTo(2);
    }

    @Test
    public void subtractTest() {
        XmlPath xmlResponse = soapProcessor.sendXml("src/test/resources/soapRequests/subtract.xml", "http://www.dneonline.com/calculator.asmx");
        assertThat(xmlResponse.getInt("SubtractResult"))
                .as("Проверка результата вычитания")
                .isEqualTo(5);
    }

    @Test
    public void multiplyTest() {
        XmlPath xmlResponse = soapProcessor.sendXml("src/test/resources/soapRequests/multiply.xml", "http://www.dneonline.com/calculator.asmx");
        assertThat(xmlResponse.getInt("MultiplyResult"))
                .as("Проверка результата умножения")
                .isEqualTo(50);
    }
}
