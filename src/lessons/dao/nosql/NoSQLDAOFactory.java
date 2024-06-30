package lessons.dao.nosql;

import lessons.dao.DAOFactory;
import lessons.dao.StudentDAO;

public class NoSQLDAOFactory extends DAOFactory {
    @Override
    public StudentDAO getStudentDAO() {
        return new NoSQLStudentDAO();
    }
}
