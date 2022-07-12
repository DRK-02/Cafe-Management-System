class DoubleLinkedList {
    public class Node {
        public String value;
        public Node next;
        public Node prev;

        public Node(String data) {
            this.value = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(String value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.prev;
        } else {
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node current = head;

        while (current != null) {
            sb.append(current.value);

            if (current.next != null) {
                sb.append(", ");
            }

            current = current.next;
        }

        return sb.toString();
    }
}

class LinkedList {
    public String[] list;
    public int size;
    
    public LinkedList() {
        list = new String[100];
        size = 0;
    }
    
    public void add(String value) {
        if (size == list.length) {
            String[] temp = new String[list.length * 2];

            for (int i = 0; i < list.length; i++) 
                temp[i] = list[i];
            
            list = temp;
        }

        list[size] = value;
        size++;
    }
    
    public void remove(int index) {
        if (index < 0 || index >= size) 
            throw new IndexOutOfBoundsException();
        
        for (int i = index; i < size - 1; i++) 
            list[i] = list[i + 1];
        
        size--;
    }
    
    public String get(int index) {
        if (index < 0 || index >= size) 
            throw new IndexOutOfBoundsException();
        
        return list[index];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        size = 0;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(list[i]);

            if (i != size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

class Queue {
    public int[] queue;
    public int front;
    public int rear;
    public int size;
    public int maxSize;
    
    public Queue(int size) {
        this.maxSize = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    public void enqueue(int item) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % maxSize;
        queue[rear] = item;
        size++;
    }
    
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int item = queue[front];
        front = (front + 1) % maxSize;
        size--;
        return item;
    }
    
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getMaxSize() {
        return maxSize;
    }
    
    public void printQueue() {
        System.out.println("Queue: ");
        for(int i = 0; i < size; i++) {
            System.out.print(queue[(i + front) % maxSize] + " ");
        }
        System.out.println();
    }
}

class Stack {
    public String[] stack;
    public int top;
    public int size;

    public Stack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    public void push(String data) {
        if(top == size - 1) {
            System.out.println("Stack is full");
        }

        else {
            top++;
            stack[top] = data;
        }
    }

    public String pop() {
        if(top == -1) {
            System.out.println("Stack is empty");
            return "-1";
        }

        else {
            String data = stack[top];
            top--;
            return data;
        }
    }

    public String peek() {
        if(top == -1) {
            System.out.println("Stack is empty");
            return "-1";
        }

        else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isFull() {
        if(top == size - 1) {
            return true;
        }
        
        else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }
}
