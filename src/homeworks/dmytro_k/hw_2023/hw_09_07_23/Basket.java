package homeworks.dmytro_k.hw_2023.hw_09_07_23;

import java.util.LinkedList;
import java.util.List;

//++
public class Basket {
    private LinkedList<Product> items;
    private float sum = 0;

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
        Operable summable = ((a, b) -> a + b);

        for (Product item : products) {

            if (item.equals(product) && item.getCount() > 0) {
                items.add(product);
                setQuantity(product);
                sum = summable.operation(sum, item.getPrice());
                System.out.println("Amount of items in the cart: " + sum);
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

        int basketQuantity = 0;
        Operable subtractable = ((a, b) -> a - b);

        for (Product item : items) {
            if (item.equals(product)) {
                basketQuantity = item.getCount();
                if (basketQuantity > 0) {
                    int newBasketQuantity = basketQuantity - 1;
                    item.setCount(newBasketQuantity);
                    sum = subtractable.operation(sum, product.getPrice());
                    if (newBasketQuantity == 0) {
                        items.remove(product);
                    }
                }
                System.out.println("Amount of items in the cart: " + sum);
            }
        }
    }

    public void getItemsCount() {

        for (Product item : items) {
            System.out.println(item.getName() + " " + item.getCount());
            System.out.println("---------");
        }
    }

    public float calculateSum(float price) {

        float sum = 0;

        Operable summable = ((a, b) -> a + b);

        sum = summable.operation(sum, price);

        return sum;
    }
}
