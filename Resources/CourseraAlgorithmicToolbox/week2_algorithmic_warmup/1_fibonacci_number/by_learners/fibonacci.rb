#!/usr/bin/env ruby
# by Andronik Ordian

def calc_fib(n)
  return n if n <= 1
  # slow
  # fix me
  calc_fib(n - 1) + calc_fib(n - 2)
end

if __FILE__ == $0
  n = gets.to_i
  puts "#{calc_fib(n)}"
end
