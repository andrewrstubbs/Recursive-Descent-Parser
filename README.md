# Recursive-Descent-Parser
A simple recursive descent parser which determines if an input String is a "slurpy" 

Slurpy EBNF:

<slurpy> -> <slimp> <slump>

<slimp> -> AH | A (B <slimp> | <slump>) C

<slump> -> (D|E) {F} (<slump> | G)
