#!/usr/bin/env ruby
# by Andronik Ordian

def optimal_weight(w, weights)
  # write your code here
  result = 0
  weights.each { |weight| result += weight if result + weight <= w }
  result
end

if __FILE__ == $0
  w, _, *weights = STDIN.read.split().map(&:to_i)
  puts optimal_weight(w, weights)
end
