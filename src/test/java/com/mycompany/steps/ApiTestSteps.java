package com.mycompany.steps;

import com.google.common.net.MediaType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.*;
import java.util.Map;

public class ApiTestSteps extends ScenarioSteps {

    // base URI and paths can be configured in properties for each environment
    public ApiTestSteps() {
        super();
        RestAssured.baseURI="http://dummy.restapiexample.com/";
    }

    private Response response;
    private String currentId;

    @Step("Get employee details")
    public void getEmployeeDetails(){
        response = RestAssured.given().contentType("application/json").
                when().get("/api/v1/employees");
    }

    @Step("Post/Create a new employee")
    public void  postCreateEmployee(){
        String jsonInput = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        response = RestAssured.given().contentType("application/json").
                with().body(jsonInput).
                when().post("/api/v1/create");
        System.out.println(response.prettyPrint());
    }

    @Step("Verify Status Code")
    public void verifyStatusCodeForSuccess(){
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }

    @Step("Get last employee ID")
    public String getLastEmployeeId(){
        List<Map<String,String>> employeeData = response.jsonPath().getList("data");
        ArrayList<String> ids = new ArrayList<>();
        currentId =  employeeData.get(employeeData.size()-1).get("id");
        return currentId;
    }

    @Step("Delete employee")
    public void deleteEmployee(){
        response = RestAssured.given().contentType("application/json").
                when().get("/api/v1/delete/"+currentId);
        System.out.println(response.prettyPrint());
    }

}
