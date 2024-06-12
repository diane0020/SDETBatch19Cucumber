Feature: Login related scenarios

  @smoke @sprint1 @login @loginFeatureScenarios @failed
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user successfully logged in

    @loginWithFeature @loginFeatureScenarios
    Scenario: Valid admin login using feature file
      When user enter "admin" and "Hum@nhrm123"
      And user clicks on login button
      Then user successfully logged in

  @datadriven @smoke @regression
  Scenario Outline: login multiple times
    When user enters "<username>" values and "<password>" values
    And user clicks on login button
    Then user successfully logged in
    Examples:
      | username | password |
      |admin     |Hum@nhrm123|
      |admin     |Hum@nhrm123|
      |admin     |Hum@nhrm123|