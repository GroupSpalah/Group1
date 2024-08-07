package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24;

import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.ModificationDao;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.ExtractorDao;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.impl.ModificationDaoImpl;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.impl.ExtractorDaoImpl;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConnectionUtil;

import java.sql.SQLException;

/**
 * Задача
 * В задании необходимо выполнить следующие действия:
 * ++• организацию соединения с базой данных вынести в отдельный класс, метод которого возвращает соединение;
 * ++• создать БД. Привести таблицы к одной из нормальных форм;
 * (sql)
 * • создать класс для выполнения запросов на извлечение информации из БД с использованием компилированных запросов;
 * • создать класс на модификацию информации.
 * * (impl)
 * <p>
 * ++Заказ. В БД хранится информация о заказах магазина и товарах в них.
 * Для заказа необходимо хранить:
 * • номер заказа;
 * • товары в заказе;
 * • дату поступления.
 * ++Для товаров в заказе необходимо хранить:
 * • товар;
 * • количество.
 * ++Для товара необходимо хранить:
 * • название;
 * • описание;
 * • цену.
 * <p>
 * ++• Вывести полную информацию о заданном заказе.
 * ++• Вывести номера заказов, сумма которых не превосходит заданную, и количество различных товаров равно заданному.
 * ++• Вывести номера заказов, содержащих заданный товар.
 * ++• Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня.
 * +- test• Сформировать новый заказ, состоящий из товаров, заказанных в текущий день.
 * +- test• Удалить все заказы, в которых присутствует заданное количество заданного товара.
 * (CONST)
 */

public class OrderApp {
    public static void main(String[] args) throws SQLException {

        ModificationDao modificationDao = new ModificationDaoImpl();
        ExtractorDao extractorDao = new ExtractorDaoImpl();

        System.out.println(extractorDao.getOrderDetails(4));
        System.out.println(extractorDao.getOrdersContainingProduct(6));
        System.out.println(extractorDao.getOrdersBySumAndProductCount(500, 2));
        System.out.println(extractorDao.getOrdersNotContainingProductToday(7));

        modificationDao.deleteOrdersByProductQuantity(60, 2);
        modificationDao.createOrderFromToday();

        ConnectionUtil.disconnect();
    }
}
