#!/usr/bin/env ruby
# by Andronik Ordian

# helper function for faster copy
# b[l..r - 1] = a[l..r]
def copy(a, b, l, r)
  while l < r
    b[l] = a[l]
    l += 1
  end
end

def get_number_of_inversions(a, b, left, right)
  number_of_inversions = 0
  return 0 if right - left <= 1

  mid = left + (right - left) / 2
  number_of_inversions += get_number_of_inversions(a, b, left, mid)
  number_of_inversions += get_number_of_inversions(a, b, mid, right)
  #write your code here

  return number_of_inversions
end

if __FILE__ == $0
  n, *a = STDIN.read.split().map(&:to_i)
  b = Array.new(n, 0)
  puts get_number_of_inversions(a, b, 0, n)
end
