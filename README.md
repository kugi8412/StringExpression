# StringExpression
Classes that allow you to operate on text expressions.

## Description
The string expressions we are considering contain:

Constants (enclosed in inverted commas),
    1) Variables (denoted by single lower case Latin letters)
    
    2) Unary operators:
        Converts to upper case (^), non-letter characters remain unchanged, is intended to work for letters of the English alphabet, for others it may or may not.
        E.g. ^"java and c++" results in "JAVA AND C++".
        Converts to lower case (_), non-letter characters remain unchanged, is supposed to work for letters of the English alphabet, for others it may or may not.
        E.g. _"PanDas" results in "pandas".
        Counting the length of a letter (#), the result is to be a letter that is that length.
        E.g. #"Java" gives the result '4'.
        
    3) Binary operators:
        Concatenating subtitles (&). The result has the first argument first, then the second argument.
        E.g. "J" & "ava" results in "Java".
        Masking (*). The result is a caption containing those characters from the first argument that correspond to the '*' character in the second argument. If the second argument is shorter than the first, the second argument is repeated a corresponding number of times. If the second argument is empty, the result is an empty subtitle.
        E.g. "Basic" * ".*" results in "ai".
        Interlacing (@): sets alternating characters from the first and second inscriptions, and sticks the tail of the longer inscription at the end. The first character comes from the first subtitle (unless it is empty).
        E.g. "Java" @ "Python" results in "JPayvtahon".
