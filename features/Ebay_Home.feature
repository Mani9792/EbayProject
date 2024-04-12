Feature: Ebay Home Page scenarios

@test1
Scenario: Advanced search link

Given I am on Ebay home page
When I click on advanced link
Then I navigate to Advanced search page	

@test2
Scenario: Search Items Count

Given I am on ebay home page
When I search for 'Iphone 11'
Then I validate altleast 10000000 search items present

@test3
Scenario: Search Items Count

Given I am on ebay home page
When I search for 'Toy Cars'
Then I validate altleast 100 search items present