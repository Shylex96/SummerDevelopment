# QUIZ GAME

questions = ("How many elements are in the periodic table?: ", 
             "Which animal lays the largest eggs?: ", 
             "What is the most abundant gas in Earth's atmosphere?: ", 
             "How many bones are in the human body?: ", 
             "Which planet in the solar system is the hottest?: ")

options = (("A. 116", "B. 117", "C. 118", "D. 119"), 
           ("A. Whale", "B. Cocodrile", "C. Elephant", "D. Ostrich"), 
           ("A. Nitrogen", "B. Oxygen", "C. Carbon-Dioxide", "D. Hydrogen"), 
           ("A. 206", "B. 207", "C. 208", "D. 209"), 
           ("A. Mercury", "B. Venus", "C. Earth", "D. Mars"))


answers = ("C", "D", "A", "A", "B")
guesses = []
score = 0
question_num = 0

for question in questions:
    print("----------------------------")
    print(question)
    for option in options [question_num]:
        print(option)


    guess = input("Enter (A, B, C, D): ").upper()
    guesses.append(guess)
    if guess == answers[question_num]:
        score += 1
        print("CORRECT!")
    else: 
        print("INCORRECT!")
        print(f"{answers[question_num]} is the correct answer")
    question_num += 1

print("----------------------------")
print("-         RESULTS:         -")
print("----------------------------")

print("Correct Answers:", end="")
for answer in answers:
    print(answer, end=" ")
print()

print("Your Guesses:", end="")
for guess in guesses:
    print(guess, end=" ")
print()

print()
score = int(score / len(questions) * 100)
print(f"Your score is {score}%")

if score == 0:
    print("Oh no! It looks like you need to review a bit more. Don't get discouraged and keep practicing!")
elif score == 20:
    print("There's still a lot of room for improvement. Keep practicing, and you'll see how your knowledge grows")
elif score == 40:
    print("You're on the right track, but there's still plenty of room to improve. Keep learning and be amazed by your progress!")
elif score == 60:
    print("Good job! You're getting more answers right. Keep it up, and you'll see how your efforts pay off.")
elif score == 80:
    print("Excellent work! You're very close to perfection. Just one final push, and you'll achieve complete mastery.")
elif score == 100:
    print("Congratulations! You're an expert in this topic! Your dedication and effort have paid off. Keep going and keep challenging yourself!")
else:
    print("Unexpected Error: This shouldn't have happened.")