package col_106.ProjectsInJava;
/* code is still incomplete 1.) how to move the cursor to add text at the beginning of file. etc. */
class Node{
    Node next=null;
    Node prev=null;
    Character data;
    public Node(){}
    public void setNext(Node nextpara){
        this.next=nextpara;
    }
    public void setPrev(Node prevpara){
        this.prev=prevpara;
    }
    public void setData(Character datapara){
        this.data=datapara;
    } 
}
class File{
    public String fileName;
    public Node head;
    public Node tail;
    public Node cursor;
    public int size=0;
    public File(String fileNamepara){
        head=null;
        tail=null;
        cursor=head;
        fileName=fileNamepara;
    }
    public void writeinFile(Character txt){
        Node temp=new Node();
        temp.setData(txt);
        if(size==0){
            head=temp;
            head.prev=null;
            head.next=null;
            tail=head;
            cursor=head;
        }
        else{
            if(cursor==tail){
                cursor.next=temp;
                temp.next=null;
                temp.prev=cursor;
                cursor=temp;
                tail=temp;
            }
            else{
                cursor.next.prev=temp;
                temp.next=cursor.next;
                temp.prev=cursor;
                cursor.next=temp;
                cursor=temp;
            }
        }
        size++;
    }
    public void deleteinFile(int k){
        for(int i=0;i<k;i++){
            if(cursor)
            cursor.next.prev=cursor.prev;
            cursor.prev.next=cursor.next;
        }
    }
    
}
public class VSCodeEditor {
    public void createFile(String filename){

    }
    public void write(Character txt){
        
    }
    public void delete(int k){

    }
}
