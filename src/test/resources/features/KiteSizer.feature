Feature: Size a motherfucking kite

    Scenario Outline: Size mah kite
        Given I weigh <weight> pounds
        And I normally kite in <windSpeed> knots of wind
        When I calculate kite size
        Then my kite size should be <kiteSize>
        
        Examples:
        | weight | windSpeed | kiteSize |
        | 95     | 19        | 4        |
        | 95     | 20        | 4        |
        | 95     | 21        | 4        |
        | 95     | 22        | 5        |

    Scenario: Not enough wind
        Given I weigh 95 pounds
        And I normally kite in 7 knots of wind
        When I calculate kite size
        Then I see the message "There is not enough wind to kite in, brah."
        
    Scenario: Too much wind
        Given I weigh 95 pounds
        And I normally kite in 35 knots of wind
        When I calculate kite size
        Then I see the message "Too much wind - stay on the beach."
        
