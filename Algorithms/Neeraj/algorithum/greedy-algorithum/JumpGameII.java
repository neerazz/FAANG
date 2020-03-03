import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    public static int jump(int[] nums) {
        int[] distances = new int[nums.length];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[0] = 0;
        for(int i=0; i < nums.length ; i++){
            int canJump = nums[i];
            for(int j= i+1; j <= i+canJump && j < nums.length; j++){
                if(distances[i]+j < distances[j]){
                    distances[j] = distances[i]+1;
                }
            }
        }
        return distances[nums.length-1];
    }
}
