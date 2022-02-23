from matplotlib.pyplot import plot, savefig
import json
import sys
guild = sys.argv[1]
print(sys.argv)
with open("leaderboard2.json") as file:
    jsonstring = json.loads(file.read())
l = [jsonstring[guild][id] for id in jsonstring[guild]]
l.sort(reverse=True)
plot(l)
savefig("tmp.png")
