@cases
  Feature: Genel Caseler

    Background:
      Given the user is on the site page
      When enter the username "kursat.tezgel@testinium.com"
      And enter the password "Arabul1711."
      And click on the login button
      And click on the open money transfer button


      @case1
    Scenario: Transfer money to another account
        When click on the transfer money button
        And enter the amount "200"
        And click on the Send
        Then total balance is checked



        @case2
      Scenario: Transfer money to your own account
        When click on the ADD MONEY
        And enter the card number "123412341234"
        And enter the card holder "kursat tezgel"
        And enter the expiry date "1026"
        And enter the CVV "110"
        And enter the quantity "500"
        And click on the ADD button
        Then total balance is checked


        @case3
      Scenario: Depositing Money to Your Own Account with a Non-Existent Card
        When click on the ADD MONEY
        And enter the card number "123411111111"
        And enter the card holder "test test"
        And enter the expiry date "1111"
        And enter the CVV "111"
        And enter the quantity "1000"
        And click on the ADD button
        Then Check if the balance is the same


        @case4
        Scenario: Depositing more than the balance
          When click on the transfer money button
          And enter the amount more than the balance
          And click on the Send
          Then Check if the balance is the same

        @case5
        Scenario: Account name update
          When click on the Edit Account button
          When enter the account name "tezgelkursat"
          And click on the Update button
          Then account name is checked


