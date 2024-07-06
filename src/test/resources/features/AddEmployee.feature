Feature: Adding employees using different techniques

  Background:
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee option

  @addemployee @failed
  Scenario: Adding an employee in HRMS system
    When user enters firstname, middlename and lastname
    And user enters clicks the save button
    Then employee added successfully

  @employeeFrmFile @dbTesting
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

  @datatable
  Scenario: Adding multiple employee using data table
    When user enters firstname, middlename and lastname from data table and verify it
      | firstName | middleName | lastName   |
      | shazzam   | MS         | alakazam   |
      | mark      | MS         | weins      |
      | princess  | MS         | cinderella |

  @exceldata
Scenario: Adding multiple employee using excel file
    When user adds multiple employees from excel and validate them