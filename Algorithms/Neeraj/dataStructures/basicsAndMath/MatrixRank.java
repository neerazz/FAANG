/*
Find the rank of a 3*3 matrix.
Example:
INPUT:  2 4 3
        1 0 3
        9 6 8
OUTPUT: 3
*/

class MatrixRank {
public static void main (String[] args) throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int arr[][] = new int[3][3];
int flag = 0, k = 0;
	    
String inputLine1 = br.readLine().trim();
String inputLine2 = br.readLine().trim();
String inputLine3 = br.readLine().trim();
String[] inputLine =(inputLine1 +" "+ inputLine2 +" "+ inputLine3).trim().split(" ");
	    
    for(int i = 0; i < 3; i++)
    for(int j = 0; j < 3; j++)
    {
        arr[i][j] = Integer.parseInt(inputLine[k++]);
	    if(arr[i][j] == 0) flag++;
    }
    if(flag == 9)
    System.out.println(1);
    System.out.println(getRank(arr));
}
static int getRank(int arr[][])
{
    int x, y, z, det, p, q, r, s;
	    x = arr[0][0]*(arr[1][1]*arr[2][2] - arr[1][2]*arr[2][1]);
	    y = arr[0][1]*(arr[1][0]*arr[2][2] - arr[1][2]*arr[2][0]);
	    z = arr[0][2]*(arr[1][0]*arr[2][1] - arr[1][1]*arr[2][0]);
	    det = x - y + z;
	    if(det != 0)
	    return 3;
	    else{
	        p = arr[0][0]*arr[1][1] - arr[0][1]*arr[1][0];
	        q = arr[0][1]*arr[1][2] - arr[0][2]*arr[1][1];
	        r = arr[1][0]*arr[2][1] - arr[1][1]*arr[2][0];
	        s = arr[1][1]*arr[2][2] - arr[2][2]*arr[2][1];
	        
	        if(p != 0 || q != 0 || r != 0 || s != 0)
	        return 2;
	    }
	    return 1;
}
}