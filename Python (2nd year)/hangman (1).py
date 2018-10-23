#Program for a game of hangman by maciej skrzypczynski
#DAte 11/10/2018
import string

word = "screen"#word user has to guess
l = len(word)-1
guess = ''
wordsofar =''
letters = ''
life = 10
x = 0 #control variable
censor = '*' * len(word)


print('Welcome to the hangman game guess the word by letter')

while 1:
    c = 0 #control variable
    guess = input('Guess a Letter\n')
    letters = letters + guess
    for i in range(len(wordsofar)):
        if guess[0] == wordsofar[i]:
            print("You have entered the same letter try again")
            while guess[0] == wordsofar[i]:
                guess = input("Enter new letter \n")
    for i in range(len(word)): #for loop checks if the user guessed a correct letter
       if guess[0] == word[i]:
            censor = censor[:i] + word[i] + censor[i + 1:]
            print("Correct guess")
            c = c + 1
            x = x + 1
            wordsofar = wordsofar + word[i]
    print(censor)
    if c == 0: # if C is more then 0 means user entered a correct guess
        life = life - 1
        print("Wrong guess you loose a life")
        print("lives left = ",life)
    # ans user guessed correct letters me
    if x == 6:
        print("Well done you guess the word ", word)
        break
    # when no lives left game over
    if life == 0:
        print("GAME OVER")
        break
    # show the position of the letter guessed
    print("Right Letters guessed so far in correct order",wordsofar)
    print("Guessed letters so far",letters.upper())
