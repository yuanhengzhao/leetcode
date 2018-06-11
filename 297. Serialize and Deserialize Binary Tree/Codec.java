public class Codec {

    /* 
    Use Pre-Order Traversal.
    */
    public String serialize(TreeNode root) {
        if (root == null){
            return "null,";
        }
        String str = "";
        str += String.valueOf(root.val) + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        str = '['+ str + ']';
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[", "").replace("]", "");
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for (int i=0; i< values.length; i++){
            queue.offer(values[i]);
                        
        }
        return deserializeFromQueue(queue);
    }
    
    public TreeNode deserializeFromQueue(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("null")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = deserializeFromQueue(queue);
        head.right = deserializeFromQueue(queue);
        return head;
    }
}
