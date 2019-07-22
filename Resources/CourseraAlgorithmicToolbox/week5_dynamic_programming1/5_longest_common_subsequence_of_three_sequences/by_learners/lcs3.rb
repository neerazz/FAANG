#!/usr/bin/env ruby
# by Andronik Ordian

def lcs3(a, b, c)
  # write your code here
  [a.size, b.size, c.size].min
end

if __FILE__ == $0
  data = STDIN.read.split().map(&:to_i)
  n = data[0]
  a = data[1..n]
  m = data[n+1]
  b = data[n+2..n+1+m]
  c = data[n+3+m..-1]
  puts lcs3(a, b, c)
end
