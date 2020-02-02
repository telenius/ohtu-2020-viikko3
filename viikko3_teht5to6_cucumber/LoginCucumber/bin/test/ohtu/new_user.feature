Feature: A_new_user_account_can_be_created_if_a_proper_unused_username_and_password_are_given

    Scenario: creation is successful with valid username and password
        Given command new is selected
        When  username "eero" and password "salainen1" are entered
        Then  system will respond with "new user registered"
        
        Scenario: creation fails with already taken username and valid password
        Given user "eero" with password "salainen1" exists
        And   command new is selected
        When  username "eero" and password "salainen1" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new is selected
        When  username "ee" and password "salainen1" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new is selected
        When  username "eero" and password "salaine" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password long enough but consisting of only letters
        Given command new is selected
        When  username "eero" and password "salainen" are entered
        Then  system will respond with "new user not registered"

    Scenario: can login with successfully generated account
        Given user "eero" with password "salainen1" exists
        And   command login is selected
        When  username "eero" and password "salainen1" are entered
        Then  system will respond with "logged in"