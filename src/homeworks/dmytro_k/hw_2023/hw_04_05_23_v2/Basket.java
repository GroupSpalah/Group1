package homeworks.dmytro_k.hw_2023.hw_04_05_23_v2;

import java.util.LinkedList;
import java.util.List;

//++
public class Basket {
    private LinkedList<Product> items;

    public Basket() {
        items = new LinkedList<>();
    }

    public List<Product> getItems() {
        return items;
    }

    //++
    public void addItem(Product product, ProductService productRange) { //обнуляется ассортимент
        //нужен доступ к ассортименту для обработки
        List<Product> products = productRange.getProducts();

        for (Product item : products) {

            if (item.equals(product) && item.getCount() > 0) {
                items.add(product);
                setQuantity(product);
                return;
            }/* else {
                System.out.println("this item is not available");
            }*/
        }
    }

    //++
    public void setQuantity(Product product) {//добавление в корзину +1 к текущему,
        // если в корзине есть то +1, если нет, то 1

        int count = 0;

        for (Product item : items) {
            if (item.equals(product)) {
                int basketQuantity = item.getCount();
                if (basketQuantity == product.getCount()) {
                    item.setCount(1);
                    count++;
                }
            } else {
                item.setCount(1);
                count++;
            }
        }
    }


    public void removeItem(Product product) {
        for (Product item : items) {
            if (item.equals(product)) {
                int basketQuantity = item.getCount();
                if (basketQuantity > 0) {
                    item.setCount(basketQuantity - 1);
                } else {
                    items.remove(product);
                }
            }
        }
    }

    public void getItemsCount() {

        for (Product item : items) {
            System.out.println(item.getName() + " " + item.getCount());
            System.out.println("---------");
        }
    }
}
