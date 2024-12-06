#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login for online shopping portal
  I want to login to the online portal and then should be able to logout
  
  @login
  Scenario Outline:
  Given I am on the login page
  When I enter "<username>" and "<password>"
  And I click on login button
  Then I should be logged in successfully
  Examples:
  |username|password|
  |standard_user|secret_sauce|
  
   @login
  Scenario Outline:
  Given I am on the home page
  When I click on logout
  Then Login page is displayed
  
