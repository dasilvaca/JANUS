package structs;

public class PriorityQueue <T> {
    public PriorityStack<T> orderedStack;
    public PriorityStack<T> transStack;

    public PriorityQueue(){
        this.orderedStack = new PriorityStack<T>();
        this.transStack = new PriorityStack<T>();
    }

    public void add(T data, int prioridad){
        PriorityNode<T> nodo = new PriorityNode<T>(prioridad, data);
        if (orderedStack.isEmptypri() || orderedStack.top.priority < prioridad){
            orderedStack.insert(nodo);
            orderedStack.printpri();
        }
        else{
            PriorityNode <T> current = orderedStack.top;
            while (current.next != null && current.priority > prioridad){
                transStack.insert(current);
                current = current.next;
                orderedStack.poppri();
                
                
            }
            
            orderedStack.insert(nodo);
            current = transStack.top;
            System.out.print("Ordered: ");
            orderedStack.printpri();
            System.out.print("Transition: ");
            transStack.printpri();
            
            while (current != null){
                orderedStack.insert(current);
                
                transStack.poppri();
                current = current.next;
            }
            orderedStack.printpri();
            
        }
        }
    public void print(){
        if (orderedStack.isEmpty()){
            System.out.println("Está vacía la cola :c");
        }
        else{
            PriorityNode <T> current = orderedStack.top;
            while (current.next != null){
                System.out.println(current);
                current = current.next;
            }

        }
    }
}

