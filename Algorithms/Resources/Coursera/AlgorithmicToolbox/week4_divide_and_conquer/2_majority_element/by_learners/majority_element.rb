#!/usr/bin/env ruby
# by Andronik Ordian

def get_majority_element(a, left, right)
  return -1 if left >= right
  return a[left] if right - left == 1

  # write your code here
  -1
end

if __FILE__ == $0
  n, *a = STDIN.read.split().map(&:to_i)
  answer = get_majority_element(a, 0, n) != -1
  puts "#{answer ? 1 : 0}"
end
