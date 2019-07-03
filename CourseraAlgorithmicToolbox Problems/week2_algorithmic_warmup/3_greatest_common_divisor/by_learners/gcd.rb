#!/usr/bin/env ruby
# by Andronik Ordian

def gcd(a, b)
  # fix me
  a * b
end

if __FILE__ == $0
  a, b = gets.split().map(&:to_i)
  puts "#{gcd(a, b)}"
end