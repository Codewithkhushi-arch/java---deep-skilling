class Student {
    private String name, id, grade;
    public Student(String name, String id, String grade) { this.name = name; this.id = id; this.grade = grade; }
    public String getName() { return name; } public void setName(String name) { this.name = name; }
    public String getId() { return id; } public void setId(String id) { this.id = id; }
    public String getGrade() { return grade; } public void setGrade(String grade) { this.grade = grade; }
}
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("Student: " + name + " | ID: " + id + " | Grade: " + grade);
    }
}
class StudentController {
    private Student model; private StudentView view;
    public StudentController(Student model, StudentView view) { this.model = model; this.view = view; }
    public void setStudentName(String name) { model.setName(name); }
    public void updateView() { view.displayStudentDetails(model.getName(), model.getId(), model.getGrade()); }
}
public class MVCPatternExample {
    public static void main(String[] args) {
        Student model = new Student("John", "101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("John Doe");
        controller.updateView();
    }
}

/*
Output:
Student: John | ID: 101 | Grade: A
Student: John Doe | ID: 101 | Grade: A
*/
