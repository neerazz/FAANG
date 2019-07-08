-- by Kirill Elagin

fibonacci_partial_sum_naive :: Integer -> Integer -> Int
fibonacci_partial_sum_naive from to = let (a', b', _) = helper (0, 1, 0) from
                                          (_, _, s) = helper (a', b', a') (to - from)
                                      in s
  where
    helper (a, b, s) 0 = (a, b, s `mod` 10)
    helper (a, b, s) i = helper (b, a + b, s + b) (i - 1)

main :: IO ()
main = do
  [from, to] <- fmap words getLine
  print $ fibonacci_partial_sum_naive (read from) (read to)
