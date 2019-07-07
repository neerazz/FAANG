#!/usr/bin/env ruby
# by Andronik Ordian

def get_optimal_value(capacity, weights, values)
  value = 0.0
  # write your code here
  value
end

if __FILE__ == $0
  data = STDIN.read.split().map(&:to_i)
  n, capacity = data[0,2]
  values = data.values_at(*(2..2*n).step(2))
  weights = data.values_at(*(3..2*n+1).step(2))

  answer = get_optimal_value(capacity, weights, values)
  puts "#{'%.4f' % answer}"
end