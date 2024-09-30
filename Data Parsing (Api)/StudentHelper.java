package com.example.sqlitetask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "student_db";
    private static final int DATABASE_VERSION = 1;
    private static final String STU_TABLE_NAME = "student_info";

    private static final String STUDENT_ID = "student_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String ADDRESS = "address";
    private static final String GENDER = "gender";
    private static final String BATCH = "batch";
    private static final String ENROLLMENT_YEAR = "enrollment_year";
    private static final String DEPT_ID = "dept_id";
    private static final String DEPT_NAME = "dept_name";
    private static final String FACULTY_HEAD = "faculty_head";

    public StudentHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String stu_table = "CREATE TABLE " + STU_TABLE_NAME + " ( " +
                STUDENT_ID + " INTEGER PRIMARY KEY, " +
                FIRST_NAME + " TEXT NOT NULL, " +
                LAST_NAME + " TEXT NOT NULL, " +
                EMAIL + " TEXT UNIQUE, " +
                PHONE + " TEXT NOT NULL, " +
                ADDRESS + " TEXT NOT NULL, " +
                GENDER + " TEXT NOT NULL, " +
                BATCH + " TEXT NOT NULL, " +
                ENROLLMENT_YEAR + " INTEGER NOT NULL, " +
                DEPT_ID + " TEXT NOT NULL, " +
                DEPT_NAME + " TEXT NOT NULL, " +
                FACULTY_HEAD + " TEXT NOT NULL" +
                " )";
        db.execSQL(stu_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STU_TABLE_NAME);
        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENT_ID, student.getStudentId());
        contentValues.put(FIRST_NAME, student.getFirstName());
        contentValues.put(LAST_NAME, student.getLastName());
        contentValues.put(EMAIL, student.getEmail());
        contentValues.put(PHONE, student.getPhone());
        contentValues.put(ADDRESS, student.getAddress());
        contentValues.put(GENDER, student.getGender());
        contentValues.put(BATCH, student.getBatch());
        contentValues.put(ENROLLMENT_YEAR, student.getEnrollmentYear());
        contentValues.put(DEPT_ID, student.getDepartment().getDeptId());
        contentValues.put(DEPT_NAME, student.getDepartment().getDeptName());
        contentValues.put(FACULTY_HEAD, student.getDepartment().getFacultyHead());

        long result = db.insert(STU_TABLE_NAME, null, contentValues);
        if (result == -1) {
            Log.d("Database", "Error inserting data");
        } else {
            Log.d("Database", "Data inserted successfully");
        }
    }
}