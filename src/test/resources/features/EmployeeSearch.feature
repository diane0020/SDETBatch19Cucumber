Feature: Employee search related scenario

  Background:
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user successfully logged in
    When user clicks on PIM option
    And user clicks on employee list option

    @smoke @empSearchById
  Scenario: Search employee by id
    When user enters valid employee id
    And user clicks on search button
    Then user see the employee information

      @regression
    Scenario: Search employee by name
      When user enters valid employee name
      And user clicks on search button
      Then user see the employee information