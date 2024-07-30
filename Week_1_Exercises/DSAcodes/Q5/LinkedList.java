class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search for a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Method to traverse and display all tasks
    public void displayTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Method to delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedList taskList = new LinkedList();
        
        Task task1 = new Task(1, "Design module", "Pending");
        Task task2 = new Task(2, "Implement module", "In Progress");
        Task task3 = new Task(3, "Test module", "Completed");
        
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        
        System.out.println("All Tasks:");
        taskList.displayTasks();
        
        System.out.println("\nSearch for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }
        
        System.out.println("\nDeleting Task with ID 2:");
        taskList.deleteTask(2);
        
        System.out.println("\nAll Tasks after deletion:");
        taskList.displayTasks();
    }
}

