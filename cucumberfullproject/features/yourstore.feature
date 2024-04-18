@yourstore
Feature: yourstore

  @smoke
  Scenario Outline: succesfully login with valid credential
    Given user launches "<browser>" with "<url>"
    Then user navigated to the "<loginpagetitle>"
    And user enters validcredential email as "admin@yourstore.com" and password as "admin"
    Then click login button
    Then user lands on "<dashboardpagetitle>"
 
    Examples: 
      | browser | url                                      | loginpagetitle    | dashboardpagetitle                     |
      | chrome  | https://admin-demo.nopcommerce.com/login | Your store. Login | Dashboard / nopCommerce administration |

  @regression
  Scenario Outline: Validate customer page title
    Given user launches "<browser>" with "<url>"
    Then user navigated to the "<loginpagetitle>"
    And user enters validcredential email as "admin@yourstore.com" and password as "admin"
    Then click login button
    Then user lands on "<dashboardpagetitle>"
    Then user click on "<Menu>" menu
    Then user click on Customer Button
    Then user lands on "<Customerpagetitle>"

    Examples: 
      | browser | url                                      | loginpagetitle    | dashboardpagetitle                     | Menu      | Customerpagetitle                      |
      | chrome  | https://admin-demo.nopcommerce.com/login | Your store. Login | Dashboard / nopCommerce administration | Customers | Customers / nopCommerce administration |

    @smoke @regression  
       Scenario Outline: Validate email by search
    Given user launches "<browser>" with "<url>"
    Then user navigated to the "<loginpagetitle>"
    And user enters validcredential email as "admin@yourstore.com" and password as "admin"
    Then click login button
    Then user lands on "<dashboardpagetitle>" 
    Then user click on "<Menu>" menu
    Then user click on Customer Button
    Then user lands on "<Customerpagetitle>" 
    Then click on "<Email>" field
    And insert "<EmailID>" as email
    Then click on search button
    And Email should be visible
    
     Examples: 
      | browser | url                                      | loginpagetitle    | dashboardpagetitle                     | Menu      | Customerpagetitle                      |
      | chrome  | https://admin-demo.nopcommerce.com/login | Your store. Login | Dashboard / nopCommerce administration | Customers | Customers / nopCommerce administration |
    
    
    
    