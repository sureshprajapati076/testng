Feature: YouTube Feature Dec 2022

  @youtube
  Scenario Outline: Search text Automation in youtube
    Given User is in youtube "<homepage>" homepage
    And User enters text "<searchText>" in search box
    And User Click search Button
    Then Verify user sees results

    Examples:
      | homepage            | searchText  |
      | https://youtube.com | Automation1 |
      | https://youtube.com | Automation2|