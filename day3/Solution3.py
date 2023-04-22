data = open('input.txt', 'r')
total = 0
for line in data:
    half = (int)(len(line)/2)
    part1 = line[0:half]
    part2 = line[half:]
    part1Set = set(part1)
    part2Set = set(part2)
    overlap = part1Set.intersection(part2Set)

    for letter in overlap:
      if letter.isupper():
         total+= ord(letter) - ord('A') + 27
      else:
         total+= ord(letter) - ord('a') + 1
print(total)
