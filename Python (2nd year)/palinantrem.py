#A pogram to confirm if a word or a sentence is a polianantrem or not by maciej skrzypczynski
import string

my_string = input("enter word \n")

string_modified = my_string.lower()

bad_chars = string.whitespace + string.punctuation

for c in bad_chars:
    string_modified = string_modified.replace(c,"")

if string_modified == string_modified[::-1]:
    print("It is a palinantrem")
else:
    print("It is not a palinantrem")