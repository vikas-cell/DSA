class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        for (int num : nums1) s1.add(num);
        for (int num : nums2) s2.add(num);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (int num : s1) {
            if (!s2.contains(num)) ans.get(0).add(num);
        }

        for (int num : s2) {
            if (!s1.contains(num)) ans.get(1).add(num);
        }

        return ans;
    }
}
