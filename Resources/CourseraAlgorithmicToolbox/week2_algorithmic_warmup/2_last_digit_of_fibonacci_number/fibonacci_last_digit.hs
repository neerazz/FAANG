-- by Kirill Elagin

fibonacci_last_digit :: Int -> Int
fibonacci_last_digit = helper (0, 1)
  where
    helper (a, _) 0 = a `mod` 10
    helper (a, b) n = helper (b, a + b) (n - 1)

main :: IO ()
main = do
  [n] <- fmap words getLine
  print $ fibonacci_last_digit (read n)
