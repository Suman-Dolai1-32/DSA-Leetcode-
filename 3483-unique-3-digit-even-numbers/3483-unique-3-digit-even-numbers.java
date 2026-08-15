class Solution {

    public int totalNumbers(int[] digits) {

        boolean[] used = new boolean[digits.length];

        HashSet<Integer> set = new HashSet<>();

        backtrack(digits, used, 0, 0, set);

        return set.size();
    }


    private void backtrack(int[] digits, boolean[] used,
                           int num, int count,
                           HashSet<Integer> set) {


        if(count == 3) {

            if(num % 2 == 0)
                set.add(num);

            return;
        }


        for(int i = 0; i < digits.length; i++) {

            if(used[i])
                continue;


            // first digit cannot be zero
            if(count == 0 && digits[i] == 0)
                continue;


            used[i] = true;

            backtrack(
                digits,
                used,
                num * 10 + digits[i],
                count + 1,
                set
            );

            used[i] = false;
        }
    }
}