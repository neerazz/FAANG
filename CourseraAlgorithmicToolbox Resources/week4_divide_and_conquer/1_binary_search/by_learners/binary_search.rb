#!/usr/bin/env ruby
# by Andronik Ordian

def binary_search(x, a)
  #write your code here
  -1
end

if __FILE__ == $0
  data = STDIN.read.split().map(&:to_i)
  n = data[0]
  a = data[1..n]
  m = data[n+1]
  data[n+2, m].each { |b| print("#{binary_search(b, a)} ") }
  puts ""
end
