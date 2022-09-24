#Author: Raj Singh
#Feature: Posts - Endpoint to test is https://jsonplaceholder.typicode.com/posts

Feature: Posts
  As a social media user
  I want to make and view posts
  So that I can verify that the posts endpoint is working correctly

  @Posts_001
  Scenario Outline: User is able to view the post details from a userId path parameter
    Given I have a "userId" with the value "1"
    When I make a GET call to the "/posts" endpoint
    Then a 200 response code is received
    And the UserId is 1
    And the Id is <id>
    And the Title is <title>
    And the Body is <body>
    Examples:
      | id | title                                                                      | body                                                                                                                                                                                                              |
      | 1  | sunt aut facere repellat provident occaecati excepturi optio reprehenderit | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto                                                 |
      | 2  | qui est esse                                                               | est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla |
      | 3  | ea molestias quasi exercitationem repellat qui ipsa sit aut                | et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut                                           |
      | 4  | eum et est occaecati                                                       | ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit                 |
      | 5  | nesciunt quas odio                                                         | repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque                                                            |

  @Posts_002
  Scenario: User is able to view the posts detail from an id path parameter
    Given I have a "id" with the value "100"
    When I make a GET call to the "/posts" endpoint
    Then a 200 response code is received
    And the UserId is 10
    And the Id is 100
    And the Title is at nam consequatur ea labore ea harum
    And the Body is cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut

  @Posts_003
  Scenario: User is able to make a post request to the posts endpoint
    Given I have setup my contents for the post body in the JSON file Posts_003.json
    When I make a POST call to the "/posts" endpoint
    Then a 201 response code is received
    And the UserId is 11
    And the Id is 101
    And the Title is this is the title
    And the Body is this is the body

  #One would assume this test should fail if the userId is a non-int value, but it passes
  @Posts_004
  Scenario: User is able to make a post request with a string UserId value
    Given I have setup my contents for the post body in the JSON file Posts_004.json
    When I make a POST call to the "/comments" endpoint
    Then a 201 response code is received
    And the UserId is string
    And the Id is 101
    And the Title is this is the title
    And the Body is this is the body

  #One would assume this test should fail if the userId is a non-int value, but it passes
  @Posts_005
  Scenario: User is able to make a post request with a string Id value
    Given I have setup my contents for the post body in the JSON file Posts_005.json
    When I make a POST call to the "/posts" endpoint
    Then a 201 response code is received
    And the PostId is 11
    And the Id is string
    And the Title is this is the title
    And the Body is this is the body

  #One would assume this test should fail if the post body contains details for the
  # /comments endpoint instead, but it passes
  @Posts_006
  Scenario: User is able to make a post request to the comments endpoint with an invalid key
    Given I have setup my contents for the post body in the JSON file Comments_004.json
    When I make a POST call to the "/posts" endpoint
    Then a 201 response code is received
    And the PostId is 101
    And the Id is 501
    And the Name is Tommy Tester
    And the Email is tommytester@yahoo.com
    And the Body is this is my comment