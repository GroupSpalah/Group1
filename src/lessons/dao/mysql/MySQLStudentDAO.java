package lessons.dao.mysql;

import lessons.dao.StudentDAO;
import lessons.dao.domain.Student;

public class MySQLStudentDAO implements StudentDAO {
    @Override
    public void save(Student student) {
        System.out.println("Save to MySQL database");
    }
}
