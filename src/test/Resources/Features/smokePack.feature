Feature: smoke pack- creating & editing organisation, creating and editing auth group, creating and editing person profile, creating and editing an action plan, creating and editing contracts,
  adding vehicles, adding trips

  Scenario: as a super admin i should be able to add and edit an organisation
    Given I am logged in as a super admin
    When I click on the plus icon
    Then I should be able to add an organisation and search and assert the creation organisation and search and assert the creation
    Then I should be able to edit the created organisation and assert the changes

  Scenario: as a super admin i should be able to create an auth profile and assert the creation
    Given I am logged in as a super admin
    When i navigate to the magic search page and search & select a particular organization
    Then i should be able to add an auth group and assert its creation
    And I should be able to edit the created auth group and assert the changes

  Scenario: as a super user i should be able to create a person profile and assert the creation
    Given I am logged in as a super admin
    When i navigate to the magic search page and search & select a particular organization
    Then I should be able to add a person profile and assert its creation
    And I should be able to edit the created person profile and assert the changes

#  Scenario: as a super admin i should be able to create an action plan and assert the creation
#    Given I am logged in as a super admin
#    When i navigate to the magic search page and search & select a particular organization
#    Then I should be able to create an action plan and assert its creation
#    And I should be able to edit the created action plan and assert the changes

  Scenario: as a super admin i should be able to add a vehicle and assert the creation
    Given I am logged in as a super admin
    When i navigate to the magic search page and search & select a particular organization
    Then I should be able to add a new vehicle and assert its creation
    And I should be able to edit the created vehicle and assert the changes

  Scenario: as a super admin i should be able to create a trip and assert the creation
    Given I am logged in as a super admin
    When i navigate to the magic search page and search & select a particular organization
    Then I should be able to add a new trip and assert the creation

  Scenario: user should be able to see all the organisations his auth group is linked to
    Given I login as a user linked to auth group associated with more then one organisation
    Then I should be able to see all the organisations the auth group is linked to
    And I will be shown link up screen once his auth group is unlinked from his profile

  Scenario: auth group permissions - organisation
    Given I have permission to view, edit and create an org
    When I login I should be able to view, edit and create org
    And when the permissions are revoked
    Then i should loose the ability to view, edit and create

  Scenario: auth group permissions- auth groups
    Given I have permissions to view, edit and create auth groups
    When I login i should be able to view, edit and create auth group
    And when the permissions are revoked
    Then i should loose the ability to view, edit and create

  Scenario: auth group permissions - trips
    Given I am permissions to view, edit and create trips
    When I login I should be able to view, edit and create trips
    And when the permissions are revoked
    Then i should loose the ability to view, edit and create

  Scenario: update an action plan and use it to create a client booking
    Given I am logged in as a super admin
    When I update an existing action plan
    Then I should be able to use it to create a client booing
    And I should be able to edit the created booking

  Scenario: user should be able to clone a trip in reverse and add extra passengers and extra way points
    Given I am logged in as a super admin and a trip has been recently created
    When I navigate to the view trip I should be able to clone the trip in reverse
    And add extra passengers from trip schedule for the first day of the trip
    Then I should be able to asset added passengers for the first day
    And I should be able to add extra passenger way points for the last day of the trip
    And assert that the way point is only added to the last day of the trip





