#!/usr/bin/env ruby
# by Andronik Ordian

def minimum_operations(n)
  # change this code	
  sequence = []
  while n >= 1
  	sequence.push(n)
  	case 
  	when n % 3 == 0
  		n /= 3	
  	when n % 2 == 0
  		n /= 2	
  	else	
  		n -= 1
  	end
  end
  sequence.reverse

end

if __FILE__ == $0
  n = gets.to_i
  answer = minimum_operations(n)
  puts answer.length - 1
  puts answer.join(' ')
end