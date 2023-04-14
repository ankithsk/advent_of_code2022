data = open('input.txt', 'r')
calories = []
max_sum = 0
for line in data:
    if line == '\n':
        total = sum(calories)
        if total > max_sum:
            max_sum = total
        calories = []
    else:
        calories.append(int(line))
print(max_sum)