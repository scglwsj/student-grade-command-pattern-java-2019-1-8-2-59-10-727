package com.tw.domain.students;

import java.util.Objects;

public class StudentId {
    private String id;

    public StudentId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentId studentId = (StudentId) o;
        return Objects.equals(id, studentId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
