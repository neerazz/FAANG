#!/usr/bin/env ruby
# by Andronik Ordian

def min(a, b)
  a < b ? a : b
end

def minimum_distance(x, y)
  # write your code here
  Math.sqrt(10 ** 36)
end

if __FILE__ == $0
  data = STDIN.read.split().map(&:to_i)
  n = data.size - 1
  x = (1..n).step(2).map { |i| data[i] }
  y = (2..n).step(2).map { |i| data[i] }
  puts "#{'%.4f' % minimum_distance(x, y)}"
end