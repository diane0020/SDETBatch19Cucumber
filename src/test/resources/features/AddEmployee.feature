Feature: Adding employees using different techniques

  Background:
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee option

  @addemployee
  Scenario: Adding an employee in HRMS system
    When user enters firstname, middlename and lastname
    And user enters clicks the save button
    Then employee added successfully

  @employeeFrmFile
  Scenario: Adding employee from feature file
    When user enters "Shiela", "MS" and "Bangal"
    And user enters clicks the save button
    Then employee added successfully

  @ddt
  Scenario Outline: Adding employees using data driven testing
    When user enters "<firstname>", and "<middlename>" and "<lastname>".
    And user enters clicks the save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      | Fouad     | MS         | Oliinyk  |
      | Matt      | MS         | Aslloun  |
      | Lali      | MS         | Shahad   |