package com.example.sqlitetask;


import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insert sample data
        insertSampleData();
    }

    private void insertSampleData() {
        StudentHelper dbHelper = new StudentHelper(this);

        // Create department instances
        Department csDepartment = new Department();
        csDepartment.setDeptId("CS");
        csDepartment.setDeptName("Computer Science");
        csDepartment.setFacultyHead("Dr. Ali Haider");

        Department eeDepartment = new Department();
        eeDepartment.setDeptId("EE");
        eeDepartment.setDeptName("Electrical Engineering");
        eeDepartment.setFacultyHead("Dr. Maria Khan");

        Department meDepartment = new Department();
        meDepartment.setDeptId("ME");
        meDepartment.setDeptName("Mechanical Engineering");
        meDepartment.setFacultyHead("Dr. Asim Ahmed");

        Department ceDepartment = new Department();
        ceDepartment.setDeptId("CE");
        ceDepartment.setDeptName("Civil Engineering");
        ceDepartment.setFacultyHead("Dr. Umar Farooq");

        // Create student instances and insert them
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setFirstName("Urooj");
        student1.setLastName("Naz");
        student1.setEmail("urooj.naz@example.com");
        student1.setPhone("03123456789");
        student1.setAddress("123 Main St, Karachi");
        student1.setGender("Female");
        student1.setBatch("CS-2019");
        student1.setEnrollmentYear(2019);
        student1.setDepartment(csDepartment);
        dbHelper.insertStudent(student1);

        Student student2 = new Student();
        student2.setStudentId(2);
        student2.setFirstName("Samama");
        student2.setLastName("Satar");
        student2.setEmail("samama.satar@example.com");
        student2.setPhone("03214567890");
        student2.setAddress("456 Park Ave, Karachi");
        student2.setGender("Male");
        student2.setBatch("EE-2019");
        student2.setEnrollmentYear(2019);
        student2.setDepartment(eeDepartment);
        dbHelper.insertStudent(student2);

        Student student3 = new Student();
        student3.setStudentId(3);
        student3.setFirstName("Noor");
        student3.setLastName("Noori");
        student3.setEmail("noor.noori@example.com");
        student3.setPhone("03324567890");
        student3.setAddress("789 Market St, Lahore");
        student3.setGender("Female");
        student3.setBatch("ME-2020");
        student3.setEnrollmentYear(2020);
        student3.setDepartment(meDepartment);
        dbHelper.insertStudent(student3);

        Student student4 = new Student();
        student4.setStudentId(4);
        student4.setFirstName("Sabor");
        student4.setLastName("Khan");
        student4.setEmail("sabor.khan@example.com");
        student4.setPhone("03434567890");
        student4.setAddress("101 Sunset Blvd, Islamabad");
        student4.setGender("Male");
        student4.setBatch("CS-2019");
        student4.setEnrollmentYear(2019);
        student4.setDepartment(csDepartment);
        dbHelper.insertStudent(student4);

        Student student5 = new Student();
        student5.setStudentId(5);
        student5.setFirstName("Rizwan");
        student5.setLastName("Khan");
        student5.setEmail("rizwan.khan@example.com");
        student5.setPhone("03544567890");
        student5.setAddress("202 Mountain Rd, Quetta");
        student5.setGender("Male");
        student5.setBatch("CE-2021");
        student5.setEnrollmentYear(2021);
        student5.setDepartment(ceDepartment);
        dbHelper.insertStudent(student5);
    }
}
