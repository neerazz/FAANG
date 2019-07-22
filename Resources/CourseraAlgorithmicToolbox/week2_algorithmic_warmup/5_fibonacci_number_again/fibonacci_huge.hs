-- by Kirill Elagin

get_fibonacci_huge_naive :: Integer -> Int -> Int
get_fibonacci_huge_naive n m = helper (0, 1) n
  where
    helper (a, _) 0 = a `mod` m
    helper (a, b) i = helper (b, a + b) (i - 1)

main :: IO ()
main = do
  [n, m] <- fmap words getLine
  print $ get_fibonacci_huge_naive (read n) (read m)
