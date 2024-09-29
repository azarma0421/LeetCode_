class MedianFinder {

    private PriorityQueue <Integer> large = new PriorityQueue<>();
    private PriorityQueue <Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private boolean odd = false;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(odd){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
        odd = !odd;
    }
    
    public double findMedian() {
        if(odd){
            return large.peek();
        }else{
            return (large.peek() + small.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */