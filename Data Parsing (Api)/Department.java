package com.example.sqlitetask;

public class Department {
    private String dept_id;
    private String dept_name;
    private String faculty_head;

    // Getters and Setters
    public String getDeptId() {
        return dept_id;
    }

    public void setDeptId(String deptId) {
        this.dept_id = deptId;
    }

    public String getDeptName() {
        return dept_name;
    }

    public void setDeptName(String deptName) {
        this.dept_name = deptName;
    }

    public String getFacultyHead() {
        return faculty_head;
    }

    public void setFacultyHead(String facultyHead) {
        this.faculty_head = facultyHead;
    }
}

