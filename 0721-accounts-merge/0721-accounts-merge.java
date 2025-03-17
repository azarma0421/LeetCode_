class Solution {
    class UnionFind {
        int[] parant;
        int[] weight;

        public UnionFind(int size) {
            parant = new int[size];
            weight = new int[size];

            for (int i = 0; i < size; i++) {
                parant[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int a) {
            if (parant[a] != a) {
                return find(parant[a]);
            }
            return a;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB)
                return;

            if (weight[rootA] > weight[rootB]) {
                parant[rootB] = rootA;
                weight[rootA]++;
            } else {
                parant[rootA] = rootB;
                weight[rootB]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        Map<String, Integer> mailToId = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for (int j = 1; j < details.size(); j++) {
                String mail = details.get(j);
                if (mailToId.containsKey(mail)) {
                    uf.union(mailToId.get(mail), i);
                } else {
                    mailToId.put(mail, i);
                }
            }
        }

        Map<Integer, List<String>> idToMail = new HashMap<>();
        for (String key : mailToId.keySet()) {
            int root = uf.find(mailToId.get(key));
            if (!idToMail.containsKey(root)) {
                idToMail.put(root, new ArrayList<>());
            }
            idToMail.get(root).add(key);
        }

        List<List<String>> mergeList = new ArrayList<>();

        for (Integer id : idToMail.keySet()) {
            List<String> emails = idToMail.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            mergeList.add(emails);
        }

        return mergeList;
    }
}