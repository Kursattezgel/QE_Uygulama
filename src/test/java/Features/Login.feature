@logincases
  Feature: Login Cases

    Background:
      Given the user is on the site page

    @login1
    Scenario: User succesfully logs in with valid credentials
      When enter the username "kursat.tezgel@testinium.com"
      And enter the password "Arabul1711."
      And click on the login button
      Then QE page opens


    @login2
    Scenario: Login with invalid credentials
      When enter the username "kursat.tezgel@testinium.com"
      And enter the password "asd13213asd."
      And click on the login button
      Then Failed to login


    @login3
    Scenario: Login with invalid credentials
      When enter the username "testtest"
      And enter the password "Arabul1711.."
      And click on the login button
      Then Failed to login

    @login4
    Scenario: Opening the My Account page
      When enter the username "kursat.tezgel@testinium.com"
      And enter the password "Arabul1711."
      And click on the login button
      And QE page opens
      Then My Account page opens


