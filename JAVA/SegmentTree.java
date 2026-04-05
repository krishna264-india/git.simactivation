import org.w3c.dom.Node;

public class SegmentTree {
   private int[] tree;
    private int n;
    public SegmentTree(int[] arr){
        this.n=arr.length;
        this.tree=new int[4*n];//add the size
        buildTree(arr,0,0,n-1);
    }
     private void buildTree(int[] arr,int node,int start,int end){

        if(start==end){
            tree[node]=arr[start]; // Leaf node will hold the array element
        }else{
            int mid=(start+end)/2;
            int leftChild=2*node+1;
            int rightChild=2*node+2;
            buildTree(arr,leftChild,start,mid);
            buildTree(arr,rightChild,mid+1,end);
            tree[node]=tree[leftChild]+tree[rightChild];
        }


     }
     public int  query(int L,int R){
        return query(0,0,n-1,L,R);
     }
     private int query(int node,int start,int end,int L,int R){
        if(R<start || L>end){
            return 0;//no overlap
        }
        if(L<=start && R>=end){
            return tree[node];//overlap
        }
        int mid=(start+end)/2;
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        int leftSum=query(leftChild,start,mid,L,R);
        int rightSum=query(rightChild,mid+1,end,L,R);
         // Return the sum of the left and right child
        return leftSum+rightSum;

     }
     public  void update(int index,int value){
        update(0,0,n-1,index,value);
     }
     private void update(int node,int start,int end,int index,int value){
        if(start==end){
            tree[node]=value;
            return;
        }else{
        int mid=(start+end)/2;
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        // Update in left subtree
        if(start<=index && index<=mid){
            update(leftChild,start,mid,index,value);
        }
        else{
            // Update in right subtree
            update(rightChild,mid+1,end,index,value);
        }
        // Recalculate the sum
        tree[node]=tree[rightChild]+tree[leftChild];
     }
    }

     private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval,int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;

        }
    }
    Node root;
    public SegmentTree(int[] arr){
        this.root=constructTree(arr,0,arr.length-1);

    }
    private  Node  constructTree(int[] arr,int start,int end){
        if(start==end){
            Node leaf=new  Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        Node node=new Node(start,end);
        int mid=(start+end)/2;
        node.left=this.constructTree(arr,start,mid);
        node.right=this.constructTree(arr,mid+1,end);
        
        node.data=node.left.data +node.right.data;

        return node;

    }
    public void display(){
        display(this.root);
    }
    private void  display(Node node){
        String str=" ";
        if(node.left!=null){
            str=str+"Interval["+node.left.startInterval+"-"+node.left.endInterval+"] data"+node.left.data+"=>";
        }else{
            str=str+"No leftChild";
        }
        //for current node
        str=str+"Interval"+node.startInterval+"-"+node.endInterval+"<=";

        if(node.right!=null){
            str=str+"Interval["+node.right.startInterval+"-"+node.right.endInterval+"] data"+node.right.data;
        }else{
            str=str+"No rightChild";
        }
        System.out.println(str+"\n");
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
        public int query(int qs,int qe){
            return query(this.root,qs,qe);
        }
        private int query(Node node,int qs,int qe){
            if(node.startInterval>=qs && node.endInterval<=qe){
                return node.data;
            }else if(node.startInterval>qe || node.endInterval <qs){
                return 0;
            }else{
                return this.query(node.left,qs,qe)+this.query(node.right,qs,qe);
            }

        }
        public int update(int index, int val){
            return update(this.root,index,val);
        }
        private int update(Node node,int index,int val){
            if(index>=node.startInterval && index<=node.endInterval){
                if(node==node.startInterval && index==node.endInterval){
                    node.data=val;
                    return node.data;
                }else{
                    int leftAns=update(node.left,index,val);
                    int rightAns=update(node.right,index,val);
                    node.data=leftAns+rightAns;
                    return node.data;
                }
            }
                   return node.data;
        }
    } 

}
