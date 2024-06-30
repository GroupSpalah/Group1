package lessons.dao.mysql;

import lessons.dao.DAOFactory;
import lessons.dao.StudentDAO;
import lessons.dao.nosql.NoSQLStudentDAO;

public class MySQLDAoFactory extends DAOFactory {
    @Override
    public StudentDAO getStudentDAO() {
        return new MySQLStudentDAO();
    }
}
