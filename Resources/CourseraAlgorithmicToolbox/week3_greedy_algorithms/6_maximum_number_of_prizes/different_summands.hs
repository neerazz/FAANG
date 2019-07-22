-- by Kirill Elagin

optimal_summands :: Int -> [Int]
optimal_summands n = [n] -- write your code here

main :: IO ()
main = do
  n  <- getLine
  let summands = optimal_summands (read n)
  print $ length summands
  putStrLn $ unwords (map show summands)
