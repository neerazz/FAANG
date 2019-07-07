-- by Kirill Elagin

lcm_naive :: Int -> Int -> Integer
lcm_naive a b = minimum [ l | l <- [1 .. a' * b'], l `mod` a' == 0 && l `mod` b' == 0 ]
  where
    a' = fromIntegral a :: Integer
    b' = fromIntegral b :: Integer

main :: IO ()
main = do
  [a, b] <- fmap words getLine
  print $ lcm_naive (read a) (read b)
