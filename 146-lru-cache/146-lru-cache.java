class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    
    public void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;

    }
    
    public void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        
        pre.post = post;
        post.pre = pre;    
    }
    
    public void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    public DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
    
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int count;
    private DLinkedNode head;
    private DLinkedNode tail;
    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            this.cache.put(key,newNode);
            this.addNode(newNode);
            
            ++count;
            
            if(count > capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
             }
            }else{
                node.value = value;
                this.moveToHead(node);
            }
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */