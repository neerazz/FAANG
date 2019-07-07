-- by Kirill Elagin

import Control.Monad (replicateM)
import Numeric (showFFloat)


type Item = (Int, Int)

get_optimal_value :: Int -> [Item] -> Double
get_optimal_value capacity items = value -- write your code here

main :: IO ()
main = do
  [n', capacity'] <- fmap words getLine
  let (n, capacity) = (read n', read capacity')
  items <- replicateM n $ fmap ((\[v, w] -> (read v, read w)) . words) getLine
  printFloat $ get_optimal_value capacity items
 where
  printFloat x = putStrLn $ showFFloat (Just 4) x ""
