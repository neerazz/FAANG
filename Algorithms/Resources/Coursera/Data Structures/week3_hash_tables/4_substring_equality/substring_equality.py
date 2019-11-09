# python3

import sys

class Solver:
	def __init__(self, s):
		self.s = s
	def ask(self, a, b, l):
		return s[a:a+l] == s[b:b+l]

s = sys.stdin.readline()
q = int(sys.stdin.readline())
solver = Solver(s)
for i in range(q):
	a, b, l = map(int, sys.stdin.readline().split())
	print("Yes" if solver.ask(a, b, l) else "No")
