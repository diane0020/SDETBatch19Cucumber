Feature: Login related scenarios

  @smoke @sprint1 @login
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user successfully logged in

    @loginWithFeature
    Scenario: Valid admin login using feature file
      When user enter "admin" and "Hum@nhrm123"
      And user clicks on login button
      Then user successfully logged in