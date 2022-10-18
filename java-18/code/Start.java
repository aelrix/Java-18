class Start{
    public static void main(String[]data){
        int[] a = { 8, 3, 5, 2, 1, 7, 4, 1, 3};
        Platform p = new Platform();
        Element head = p.create(a);
        head = p.sort(head);
        p.print(head);
    }
}

class Platform {
    Element sort(Element head){
        if (head == null) return null;      // not element
        if (head.next == null) return head; // one element
        
        Element back = cut(head);
        head = sort(head);
        back = sort(back);
        return merge(head, back);
    }
    
    Element merge(Element a, Element b){
        if (a == null && b == null) return null;
        if (a != null && b == null) return b;
        if (a == null && b != null) return a;
        // if (a != null && b != null) { }
        if (a.value < b.value) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
    Element cut(Element e){
        if (e == null) return null;
        if (e.next == null) return null;
        if (e.next.next == null) {
            Element back = e.next;
            e.next = null;
            return back;
        }
        Element fast = e,  slow = e;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Element back = slow.next;
        slow.next = null; //cut
        return back;
    }
    
    void print(Element e) {
        for (Element current = e; current != null; current = current.next){
            System.out.println(current.value);
        }
    }
    
    Element create(int[] a){
        if (a.length == 0) return null;
        Element head = new Element();
        head.value = a[0];
        Element tail = head;
        for (int i = 1; i < a.length; i++) {
            Element e = new Element();
            e.value = a[i];
            tail.next = e;
            tail = tail.next;
        }
        return head;
    }
}

class Element{
    int value;
    Element next;
}



/*
class Show {
    public static void main(String[]data){
     //int[] a = { 71, 80, 72, 38, 45, 63, 12, 80, 99 };
        int[] a = new int[10000];
        for (int i = 0; i < a.length; i++)
            a[i] = (int)(Math.random() * 100000);
        Engine engine = new Engine();
        engine.sort(a);
        boolean flag = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                flag = false;
            }
        }
        System.out.println(flag);
    }
}



class Engine {
    void sort(int[] a){
        sort(a, 0, a.length - 1);
    }
    //Dijkstra's Partition
    void sort(int[] a, int left, int right){
        if(left >= right) return;
        //pivot locaated on the right hand side
        int pivot = a[right]; //random is better
        int lower = left, upper = right - 1;
        int i = left;
        while (i <= upper) {
            int compare = a[i] - pivot; // Three-Way comparison
            
            //this element is less than pivot
            if (compare < 0) {
                int t = a[lower]; //exchange a[i] and a[lower]
                a[lower] = a[i];
                a[i] = t;
                lower++;
                i++; //compete
            }
            //this element is equal to pivot
            if (compare == 0) { i++;  // completed }
            //this element is greater than pivot
            if (compare > 0) {
                int t = a[upper]; //exchange a[i] and a[upper]
                a[upper] = a[i];
                a[i] = t;
                upper--; // not completed, don't i++
                
            }
        }
        // exchange a[lower + 1] and a [right]
        int t = a[lower];
        a[lower] = a[right];
        a[right] = t;
        // ------- pppppp =========
        sort(a, left, lower -1);
        sort(a, upper + 1, right);
    }
}
*/