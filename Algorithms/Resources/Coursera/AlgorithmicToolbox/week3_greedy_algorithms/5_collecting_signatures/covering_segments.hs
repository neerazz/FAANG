-- by Kirill Elagin

import Control.Monad (replicateM)


optimal_points :: [(Int, Int)] -> [Int]
optimal_points segments = map fst segments -- write your code here

main :: IO ()
main = do
  n' <- getLine
  let n = read n'
  segments <- replicateM n $ fmap ((\[s, e] -> (read s, read e)) . words) getLine
  let points = optimal_points segments
  print $ length points
  putStrLn $ unwords (map show points)
