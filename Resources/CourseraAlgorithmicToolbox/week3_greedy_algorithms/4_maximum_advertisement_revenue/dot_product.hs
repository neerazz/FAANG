-- by Kirill Elagin

max_dot_product :: [Int] -> [Int] -> Integer
max_dot_product as bs = result -- write your code here

main :: IO ()
main = do
  _  <- getLine
  as <- fmap (map read . words) getLine
  bs <- fmap (map read . words) getLine
  print $ max_dot_product as bs
