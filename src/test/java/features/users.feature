#Author: Raj Singh
#Feature: Users - Endpoint to test is https://jsonplaceholder.typicode.com/users

Feature: Users
  As a social media user
  I want to view users
  So that I can verify that the users endpoint is working correctly

  @Users_001
  Scenario:
    Given I have a "id" with the value "1"
    When I make a GET call to the "/users" endpoint
    Then a 200 response code is received
    And the BS is harness real-time e-markets
    And the Catchphrase is Multi-layered client-server neural-net
    And the City is Gwenborough
    And the Company Name is Romaguera-Crona
    And the Email is Sincere@april.biz
    And the Geo Lat is -37.3159
    And the Geo Lng is 81.1496
    And the Name is Leanne Graham
    And the Phone is 1-770-736-8031 x56442
    And the Street is Kulas Light
    And the Suite is Apt. 556
    And the Username is Bret
    And the Website is hildegard.org
    And the Zipcode is 92998-3874