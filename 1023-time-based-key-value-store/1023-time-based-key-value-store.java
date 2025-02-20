class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";

        TreeMap<Integer, String> treeMap = timeMap.get(key);
        Integer floorKey = treeMap.floorKey(timestamp);
        return floorKey == null ? "" : treeMap.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */