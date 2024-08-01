Feature: World Clock

  @smoke @regression
  Scenario: Navigation to Be.cognizant portal with valid credintials
    Given navigate the browser to Be.cognizant portal with the url
   
    When user provides valid credintials with usermail/phone/skype
    When verify the title of the be cognizant portal
    And user clicks on account manager icon
    Then valid usermail should be displayed
    
  @smoke 
  Scenario: Validation of world clock
    Given user navigated Be.cognizant portal home page
    
    When user scrolls till end of page
    Then world clock should be displayed
    
    When timezones of Bangalore, London and NewYork are displayed
    Then tiemzones are verified
    
    When Day/date of Bangalore, London and NewYork are displayed
    Then Day/dates are verified
    
    When time differences for London and NewYork are displayed
    Then time differneces are compared to Bangalore time
    
   @smoke @sanity
   Scenario: Navigation to One Cognizant portal and validation of App store
    Given user scrolls to One Cognizant button
    
    When user clicks on One cognizant and navigates to one cognizant window
    And user clicks on view all apps
    Then all enabled and disabled alphabetical apps are verified
    And all the apps corresponding to a number are displayed
    
    

    
