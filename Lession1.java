/** 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(target - nums[i])){
                ret[0] = m.get(target - nums[i]);
                ret[1] = i;
                break;
            }else{
                m.put(nums[i],i);
            }
        }
        return ret;
    }
}