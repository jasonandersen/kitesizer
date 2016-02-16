################### Kiteboarding Kite Sizer ################
#
# This application will size a kite given a boarder's weight
# and typical wind speeds based on the table of kite sizes
# below:
#
# 95 110 125 140 155 170 185 200 215 230 245 260|   
# ----------------------------------------------| Knt Mph Kph
# 3  3   4   4   5   5   5   6   6   7   7   8  | 34  39  63
# 3  4   4   5   5   6   7   7   8   8   9   9  | 28  32  52
# 4  5   5   6   6   7   8   8   9   8   10  11 | 24  28  44
# 4  5   6   7   7   8   9   9   10  11  12  12 | 21  24  39
# 5  6   7   7   8   9   10  11  11  12  13  14 | 19  22  35
# 6  6   7   8   9   10  11  12  13  14  14  15 | 17  20  31
# 6  7   8   9   10  11  12  13  14  15  16  17 | 15  17  28
# 7  8   9   10  11  12  13  14  15  16  17  18 | 14  16  26
# 7  8   10  11  12  13  14  15  16  18  19  20 | 13  15  24
# 8  9   10  12  13  14  15  16  18  19  20  21 | 12  14  22
# 8  10  11  12  14  15  16  18  19  20  22  23 | 11  13  20
# 9  10  12  13  15  16  17  19  20  22  23  24 | 10  12  19
#
Feature: Size a motherfucking kite

    Scenario Outline: Size mah kite
        Given I weigh "<weight>" pounds
        And I normally kite in "<windSpeed>" knots of wind
        When I calculate kite size
        Then my kite size should be <kiteSize>
        Examples:
        | weight | windSpeed | kiteSize |
        | 95     | 19        | 4        |
        | 95     | 20        | 4        |
        | 95     | 21        | 4        |
        | 95     | 22        | 4        |
        | 95     | 25        | 3        |
        | 95     | 26        | 3        |
        | 230    | 33        | 7        |
        | 230    | 21        | 8        |
        | 230    | 8         | 22       |
        | 95.0   | 19.0      | 4        |

    Scenario: Not enough wind
        Given I weigh "95" pounds
        And I normally kite in "7" knots of wind
        When I calculate kite size
        Then I see the message "There is not enough wind to kite in, brah."
        
    Scenario: Too much wind
        Given I weigh "95" pounds
        And I normally kite in "35" knots of wind
        When I calculate kite size
        Then I see the message "Too much wind - stay on the beach."
        
    Scenario: Below minimum weight
        Given I weigh "94" pounds
        And I normally kite in "10" knots of wind
        When I calculate kite size
        Then I see the message "Not enough weight, eat a sammich."
        
    Scenario: Above maximum weight
        Given I weigh "300" pounds
        And I normally kite in "20" knots of wind
        When I calculate kite size
        Then I see the message "Too much weight - skip a meal, son."

    Scenario: Didn't enter wind speed
        Given I weigh "95" pounds
        And I normally kite in "" knots of wind
        When I calculate kite size
        Then I see the message "Enter a valid wind speed."
        
    Scenario: Entered an non-numeric wind speed
        Given I weigh "95" pounds
        And I normally kite in "MONKEY" knots of wind
        When I calculate kite size
        Then I see the message "Enter a valid wind speed."
    
    Scenario: Didn't enter weight
        Given I weigh "" pounds
        And I normally kite in "20" knots of wind
        When I calculate kite size
        Then I see the message "Enter a valid weight."
    
    Scenario: Entered an invalid weight
        Given I weigh "MONKEY" pounds
        And I normally kite in "20" knots of wind
        When I calculate kite size
        Then I see the message "Enter a valid weight."
        
    Scenario: Didn't enter weight or wind speed
        Given I weigh "" pounds
        And I normally kite in "" knots of wind
        When I calculate kite size
        Then I see the message "Enter a valid weight."        