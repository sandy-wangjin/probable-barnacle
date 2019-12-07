package singlelinklist;


import java.util.LinkedList;

//节点 -》 链表
class Node{

    private int data;

    private Node next;

    public Node(){

    }

    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

    //public protected dafaut private

    public int getDate(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class SingleLinkList {

    private Node first = null;

    int size = 0;

    private Node last = null;

    public void add(int data){
        Node n = new Node(data,null);
        if(first == null){
            first = last = n;
        }else{
            last.setNext(n);
            last = n;
        }
        size++;
    }

    public void addFirst(int data){
        Node node = new Node(data,null);

        if(first == null) {
            first = last = node;
        }else{
            node.setNext(first);
            first = node;
        }
        size++;
    }

    public void addIndex(int index,int data){
        if(index < 0 || index > size){
            System.out.println("索引非法！");
            return;
        }
        if(index == 0){//html css js
            addFirst(data);
        }else if(index == size){
            add(data);
        }else{
            Node node = new Node(data,null);
            Node prev = getIndexNode(index-1);
            node.setNext(prev.getNext());
            prev.setNext(node);
            size++;
        }
    }

    private Node getIndexNode(int index){
        /*Node n = first;
        for(int i = 1;i<=index;i++){
            n = n.getNext();
        }
        return n;*/

        Node n = first;
        for(int i=0;n != null&&i<index;n=n.getNext(),i++);
        return n;
    }

    public void print(){
        for(Node n = first;n != null;n = n.getNext()){
            System.out.print(n.getData()+" ");
        }
        System.out.println();
    }

    public void update(int index,int data){
        if(index < 0 || index >= size){
            System.out.println("索引非法！");
            return;
        }
        getIndexNode(index).setData(data);
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            System.out.println("索引非法！");
            return;
        }
        if(index == 0){
            Node second = first.getNext();
            first.setNext(null);
            first = second;
        }else if(index == size-1){
            Node temp = getIndexNode(index-1);
            temp.setNext(null);
            last = temp;
        }else{
            Node prev = getIndexNode(index-1);
            Node my = prev.getNext();
            prev.setNext(my.getNext());
            my.setNext(null);
        }
        size--;
    }

    public static void main(String[] args) {
        SingleLinkList sll = new SingleLinkList();
        sll.add(0);
        sll.add(1);
        sll.add(3);
        sll.add(4);
        sll.addIndex(2,2);
        System.out.println(sll.size);
        //System.out.println(sll.getIndexNode(2).getData());

        sll.update(0,10);
        sll.update(2,12);
        sll.update(4,14);

        sll.remove(0);
        System.out.println(sll.size);
        sll.remove(3);

        sll.remove(1);

        sll.print();

    }


}


