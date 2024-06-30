package lessons.dao;

import lessons.dao.mysql.MySQLDAoFactory;
import lessons.dao.nosql.NoSQLDAOFactory;

public abstract class DAOFactory {

    public abstract StudentDAO getStudentDAO();

    public static DAOFactory getInstance(int id) {
        return switch (id) {
            case 1 -> new MySQLDAoFactory();
            case 2 -> new NoSQLDAOFactory();
            default -> new NoSQLDAOFactory();
        };
    }
}
