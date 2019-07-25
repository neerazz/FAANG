-- by Kirill Elagin

gcd_naive :: Int -> Int -> Int
gcd_naive a b = maximum [ d | d <- [1 .. min a b], a `mod` d == 0 && b `mod` d == 0 ]

main :: IO ()
main = do
  [a, b] <- fmap words getLine
  print $ gcd_naive (read a) (read b)
