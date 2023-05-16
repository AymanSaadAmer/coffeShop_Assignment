import java.util.ArrayList;
import java.util.Scanner;

class CoffeeShop {
    String name;
    ArrayList<MenuItem> menu;
    ArrayList<String> orders;

    public CoffeeShop(String name, ArrayList<MenuItem> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<String>();
    }
// addOrder method
    public String addOrder(String item) {
        for (MenuItem menuItem : menu) {
            if (menuItem.item.equalsIgnoreCase(item)) {
                orders.add(item);
                return "Order added";
            }
        }
        return "This item is currently unavailable";
    }
//FulfillOrder method
    public String fulfillOrder() {
        if (!orders.isEmpty()) {
            String item = orders.get(0);
            orders.remove(0);
            return "The " + item + " is ready";
        } else {
            return "All orders have been fulfilled";
        }
    }

    public ArrayList<String> listOrders() {
        return orders;
    }
    // dueAmount Methods
    public double dueAmount() {
        double total = 0.0;
        for (String order : orders) {
            for (MenuItem menuItem : menu) {
                if (menuItem.item.equalsIgnoreCase(order)) {
                    total += menuItem.price;
                }
            }
        }
        return total;
    }
//the  cheapest method
    public String lowest_item_in_price() {
        double minPrice = Double.MAX_VALUE;
        String cheapest = "";
        for (MenuItem menuItem : menu) {
            if (menuItem.price < minPrice) {
                minPrice = menuItem.price;
                cheapest = menuItem.item;
            }
        }
        return cheapest;
    }

    public ArrayList<String> drinksOnly() {
        ArrayList<String> drinkList = new ArrayList<String>();
        for (MenuItem menuItem : menu) {
            if (menuItem.type.equalsIgnoreCase("drink")) {
                drinkList.add(menuItem.item);
            }
        }
        return drinkList;
    }

    public ArrayList<String> foodOnly() {
        ArrayList<String> foodList = new ArrayList<String>();
        for (MenuItem menuItem : menu) {
            if (menuItem.type.equalsIgnoreCase("food")) {
                foodList.add(menuItem.item);
            }
        }
        return foodList;
    }
}
class MenuItem {
    String item;
    String type;
    double price;

    public MenuItem(String item, String type, double price) {
        this.item = item;
        this.type = type;
        this.price = price;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Ayman Amer  coffee shop ");
        //the MenuItem
        ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem("tea", "Drink", 4.50));
        menu.add(new MenuItem("Manga juice", "Drink", 20.0));
        menu.add(new MenuItem("apple juice", "Drink", 30.0));
        menu.add(new MenuItem("banana juice ", "Drink", 40.0));
        menu.add(new MenuItem("Lactel juice", "Drink", 15.0));
        menu.add(new MenuItem("Strawberry juice", "Drink", 30.0));
        menu.add(new MenuItem("Pepsi", "Drink", 15));
        menu.add(new MenuItem("cola", "Drink", 15));
        menu.add(new MenuItem("Cappuccino", "Drink", 35.00));
        menu.add(new MenuItem("Espresso", "Drink", 60.00));
        menu.add(new MenuItem("Croissant", "Food", 30.00));
        menu.add(new MenuItem("Bagel", "Food", 40.00));
        menu.add(new MenuItem("pizza", "Food", 75));
        menu.add(new MenuItem("rice", "Food", 35));

        CoffeeShop coffeeShop = new CoffeeShop("My Coffee Shop", menu);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your order or 'exit' ");
            String order = scanner.nextLine();
            if (order.equalsIgnoreCase("exit")) {
                break;
            }
            String response = coffeeShop.addOrder(order);
            System.out.println(response);
        }

        System.out.println(coffeeShop.listOrders());

        System.out.println("lowest item in price : " + coffeeShop.lowest_item_in_price());

        System.out.println("Total price: " + coffeeShop.dueAmount());

    }
}