-- by Kirill Elagin

fibonacci_sum_naive :: Integer -> Int
fibonacci_sum_naive = helper (0, 1, 0)
  where
    helper (_, _, s) 0 = s `mod` 10
    helper (a, b, s) i = helper (b, a + b, s + b) (i - 1)

main :: IO ()
main = do
  [n] <- fmap words getLine
  print $ fibonacci_sum_naive (read n)
