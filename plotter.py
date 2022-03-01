from matplotlib.pyplot import plot, savefig, scatter
import json
import sys
guild = sys.argv[1]
print(sys.argv)
with open("leaderboard2.json") as file:
    jsonstring = json.loads(file.read())
l = [jsonstring[guild][id] for id in jsonstring[guild]]
l.sort(reverse=True)
#plot(l)
scatter(range(len(l)), l)
savefig("tmp.png")
