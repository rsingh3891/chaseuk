#Author: Raj Singh
#Feature: Comments - Endpoint to test is https://jsonplaceholder.typicode.com/comments

Feature: Comments
  As a social media user
  I want to make and view comments
  So that I can verify that the comments endpoint is working correctly

  @Comments_001
  Scenario Outline: User is able to view the comments details from a postId path parameter
    Given I have a "postId" with the value "1"
    When I make a GET call to the "/comments" endpoint
    Then a 200 response code is received
    And the PostId is 1
    And the Id is <id>
    And the Name is <name>
    And the Email is <email>
    And the Body is <body>
    Examples:
      | id | name                                      | email                  | body                                                                                                                                                                                                                          |
      | 1  | id labore ex et quam laborum              | Eliseo@gardner.biz     | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium                                                                       |
      | 2  | quo vero reiciendis velit similique earum | Jayne_Kuhic@sydney.com | est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et                                                   |
      | 3  | odio adipisci rerum aut animi             | Nikita@garfield.biz    | quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione |
      | 4  | alias odio sit                            | Lew@alysha.tv          | non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati                                                                 |
      | 5  | vero eaque aliquid doloribus et culpa     | Hayden@althea.biz      | harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et                                                                                       |

  @Comments_002
  Scenario: User is able to view the comments details from an id path parameter
    Given I have a "id" with the value "1"
    When I make a GET call to the "/comments" endpoint
    Then a 200 response code is received
    And the PostId is 1
    And the Id is 1
    And the Name is id labore ex et quam laborum
    And the Email is Eliseo@gardner.biz
    And the Body is laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium

  @Comments_003
  Scenario: User is able to view the comments details from an email path parameter
    Given I have a "email" with the value "Emma@joanny.ca"
    When I make a GET call to the "/comments" endpoint
    Then a 200 response code is received
    And the PostId is 100
    And the Id is 500
    And the Name is ex eaque eum natus
    And the Email is Emma@joanny.ca
    And the Body is perspiciatis quis doloremque\nveniam nisi eos velit sed\nid totam inventore voluptatem laborum et eveniet\naut aut aut maxime quia temporibus ut omnis

  @Comments_004
  Scenario: User is able to make a post request to the comments endpoint
    Given I have setup my contents for the post body in the JSON file Comments_004.json
    When I make a POST call to the "/comments" endpoint
    Then a 201 response code is received
    And the PostId is 101
    And the Id is 501
    And the Name is Tommy Tester
    And the Email is tommytester@yahoo.com
    And the Body is this is my comment

  #One would assume this test should fail if the postId is a non-int value, but it passes
  @Comments_005
  Scenario: User is able to make a post request to the comments endpoint with a string PostId value
    Given I have setup my contents for the post body in the JSON file Comments_005.json
    When I make a POST call to the "/comments" endpoint
    Then a 201 response code is received
    And the PostId is string
    And the Id is 501
    And the Name is Tommy Tester
    And the Email is tommytester@yahoo.com
    And the Body is this is my comment

  #One would assume this test should fail if the id is a non-int value, but it passes
  @Comments_006
  Scenario: User is able to make a post request to the comments endpoint with a string Id value
    Given I have setup my contents for the post body in the JSON file Comments_005.json
    When I make a POST call to the "/comments" endpoint
    Then a 201 response code is received
    And the PostId is 501
    And the Id is string
    And the Name is Tommy Tester
    And the Email is tommytester@yahoo.com
    And the Body is this is my comment

  #One would assume this test should fail if the post body contains details for the
  # /posts endpoint instead, but it passes
  @Comments_007
  Scenario: User is able to make a post request to the comments endpoint with an invalid key
    Given I have setup my contents for the post body in the JSON file Posts_003.json
    When I make a POST call to the "/comments" endpoint
    Then a 201 response code is received
    And the UserId is 11
    And the Id is 101
    And the Title is this is the title
    And the Body is this is the body