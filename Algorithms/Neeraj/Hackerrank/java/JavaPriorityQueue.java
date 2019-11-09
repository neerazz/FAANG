package java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-priority-queue/problem
 */
public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        List<Student> students = priorities.getStudents(events);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities {
    private java.util.PriorityQueue<Student> students = new java.util.PriorityQueue<Student>();

    public List<Student> getStudents(List<String> events) {
        List<Student> output = new ArrayList<>();
        for (String s : events) {
            if (s.startsWith("ENTER")) {
                String[] split = s.split(" ");
                Student student = new Student(Integer.parseInt(split[3]), split[1], Double.parseDouble(split[2]));
                students.add(student);
            } else {
                students.poll();
            }
        }
        while (!students.isEmpty()) {
            output.add(students.poll());
        }
        return output;
    }
}

class Student implements Comparable<Student> {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        if (this.cgpa != o.cgpa) return Double.compare(o.cgpa, this.cgpa);
        if (this.cgpa == o.cgpa & !java.util.Objects.equals(this.name, o.name)) return this.name.compareTo(o.name);
        else return Integer.compare(this.id, o.id);
    }
}