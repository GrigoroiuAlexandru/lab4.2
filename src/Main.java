import java.io.*;
import java.util.*;

class Student {
    String nume;
    String grupa;
    List<Integer> note;

    public Student(String nume, String grupa, List<Integer> note) {
        this.nume = nume;
        this.grupa = grupa;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) &&
                Objects.equals(grupa, student.grupa) &&
                Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, grupa, note);
    }

    @Override
    public String toString() {
        return nume + " " + grupa + " " + note;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> studentMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String nume = parts[0] + " " + parts[1];
                String grupa = parts[2];
                List<Integer> note = new ArrayList<>();
                for (int i = 3; i < parts.length; i++) {
                    note.add(Integer.parseInt(parts[i]));
                }

                Student student = new Student(nume, grupa, note);
                studentMap.put(student, studentMap.getOrDefault(student, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Studentii si numarul de aparitii:");
        for (Map.Entry<Student, Integer> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
