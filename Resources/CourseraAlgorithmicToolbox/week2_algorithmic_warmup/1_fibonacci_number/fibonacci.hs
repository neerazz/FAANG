-- by Kirill Elagin

import Control.Exception (assert)

-- The following code calls a naive algorithm for computing a Fibonacci number.
--
-- What to do:
-- 1. Compile the following code and run it on an input "40" to check that it is slow.
--    You may also want to submit it to the grader to ensure that it gets the "time limit exceeded" message.
-- 2. Implement the fibonacci_fast procedure.
-- 3. Remove the line that prints the result of the naive algorithm, comment the lines reading the input,
--    uncomment the line with a call to test_solution, compile the program, and run it.
--    This will ensure that your efficient algorithm returns the same as the naive one for small values of n.
-- 4. If test_solution reveals a bug in your implementation, debug it, fix it, and repeat step 3.
-- 5. Remove the call to test_solution, uncomment the line with a call to fibonacci_fast (and the lines reading the input),
--    and submit it to the grader.

fibonacci_naive :: Int -> Int
fibonacci_naive 0 = 0
fibonacci_naive 1 = 1
fibonacci_naive n = fibonacci_naive (n - 1) + fibonacci_naive (n - 2)

fibonacci_fast :: Int -> Int
fibonacci_fast n = 0  -- write your code here

test_solution :: IO ()
test_solution = and tests `seq` return ()
  where
    tests =
      [ assert (fibonacci_fast 3  == 2)  True
      , assert (fibonacci_fast 10 == 55) True
      ] ++ map (\i -> assert (fibonacci_fast i == fibonacci_naive i) True) [0..20]

main :: IO ()
main = do
  [w] <- fmap words getLine
  let n = read w

  print $ fibonacci_naive n
  --test_solution
  --print $ fibonacci_fast n
