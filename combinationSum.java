// Time complexity: 0(3^n)
// Space complexity: o(1)
// Did it run on leetcode: yes

//  Whole idea behind backtracking:
// backtracking is a dumb approach where all combinatons of numbers are tried out, even when the the sum of array value reaches beyond the target,
// which means we try out every combinations of numbers in the array

// Idea: Start from the 1st number in the list and subtract the value from the target value, 
// as you backtrack through the elements in the innerlist till you reach the final element.

// In the process of backtracking, if you find the target value to be zero, add the innerlist to the final list, and continue to backtrack


class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        backtrack(finalList, new ArrayList<Integer>(), candidates, target, 0);
        return finalList;
    }
    
    public void backtrack(List<List<Integer>> finalList, List<Integer> innerList, int[] candidates, int target, int start) {
        if(target<0) return;
        else if (target == 0) finalList.add(new ArrayList<>(innerList));
        else {
        for(int i=start; i<candidates.length;i++) {
            innerList.add(candidates[i]);
            backtrack(finalList, innerList, candidates, target-candidates[i], i);
            innerList.remove(innerList.size() - 1);
        }
      }    
        
    }
}