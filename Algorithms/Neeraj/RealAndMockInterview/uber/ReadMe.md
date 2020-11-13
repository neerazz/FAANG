# Online Test:
 
 ## Q1:
>
> Given a Number n. Return the product - sum of all the digits. <br>
>   Example:
>   124 <br>
>   Product = 1 * 2 * 4  = 8 <br>
>   Sum = 1 + 2 + 4 = 7<br>
>   Result= 8 - 7 = 1

 ## Q2:
>
>For a string, find a prefix with a length greater than 2, and this prefix is one palindrome. <br>
> Then delete this prefix from the string. <br>
> The remaining string repeats the previous operation, knowing that it cannot be performed. <br>
> For example: input: aaaabcbd output: d <br>
> 
> Explanation:
> 
> aaaabcbd -> aaaa is the longest prefix, the length is greater than 2, and it is palindrome, so delete it, the remaining string is bbcd,
> 
> bcbd -> bcb is the longest prefix , length greater than 2, and is Palindrome, so to remove the rest of the string D
> 
> D -> D is Palindrome, but the length is less than 2, it cannot continue to delete
 
 ## Q3:
>  Given an two dimensional array with black and white boxes (like chess) starting with black, and array of queries:
>      Queries: Will have [x,y,w], Means starting from left top (x,y) position till the sub-array of w size.
>          Sort all the black numbers, and white number independently.
>          And replace the actual array with that number in an order.
>

| **1** 	| 2 	| **3** 	| 4 	| **5**
|---	|---	|---	|---	|---
| 5 	| **4** 	| 3 	| **2** 	| 1 
| **4** 	| 3 	| **2** 	| 1 	| **5** 
| 9 	| **6** 	| 7 	| **1** 	| 6
>
>    Query: [1,1,3]: <br>
>      Means for the below sub-array: <br><br>
>              **4** 3 **2** <br>
>              3 **2** 1 <br>
>              **6** 7 **1** <br> <br>
>              **black = [4,2,2,6,1]  sorted = [1,2,2,4,6]      <br>**
>              white = [3,3,1,7]    sorted = [1,3,3,7]        <br>
>   After Sorting the sub-array value becomes as below: <br> <br>
>              **1** 1 **2** <br>
>              3 **2** 3 <br>
>              **4** 7 **6** <br> <br>
>   The input array value in those positions also should be changed.

 ## Q4:
>Given two arrays a, b and queries <br>
>Queries are of two types: <br>
>     1. [0,i,n]  -> set the value at b[i] = n <br>
>     2. [1,x]    -> find the number of pairs that can form a[i] + b[j] == x <br>
>Return the list of values of query 2.