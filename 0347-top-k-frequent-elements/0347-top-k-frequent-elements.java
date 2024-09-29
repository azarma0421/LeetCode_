class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> priorityMap = new HashMap();

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer map1, Integer map2) {
                return priorityMap.get(map1).compareTo(priorityMap.get(map2)) * -1;
            }
        });

        for (int i : nums) {
            if (!priorityMap.containsKey(i)) {
                priorityMap.put(i, 1);
            } else {
                priorityMap.put(i, priorityMap.get(i) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : priorityMap.entrySet()) {
            queue.add(entry.getKey());
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }
}