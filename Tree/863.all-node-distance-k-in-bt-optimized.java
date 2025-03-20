class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution{
     //Optimized Solution
     public int rootToNodePath(TreeNode root, TreeNode node,int k, List<Integer> ans ){
        if(root == null) return -1;

        if(root == node){
            printKDown(root,k,null,ans);
            return 1;
        }
        int lans=rootToNodePath(root.left,node,k,ans);
        if(lans!=-1){
            printKDown(root,k-lans,root.left,ans);
            return lans+1;
        }
        int rans=rootToNodePath(root.right,node,k,ans);
        if(rans!=-1){
            printKDown(root,k-rans,root.right,ans);
            return rans+1;
        }
        return -1;
    }

    public void printKDown(TreeNode node, int depth, TreeNode block, List<Integer> ans){
        if(node == null || depth < 0 || node == block) return;
        if(depth == 0){
            ans.add(node.val);
            return;
        }

        printKDown(node.left, depth-1, block, ans);
        printKDown(node.right, depth-1, block, ans);

    }

    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {


        List<Integer> ans = new ArrayList<>();

        rootToNodePath(root,target,k,ans);
        return ans;
        
    }
}
