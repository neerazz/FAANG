#!/usr/bin/env ruby
# by Andronik Ordian

def largest_number(a)
  # write your code here
  a.join('')
end

if __FILE__ == $0
  a = STDIN.read.split().drop(1)
  puts largest_number(a)
end