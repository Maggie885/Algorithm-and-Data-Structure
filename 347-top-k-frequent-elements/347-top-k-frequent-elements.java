class Solution{
    public int[] topKFrequent(int[] nums, int k){
        
        Map<Integer,Integer> numFrequencyMap = new HashMap<>();
        
        for(int n:nums){
        numFrequencyMap.put(n,numFrequencyMap.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap 
 = new PriorityQueue<>((e1,e2) -> (e1.getValue()-e2.getValue()));

      for(Map.Entry<Integer,Integer> entry:numFrequencyMap.entrySet()){
          minHeap.add(entry);
          if(minHeap.size()>k) minHeap.poll();
 }
        int[] topNumbers = new int[k];
        
        while(!minHeap.isEmpty()){
            
            for(int i=0;i<k;i++){
                topNumbers[i] = minHeap.poll().getKey();
            }
        }
        
        return topNumbers;

    }
}

