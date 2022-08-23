
class Solution {
public int largestVariance(String s) {
        int maxVariance=0;

        for(int highFreq=0;highFreq<=26;highFreq++){
            for(int lowFreq=0;lowFreq<26;lowFreq++){
              
                if(lowFreq == highFreq)continue;
                int curLow=0,curHigh=0;
                boolean lowCharIgnored = false;
                for(char ch : s.toCharArray()){

                    int freq = ch-'a';
                    if(freq == highFreq) curHigh++;
                    if(freq == lowFreq) curLow++;

                    if(curLow > 0 && curHigh > 0)
                        maxVariance = Math.max(maxVariance,curHigh-curLow);
                    else{

                        if(lowCharIgnored)
                            maxVariance = Math.max(maxVariance,curHigh-1);
                    }

                    if(curLow > curHigh){
                        curHigh = 0;
                        curLow = 0;
                        lowCharIgnored=true;
                    }
                }
            }
        }
        return maxVariance;
    }
}
