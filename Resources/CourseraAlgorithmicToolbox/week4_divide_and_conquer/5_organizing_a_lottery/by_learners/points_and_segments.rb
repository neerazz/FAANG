#!/usr/bin/env ruby
# by Andronik Ordian

Segment = Struct.new("Segment", :a, :b) do
  def contains?(point)
    a <= point and point <= b
  end
end

def fast_count_segments(segments, points)
  count = Array.new(points.size, 0)
  # write your code here
  count
end

def naive_count_segments(segments, points)
  points.map { |point| segments.count { |s| s.contains?(point) } }
end

if __FILE__ == $0
  data = STDIN.read.split().map(&:to_i)
  s, p = data[0], data[1]
  segments = data[2..2*s+1].each_slice(2).to_a.map { |e| Segment.new(e[0], e[1]) }
  points = data[2*s+2..-1]
  # replace naive with fast
  puts naive_count_segments(segments, points).join(' ')
end

