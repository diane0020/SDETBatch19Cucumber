package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {
    // the intention is to learn how API's work

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
            ".eyJpYXQiOjE3MjAyNzgwMzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcyMDMyMTIzOSwidXNlcklkIjoiNjY2NiJ9.K4BbRoV5V8eoBC_ZDqyUj030nTFp_JHy5TzkJaVXapU";
    static String employee_id;

    @Test
    // create the employee
    // first prepare the request, then hit the endpoint(send), validate the response
    public void aCreateEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Gru\",\n" +
                        "  \"emp_lastname\": \"Banana\",\n" +
                        "  \"emp_middle_name\": \"MS\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1987-12-31\",\n" +
                        "  \"emp_status\": \"permanent\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");

        // hitting the endpoint, sending the request
        Response response = preparedRequest.when().post("/createEmployee.php");

        // print the response
        response.prettyPrint();

        // json - keys, it returns the value
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        // validate status code
        response.then().assertThat().statusCode(201);

        // validate header. Connection: Keep-Alive
        response.then().assertThat().header("Connection", "Keep-Alive");

        // validate body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Gru"));
        response.then().assertThat().body("Employee.emp_middle_name", equalTo("MS"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Banana"));


    }

    @Test
    // getting one employee
    public void bGetOneEmployee() {
        // prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();

        // validate the status code
        response.then().assertThat().statusCode(200);

        //get the employee ID from body
        String actualEmpId = response.jsonPath().getString("employee.employee_id");

        // validate the body
        Assert.assertEquals(employee_id, actualEmpId);
        response.then().assertThat().body("employee.emp_firstname", equalTo("Gru"));
        response.then().assertThat().body("employee.emp_middle_name", equalTo("MS"));
        response.then().assertThat().body("employee.emp_lastname", equalTo("Banana"));

    }

    @Test
    // updating the employee
    public void cUpdateEmployee() {
        // prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Charlie\",\n" +
                        "  \"emp_middle_name\": \"MS\",\n" +
                        "  \"emp_lastname\": \"Angel\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1990-12-31\",\n" +
                        "  \"emp_job_title\": \"QA Team Lead\",\n" +
                        "  \"emp_status\": \"permanent\"\n" +
                        " }");

        // sending the request
        Response response = request.when().put("/updateEmployee.php");

        // validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();


    }

    @Test
    // getting one employee
    public void dGetUpdatedEmployee() {
        // prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();

        // validate the status code
        response.then().assertThat().statusCode(200);

        //get the employee ID from body
        String actualEmpId = response.jsonPath().getString("employee.employee_id");

        // validate the body
        Assert.assertEquals(employee_id, actualEmpId);
        response.then().assertThat().body("employee.emp_firstname", equalTo("Charlie"));
        response.then().assertThat().body("employee.emp_middle_name", equalTo("MS"));
        response.then().assertThat().body("employee.emp_lastname", equalTo("Angel"));

    }

    @Test
    public void eGetAllJobTitle() {
        // prepare the request
        RequestSpecification request = given().header("Authorization", token);

        Response response = request.when().get("/jobTitle.php");
        response.prettyPrint();

        // validate the status code
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void fGetAllEmployee() {
        // prepare the request
        RequestSpecification request = given().header("Authorization", token);

        Response response = request.when().get("/getAllEmployees.php");
        response.prettyPrint();

        // validate the status code
        response.then().assertThat().statusCode(200);
    }

}
