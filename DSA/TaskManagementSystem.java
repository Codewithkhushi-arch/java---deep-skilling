class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Task head = null;

    public void add(Task newTask) {
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public Task search(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void traverse() {
        Task temp = head;
        while (temp != null) {
            System.out.println("[" + temp.taskId + "] " + temp.taskName + " - " + temp.status);
            temp = temp.next;
        }
    }

    public void delete(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            head = head.next;
            return;
        }
        Task temp = head;
        while (temp.next != null && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        tms.add(new Task(1, "Design DB", "Done"));
        tms.add(new Task(2, "Develop API", "In Progress"));
        
        System.out.println("All Tasks:");
        tms.traverse();
        
        System.out.println("\nSearch for Task 2:");
        Task t = tms.search(2);
        if (t != null) {
            System.out.println("Found: " + t.taskName + " - " + t.status);
        }
        
        System.out.println("\nDeleting Task 1:");
        tms.delete(1);
        tms.traverse();
    }
}
/*
Output:
All Tasks:
[1] Design DB - Done
[2] Develop API - In Progress

Search for Task 2:
Found: Develop API - In Progress

Deleting Task 1:
[2] Develop API - In Progress
*/
