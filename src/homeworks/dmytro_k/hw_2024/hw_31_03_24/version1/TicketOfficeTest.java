package homeworks.dmytro_k.hw_2024.hw_31_03_24.version1;

/**
 * Касса ж/д вокзала.
 * Создать приложение Касса ж/д вокзала.
 * Каждый билет имеет название(в кассе всего билетов может быть 15).
 * "Город отправления - Город прибытия"(String("Kiev-Lviv")). Одинаковых билетов нет(Set).
 * Некоторые пассажиры(потоки) хотят купить билеты с определенными названиями, а некоторые сдать билеты.
 * Покупатели и сдатчики имеют имена(потоки имеют имена).
 * Если билета с определенным названием нет в наличии покупатель ждет пока сдадут билет.
 * Выводить текст - "Билет (название билета) продан".
 * Если билет сдается необходимо опевещать покупателей и
 * выводить текст "Билет (название билета) сдан + имя сдатчика"
 * Если билет куплен - выводить текст "Билет (название билета) куплен + имя покупателя".
 * Работу организовать из консоли.
 * <p>
 * 1 Сдать -> имя
 * 2 Купить -> имя
 */

import java.util.LinkedHashSet;
import java.util.Set;

public class TicketOfficeTest {
    public static void main(String[] args) {

        Set<String> ticketsSet = new LinkedHashSet<>(Set.of("Kiev-Lviv", "Kiev-Odessa", "Kiev-Kharkiv",
                "Kiev-Dnipro", "Kiev-Zaporizhzhia", "Kiev-Ivano-Frankivsk", "Kiev-Chernivtsi", "Kiev-Uzhgorod",
                "Kiev-Vinnytsia", "Kiev-Poltava", "Kiev-Kropyvnytsky", "Kiev-Mariupol", "Kiev-Lutsk", "Kiev-Ternopil",
                "Kiev-Rivne", "Kiev-Kremenchuk"));

        Thread seller1 = new Thread(new Seller(ticketsSet), "Seller1");
        seller1.start();
        Thread buyer1 = new Thread(new Buyer(ticketsSet), "Buyer1");
        buyer1.start();

        Thread seller2 = new Thread(new Seller(ticketsSet), "Seller2");
        seller2.start();
        Thread buyer2 = new Thread(new Buyer(ticketsSet), "Buyer2");
        buyer2.start();

        Thread seller3 = new Thread(new Seller(ticketsSet), "Seller3");
        seller3.start();
        Thread buyer3 = new Thread(new Buyer(ticketsSet), "Buyer3");
        buyer3.start();

        Thread seller4 = new Thread(new Seller(ticketsSet), "Seller4");
        seller4.start();
        Thread buyer4 = new Thread(new Buyer(ticketsSet), "Buyer4");
        buyer4.start();
    }
}
