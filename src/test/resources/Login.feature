Feature: Login scenario
  Scenario Outline: Login with Invalid username
    When User enters username "<username>" and password "<password>"
    * Click on loginButton
    Then User should get error "<error>"

    Examples:
    |username|password|error|
    |standard_user11|secret_sauce|Username and password do not match any user in this service.|

  Scenario Outline: Login with Invalid password
    When User enters username "<username>" and password "<password>"
    * Click on loginButton
    Then User should get error "<error>"

    Examples:
      |username|password|error|
      |standard_user|secret_sauce11|Username and password do not match any user in this service.|

  Scenario Outline: Login with valid username and password
    When User enters username "<username>" and password "<password>"
    * Click on loginButton
    Then verify product title "<productsTitle>"

    Examples:
      |username|password|productsTitle|
      |standard_user|secret_sauce|PRODUCTS|