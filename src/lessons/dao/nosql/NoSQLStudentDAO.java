package lessons.dao.nosql;

import lessons.dao.StudentDAO;
import lessons.dao.domain.Student;

public class NoSQLStudentDAO implements StudentDAO {
    @Override
    public void save(Student student) {
        System.out.println("Save to NoSQL database");
    }
}
