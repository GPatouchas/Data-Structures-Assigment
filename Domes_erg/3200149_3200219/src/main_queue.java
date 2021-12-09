class main_queue {
    public static void main(String[] args) {
        IntQueueImpl queue = new IntQueueImpl();
        queue.put(true);
        queue.put(1);
        queue.put("tomato");
        System.out.print("size = ");
        System.out.println(queue.size());
        System.out.println("The oldest element is " + queue.peek());
        System.out.println("Printing Queue: ");
        queue.printQueue(System.out);
        queue.get();
        queue.get();
        queue.get();
        queue.put(1);
        System.out.print("size = ");
        System.out.println(queue.size());
        queue.get();
        System.out.print("size = ");
        System.out.println(queue.size());
        System.out.println("Printing Queue: ");
        queue.printQueue(System.out);

        if (queue.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }



    }
}