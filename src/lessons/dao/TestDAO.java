package lessons.dao;

public class TestDAO {
    public static void main(String[] args) {
        DAOFactory factory = DAOFactory.getInstance(1);

        StudentDAO studentDAO = factory.getStudentDAO();

        studentDAO.save(null);
    }
}
