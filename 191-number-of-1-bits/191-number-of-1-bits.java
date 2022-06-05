class Solution{
    public int hammingWeight(int n){
        //Time: O(1)
        //Space: O(1)
        int bitcount = 0;
        int mask = 1;
        
        for(int i=0; i<32; i++){
            if((mask & n) != 0) bitcount++;
            mask <<= 1;
        }
        return bitcount;
    }
}