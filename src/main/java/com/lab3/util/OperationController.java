package com.lab3.util;

import com.lab3.data.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api")
public class OperationController {
    private Set<Student> students = new HashSet<>();
    private Counting count;


    @Autowired
    OperationController(Counting count) {
        this.count = count;
    }

    @PostMapping("/count")
    public @ResponseBody
    HashMap count(@RequestParam("str") String str) {
        HashMap<String, String> result = new HashMap<>();
        result.put("value", count.count(str));
        return result;
    }

    @GetMapping("/students")
    public @ResponseBody
    Collection<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Map addStudent(@RequestBody Student student) {
        students.add(student);
        return Collections.singletonMap("id", student.getId());
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        students.forEach(s -> {
            if (s.getId() == id) {
                s.setFio(student.getFio());
                s.setGroup(student.getGroup());
                s.setUnName((student.getUnName()));
            }
        });
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        students.removeIf(student -> student.getId() == id);
    }
}