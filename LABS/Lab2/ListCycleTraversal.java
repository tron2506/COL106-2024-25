class Node<E>{
    E data;
    Node<E> next;
    public Node(){

    }
    public Node(E datapara){
        this.data=datapara;
    }
    
}


public class ListCycleTraversal {

    public static int findMid(Node<Integer> head){
        Node<Integer> cur1=head;
        Node<Integer> cur2=head;
        while(cur2.next!=null || cur2.next.next!=null){
            cur1=cur1.next;
            cur2=cur2.next.next;
        }
        if(cur2.next!=null){
            return cur1.next.data;
        }
        else{
            return cur1.data;
        }
    }

    public static Boolean checkCycle(Node<Integer> head){

        Node<Integer> cur1=head;
        Node<Integer> cur2=head;
        while(true){
            cur1=cur1.next;
            cur2=cur2.next.next;
            if(cur2.next==null || cur2.next.next==null){
                return false;
            }
            if(cur1==cur2){
                return true;
            }
        }

    }
    
    public static Node<Integer> point(Node<Integer> head){
        Node<Integer> cur1=head;
        Node<Integer> cur2=head;
        while(true){
            cur1=cur1.next;
            cur2=cur2.next.next;
            if(cur1==cur2){
                break;
            }
        }
        cur1=head;
        while(true){
            if(cur1==cur2){
                return cur1;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
    }
    
    public static Boolean gridWithArrows(char[][] array, int n){
        int i=0,j=0;
        int a=0,b=0;
        int count=0;
        while(true){
            if(i==n-1 && j==n-1){
                return true;
            }
            if(i==a && j==b){
                count++;
                if(count>1){
                    return false;
                }
            }
            if(array[i][j]=='L'){
                if(j!=0){j--;}
                else{return false;}
            }
            else if(array[i][j]=='R'){
                if(j!=n-1){j++;}
                else{return false;}
            }
            else if(array[i][j]=='U'){
                if(i!=0){i--;}
                else{return false;}
            }
            else{
                if(i!=n-1){i++;}
                else{return false;}
            }
            for(int z=0;z<2;z++){
                if(a==n-1 && b==n-1 ){
                    continue;
                }
                if(array[a][b]=='L'){
                    if(b!=0){b--;}
                    else{return false;}
                }
                else if(array[a][b]=='R'){
                    if(b!=n-1){b++;}
                    else{return false;}
                }
                else if(array[a][b]=='U'){
                    if(a!=0){a--;}
                    else{return false;}
                }
                else{
                    if(a!=n-1){a++;}
                    else{return false;}
                }
            }
        }
    }


    public static void main(String args[]){

        // char[][] grid1 = {
        //     {'R', 'D', 'D'},
        //     {'L', 'D', 'R'},
        //     {'U', 'R', 'R'}
        // };
        // char[][] grid2 = {
        //     {'R', 'R', 'D'},
        //     {'L', 'U', 'L'},
        //     {'U', 'U', 'R'}
        // };
        // char[][] grid3 = {
        //     {'D', 'R'},
        //     {'R', 'R'}
        // };
        // char[][] grid4 = {
        //     {'R', 'R', 'D', 'D'},
        //     {'L', 'D', 'R', 'D'},
        //     {'U', 'L', 'D', 'R'},
        //     {'U', 'U', 'L', 'R'}
        // };
        // char[][] grid5 = {
        //     {'R', 'D', 'L'},
        //     {'U', 'L', 'D'},
        //     {'U', 'U', 'R'}
        // };

        // System.out.println(gridWithArrows(grid5, 3));
        // System.out.println(gridWithArrows(grid4, 4));
        // System.out.println(gridWithArrows(grid3, 2));
        // System.out.println(gridWithArrows(grid2, 3));
        // System.out.println(gridWithArrows(grid1, 3));
    }
}
