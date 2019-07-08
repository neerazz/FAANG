#!/usr/bin/env ruby
# by Andronik Ordian

def partition3(a, l, r)
  #write your code here

end

def partition2(a, l, r)
  x = a[l]
  j = l
  (l + 1..r).each do |i|
    if a[i] <= x
      j += 1
      a[i], a[j] = a[j], a[i]
    end
  end
  a[l], a[j] = a[j], a[l]
  j
end

def randomized_quick_sort(a, l, r)
  return nil if l >= r

  k = rand(l..r)
  a[l], a[k] = a[k], a[l]
  # use partition3
  m = partition2(a, l, r)
  randomized_quick_sort(a, l, m - 1);
  randomized_quick_sort(a, m + 1, r);
end

if __FILE__ == $0
  n, *a = STDIN.read.split().map(&:to_i)
  randomized_quick_sort(a, 0, n - 1)
  puts "#{a.join(' ')}"
end
