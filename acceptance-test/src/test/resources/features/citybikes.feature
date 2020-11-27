@testAll
Feature: CityBikes Api Validation

  Agile Story: As a user I want to verify that the city Frankfurt is in Germany
  and return their corresponding latitude and longitude.

  @test1
  Scenario: GET all network data and verify city location
    When User makes api call to get network data
    #    User object to List<String> and @DataTableType
    Then User verifies that Frankfurt located in Germany
      | city      | country |
      | Frankfurt | DE      |


  @test2
  Scenario Outline: GET all network data and verify that '<city>' located in '<country>'
    When User makes api call to get network data
    Then User verifies that '<city>' located in '<country>'
    Examples:
      | city           | country |
      | Frankfurt      | DE      |
      | Moscow         | RU      |
      | Copenhagen     | DK      |
      | Benidorm       | ES      |
      | Marathon       | GR      |
      | Cork           | IE      |
      | Bangkok        | TH      |
      | London         | GB      |
      | Bergamo        | IT      |
      | Greenville, SC | US      |
      | Nashville, TN  | US      |
      | Sion           | CH      |


  @test3
  Scenario: GET all network data and return subcategories in location
    When User makes api call to get network data
    Then The location category should have the subcategories expected
      | city      |
      | country   |
      | latitude  |
      | longitude |


  @test4
  Scenario: Validate Json Schema of random company in network
    When User gets json response for a single company by random id
    Then Json response should match schema