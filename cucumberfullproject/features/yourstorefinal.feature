@yourstorefinal
Feature: yourstorefinal

@backround: 
 Given user launches "<browser>" with "<url>"
    Then user navigated to the "<loginpagetitle>"
    And user enters validcredential email as "admin@yourstore.com" and password as "admin"
    Then click login button   
  @smoke
  Scenario Outline: succesfully login with valid credential
    
    Then user lands on "<dashboardpagetitle>"
 
    Examples: 
      | browser | url                                      | loginpagetitle    | dashboardpagetitle                     |
      | chrome  | https://admin-demo.nopcommerce.com/login | Your store. Login | Dashboard / nopCommerce administration |

  @regression
  Scenario Outline: Validate customer page title
   
    Then user lands on "<dashboardpagetitle>"
    Then user click on "<Menu>" menu
    Then user click on Customer Button
    Then user lands on "<Customerpagetitle>"

    Examples: 
      | browser | url                                      | loginpagetitle    | dashboardpagetitle                     | Menu      | Customerpagetitle                      |
      | chrome  | https://admin-demo.nopcommerce.com/login | Your store. Login | Dashboard / nopCommerce administration | Customers | Customers / nopCommerce administration |

    @smoke @regression  
       Scenario Outline: Validate email by search
    
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
    
    
    
