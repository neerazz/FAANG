-- by Kirill Elagin

largest_number :: [Int] -> String
largest_number as = concat (map show as) -- write your code here

main :: IO ()
main = do
  _  <- getLine
  as <- fmap (map read . words) getLine
  putStrLn $ largest_number as
