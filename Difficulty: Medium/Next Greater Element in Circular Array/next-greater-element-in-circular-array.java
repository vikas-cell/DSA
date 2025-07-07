class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
      int n = arr.length;
      int[] res = new int[n];
      Arrays.fill(res, -1);
      Deque<Integer> st = new ArrayDeque<>();
      for(int i=2*n-1;i>=0;i--){
        int curr = arr[i % n];
        while (!st.isEmpty() && st.peek() <= curr) {
            st.pop();
        }
        if (i < n && !st.isEmpty()) {
            res[i] = st.peek();
        }
        st.push(curr);
    }

    // Convert to ArrayList if needed
    ArrayList<Integer> result = new ArrayList<>(n);
    for (int val : res) result.add(val);
    return result;
    }
}