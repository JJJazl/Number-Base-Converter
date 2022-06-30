# Number-Base-Converter
JetBrains Academy Project

A project that allows you to convert numbers from one system to another. Supports all existing number systems, as well as BigInteger and BigDecimal numbers.
Take a look at the instructions below to understand how to use the program.

> On the first level, the user sees the following prompt: Enter two numbers in format: {source base} {target base} (To quit type /exit). Then, they input two numbers separated by a single space: source base and target base. The user also has the option to use the /exit command to quit the program.

> On the second level, the user sees another prompt: Enter number in base {user source base} to convert to base {user target base} (To go back type /back), and inputs the number in the source base. The program outputs the message Conversion result: followed by the number in the target base. Then, the program asks for the new number to convert from the previously provided source base to the target base. To change the bases, the user can choose the BACK command and return to the first level menu to make the necessary changes.

Enter two numbers in format: {source base} {target base} (To quit type /exit) > 10 2
Enter number in base 10 to convert to base 2 (To go back type /back) > 11
Conversion result: 1011

Enter number in base 10 to convert to base 2 (To go back type /back) > 18
Conversion result: 10010

Enter number in base 10 to convert to base 2 (To go back type /back) > 127
Conversion result: 1111111

Enter number in base 10 to convert to base 2 (To go back type /back) > 189344562689000108753301247
Conversion result: 1001110010011111010001010100111110001111101101011010101101001001111110100010111011111111

Enter number in base 10 to convert to base 2 (To go back type /back) > /back

Enter two numbers in format: {source base} {target base} (To quit type /exit) > /exit

Enter two numbers in format: {source base} {target base} (To quit type /exit) > 10 7
Enter number in base 10 to convert to base 7 (To go back type /back) > 0.234
Conversion result: 0.14315

Enter number in base 10 to convert to base 7 (To go back type /back) > 10.234
Conversion result: 13.14315

Enter number in base 10 to convert to base 7 (To go back type /back) > /back

Enter two numbers in format: {source base} {target base} (To quit type /exit) > 35 17
Enter number in base 35 to convert to base 17 (To go back type /back) > af.xy
Conversion result: 148.g88a8

Enter number in base 35 to convert to base 17 (To go back type /back) > aaaa.0
Conversion result: 54e36.00000

Enter number in base 35 to convert to base 17 (To go back type /back) > /back

Enter two numbers in format: {source base} {target base} (To quit type /exit) > /exit
