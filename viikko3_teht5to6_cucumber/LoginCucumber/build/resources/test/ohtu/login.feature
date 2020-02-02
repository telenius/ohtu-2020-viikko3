Feature: User_can_log_in_with_valid_username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  username "pekka" and password "akkep" are entered
       Then  system will respond with "logged in"
       
    Scenario: user can not login with incorrect password
       Given command login is selected
       When  username "pekka" and wrong password "pakki" are entered
       Then  system will respond with "wrong username or password"
       
    Scenario: nonexistent user can not login to 
       Given command login is selected
       When  nonexistent username "kissa" and a password "kassi" are entered
       Then  system will respond with "wrong username or password"
    
