Feature: As_a_user_I_want_to_be_able_to_set_the_counter_to_value_zero

Scenario: Resetting after one increment
    Given Counter is initialized
    When it is incremented
    And it is reset 
    Then the value should be 0

  Scenario: Resetting_after_incrementing_with_several_values
    Given Counter is initialized
    When it is incremented by 5
    And it is reset 
    Then the value should be 0
    