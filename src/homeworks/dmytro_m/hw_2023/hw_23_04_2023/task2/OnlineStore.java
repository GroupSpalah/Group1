package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task2;

import java.util.ArrayList;

public class OnlineStore {
    private ArrayList<MobilePhone> mobilePhones;
    private ArrayList<MobileTablet> mobileTablets;
    private ArrayList<TV> tvs;

    public OnlineStore(ArrayList<MobilePhone> mobilePhones, ArrayList<MobileTablet> mobileTablets, ArrayList<TV> tvs) {
        this.mobilePhones = mobilePhones;
        this.mobileTablets = mobileTablets;
        this.tvs = tvs;
    }

    public void addMobilePhone(MobilePhone mobilePhone) {
        mobilePhones.add(mobilePhone);
    }
    public void addMobileTablet(MobileTablet mobileTablet) {
        mobileTablets.add(mobileTablet);
    }
    public void addTvs(TV tv) {
        tvs.add(tv);
    }
}
//        2) Создать приложение интернет - магазина(консольное). Приложение должен выполнять следующие операции:
//
//        1) добавление товара(название, производитель, дата производства и т.д.).
//        2) добавление сопутствующих товаров.
//        3) удаление товара с сопутствующими товарами.
//        4) выбор товара по определенным критериям и после выводить сопутствующие товары.
//
//        Учесть, что каждого товара определенное количество в магазине.
//
//        Примеры товаров: мобильные телефоны, телевизоры и т.д.
//
//        Создать классы без логики, только поля