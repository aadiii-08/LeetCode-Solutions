class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        divide(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public void divide(int[] nums, int left, int right, int[] temp) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;

        divide(nums, left, mid, temp);
        divide(nums, mid + 1, right, temp);
        // Already sorted, no need to merge
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, left, mid, right, temp);
    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        while (j <= right) {
            nums[k++] = temp[j++];
        }
    }
}