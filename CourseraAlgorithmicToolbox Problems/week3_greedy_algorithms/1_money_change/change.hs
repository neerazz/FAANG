-- by Kirill Elagin

get_change :: Int -> Int
get_change m = n -- write your code here

main :: IO ()
main = do
  [m] <- fmap words getLine
  print $ get_change (read m)
