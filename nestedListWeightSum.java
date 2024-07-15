//https://leetcode.com/problems/nested-list-weight-sum/


Using BFS(Queue)
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        //Tc: O(n) Sc: O(n)
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        
        int depth = 1;
        int ans = 0;

        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i = 0; i < n; i++)
            {
                NestedInteger cur = q.poll();
                if(cur.isInteger())
                {
                    ans += cur.getInteger() * depth;
                }

                else 
                {
                    q.addAll(cur.getList());
                }
            }
            depth++;
        }
        return ans;
    }
}
