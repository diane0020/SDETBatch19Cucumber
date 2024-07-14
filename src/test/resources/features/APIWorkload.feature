Feature: API testing

  Background:
    Given a JWT bearer token is generated

  @api @createEmployee
  Scenario: Creating an employee
    Given a request is prepared for creating an employee
    When a POST call is made to create the employee
    Then the status code will be 201 for this call
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @api @retrieveEmployee
  Scenario: Retrieving recently created employee
    Given a request is prepared for retrieving an employee
    When a GET call is made to get the employee
    Then the status code will be 200
    And the employee id we got "employee.employee_id" must match with global id
    And the received data from "employee" object matches with the data we used to create the employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | Gru           | Banana       | MS              | Male       | 1987-12-31   | permanent  | QA Engineer   |

  @jsonPayload
  Scenario: Create employee using json payload
    Given a request is prepared for creating an employee using json payload
    When a POST call is made to create the employee
    Then the status code will be 201 for this call

  @dynamic
  Scenario: Create employee using json dynamic payload
    Given a request is prepared for creating an employee using json payload dynamic "Gru" , "Banana" , "MS" , "M" ,"1987-12-31" , "permanent" , "QA Engineer"
    When a POST call is made to create the employee
    Then the status code will be 201 for this call
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable