class main_stack
{
    public static void main(String[] args)
    {
        StringStackImpl stack = new StringStackImpl();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.print("size = ");
        System.out.println(stack.size());
        System.out.println("The top element is " + stack.peek());
        System.out.println("Printing Stack: ");
        stack.printStack(System.out);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.print("size = ");
        System.out.println(stack.size());
        System.out.println("Printing Stack: ");
        stack.printStack(System.out);

        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }


    }
}