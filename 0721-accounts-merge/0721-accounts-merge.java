class Solution {
    class UnionFind {
        int[] parent;
        int[] weight;

        public UnionFind(int size) {
            parent = new int[size];
            weight = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int a) {
            if (parent[a] == a)
                return a;
            return find(parent[a]);
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB)
                return;

            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA]++;
            } else {
                parent[rootA] = rootB;
                weight[rootB]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        Map<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for (int j = 1; j < details.size(); j++) {
                String mail = details.get(j);
                if (emailToId.containsKey(mail)) {
                    uf.union(i, emailToId.get(mail));
                } else {
                    emailToId.put(mail, i);
                }
            }
        }

        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (String key : emailToId.keySet()) {
            int root = uf.find(emailToId.get(key));

            if (!idToEmails.containsKey(root))
                idToEmails.put(root, new ArrayList<>());

            idToEmails.get(root).add(key);
        }

        List<List<String>> mergeDetails = new ArrayList<>();
        for (Integer id : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            mergeDetails.add(emails);
        }

        return mergeDetails;
    }
}