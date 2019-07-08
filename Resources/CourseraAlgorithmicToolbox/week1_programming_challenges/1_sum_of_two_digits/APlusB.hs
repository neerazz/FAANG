
main = do
  s <- getLine
  let w = words s
      readInt :: String -> Int
      readInt = read
      x = map readInt w
      t = sum x
  putStrLn $ show t
