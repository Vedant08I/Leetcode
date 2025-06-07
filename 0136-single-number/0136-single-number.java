class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1; // should never happen
    }
}