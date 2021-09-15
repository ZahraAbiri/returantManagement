package maktab58_HW3_abiri;

import java.util.Arrays;

public class Manager {
    int indexOfDrink;
    int indexOfDinner;
    int indexOfLunch;
    int indexOfCustomer;
    int dinnerCount = 0;
    int dirinkCount = 0;
    int lunchCount = 0;
    private final static double lunchPricePersent = 0.1;
    private final static double dinnerPricePersent = 0.15;
    Dinner[] dinners = new Dinner[10];
    Drinks[] drinks = new Drinks[5];
    Lunch[] lunches = new Lunch[10];
    int[] dinnerOrder = new int[10];
    int[] drinkOrder = new int[5];
    int[] lunchOrder = new int[10];
    Customer[] customers = new Customer[30];

    public Manager() {
        for (int i = 0; i < 5; i++) {
            drinks[i] = new Drinks();
        }
        for (int i = 0; i < 10; i++) {
            dinners[i] = new Dinner();
        }
        for (int i = 0; i < 10; i++) {
            lunches[i] = new Lunch();
        }
        for (int i = 0; i < 30; i++) {
            customers[i] = new Customer();
        }
    }

    public void addDinner(int id, String name, int price, int count) {
        dinners[indexOfDinner].setId(id);
        dinners[indexOfDinner].setName(name);
        dinners[indexOfDinner].setCount(count);
        dinners[indexOfDinner].setPrice(price);
        indexOfDinner++;
        dinnerCount = count;
        for (int i = 0; i < indexOfDinner; i++) {
            System.out.println("id : " + dinners[i].getId() + " name :  " + dinners[i].getName() + " price : " + dinners[i].getPrice() + " count : " + dinners[i].getCount());
        }
    }

    public void addDrink(int id, String name, int price, int count) {
        drinks[indexOfDrink].setId(id);
        drinks[indexOfDrink].setName(name);
        drinks[indexOfDrink].setCount(count);
        drinks[indexOfDrink].setPrice(price);
        indexOfDrink++;
        dirinkCount = count;
        for (int i = 0; i < indexOfDrink; i++) {
            System.out.println(" id : " + drinks[i].getId() + " name : " + drinks[i].getName() + " price : " + drinks[i].getPrice() + " count : " + drinks[i].getCount());
        }
    }

    public void addLunch(int id, String name, int price, int count) {
        lunches[indexOfLunch].setId(id);
        lunches[indexOfLunch].setName(name);
        lunches[indexOfLunch].setCount(count);
        lunches[indexOfLunch].setPrice(price);
        indexOfLunch++;
        lunchCount = count;
        for (int i = 0; i < indexOfLunch; i++) {
            System.out.println(" id : " + lunches[i].getId() + " name : " + lunches[i].getName() + " price : " + lunches[i].getPrice() + " count : " + lunches[i].getCount());
        }
    }

    public void addCustomer(int id, String name, String family, String phoneNumber, String gender) {
        customers[indexOfCustomer].setId(id);
        customers[indexOfCustomer].setName(name);
        customers[indexOfCustomer].setFamily(family);
        customers[indexOfCustomer].setPhoneNumber(phoneNumber);
        customers[indexOfCustomer].setGender(gender);
        indexOfCustomer++;
        for (int i = 0; i < indexOfCustomer; i++) {
            System.out.println(" id : " + customers[i].getId() + " name : " + customers[i].getName() + " family : " + customers[i].getFamily() +
                    " phoneNumber : " + customers[i].getPhoneNumber() + " gender : " + customers[i].getGender());

        }
    }

    public void CustomerInfo() {
        if (indexOfCustomer == 0) {
            System.out.println("we dont have any customer");
        }
        for (int i = 0; i < indexOfCustomer; i++) {

            System.out.println(" customer id [" + i + "]:" + customers[i].getId() +
                    "customer Name[" + i + "]:" + customers[i].getName()
                    + " customer family [" + i + "]:" + customers[i].getFamily()
                    + " phoneNumber[" + i + "]:" + customers[i].getPhoneNumber() +
                    " customer gender [" + i + "]:" + customers[i].getGender());
        }
    }


    public void addNewOrder(int[] order, int[] drink, String status) {//dinner or lunch
        if (status.equalsIgnoreCase("lunch")) {
            if (indexOfLunch == 0) {
                System.out.println("the lunch menu is empty");
            } else {
                for (int i = 0; i < order.length; i++) {
                    lunchOrder[i] = order[i];
                }
                for (int i = 0; i < indexOfLunch; i++) {
                    int countLunch = lunches[i].getCount();
                    if (order[i] == lunches[i].getId()) {
                        lunchCount = countLunch - 1;
                        lunches[i].setCount(lunchCount);
                    }
                    if (lunchCount == 0) {
                        System.out.println(lunches[i].getName() + "is finished");
                    } else {
                        System.out.println(lunches[i].getId() + " ");
                    }
                }
                if (indexOfDrink == 0) {
                    System.out.println("the drink menu is  empty");
                } else {
                    for (int i = 0; i < drink.length; i++) {
                        drinkOrder[i] = drink[i];
                    }
                    for (int i = 0; i < indexOfDrink; i++) {
                        int countDrink = drinks[i].getCount();
                        if (drink[i] == drinks[i].getId()) {
                            dirinkCount = countDrink - 1;
                            drinks[i].setCount(dirinkCount);
                        }
                        if (dinnerCount == 0) {
                            System.out.println(drinks[i].getName() + "  is finished");
                        } else {
                            System.out.println(drinks[i].getId() + "successfully added");
                        }
                    }
                }
            }
        } else {
            if (indexOfDinner == 0) {
                System.out.println("the dinner menu is empty");
            } else {
                for (int i = 0; i < order.length; i++) {
                    dinnerOrder[i] = order[i];
                }
                for (int i = 0; i < indexOfDinner; i++) {
                    int countDinner = dinners[i].getCount();
                    if (order[i] == dinners[i].getId()) {
                        dinnerCount = countDinner - 1;
                        dinners[i].setCount(dinnerCount);
                    }
                    if (dinnerCount == 0) {
                        System.out.println(dinners[i].getName() + "is finished");
                    } else {
                        System.out.print(dinners[i].getId() + " ");
                    }
                }
            }
            if (indexOfDrink == 0) {
                System.out.println("the drink menu is empty");
            } else {
                for (int i = 0; i < drink.length; i++) {
                    drinkOrder[i] = drink[i];
                }
                for (int i = 0; i < indexOfDrink; i++) {
                    int countDrink = drinks[i].getCount();
                    if (drink[i] == drinks[i].getId()) {
                        dirinkCount = countDrink - 1;
                        drinks[i].setCount(dirinkCount);
                    }
                    if (dirinkCount == 0) {
                        System.out.println(drinks[i].getName() + "is finished");
                    } else {
                        System.out.print(drinks[i].getId() + "   successfully added");
                    }
                }
            }
        }
    }

    public void showOrderDetaild(String status) {
        if (indexOfDrink == 0) {
            System.out.println("we dont have any drink");
        }
        for (int i = 0; i < indexOfDrink; i++) {
            System.out.println(" drink id [" + i + "]:" + drinks[i].getId() +
                    "drink Name[" + i + "]:" + drinks[i].getName()
                    + " drink price [" + i + "]:" + drinks[i].getPrice() + " T");
        }
        if (status.equalsIgnoreCase("lunch")) {
            if (indexOfLunch == 0) {
                System.out.println("we dont have any drink");
            }
            for (int i = 0; i < indexOfLunch; i++) {
                double price = (lunches[i].getPrice()) * lunchPricePersent;
                System.out.println(" Lunch id [" + i + "]:" + lunches[i].getId() +
                        "Lunch Name[" + i + "]:" + lunches[i].getName()
                        + " Lunch price [" + i + "]:" + price + " T");
            }
        } else {
            if (indexOfDinner == 0) {
                System.out.println("we dont have any dinner");
            }
            for (int i = 0; i < indexOfDinner; i++) {
                double price = (dinners[i].getPrice()) * dinnerPricePersent;
                System.out.println(" dinner id [" + i + "]:" + dinners[i].getId() +
                        "dinner Name[" + i + "]:" + dinners[i].getName()
                        + " dinner price [" + i + "]:" + price + " T");
            }
        }
    }

    public void cancelOrder(int orderId) {
        int[] newDinnerOrder = new int[9];
        if (orderId >= 120) {
            for (int i = 0, j = 0; i < 10; i++) {
                if (dinnerOrder[i] != orderId) {
                    newDinnerOrder[j++] = dinnerOrder[i];
                }
            }
            for (int i = 0; i < 9; i++) {
                if (newDinnerOrder[i] != 0) {
                    System.out.println(Arrays.toString(newDinnerOrder) + "");
                } else {
                    System.out.println("canceled");
                }
            }
        } else if (orderId >= 130) {
            int[] newDrinkOrder = new int[4];
            for (int i = 0, j = 0; i < 5; i++) {
                if (drinkOrder[i] != orderId) {
                    newDrinkOrder[j++] = drinkOrder[i];
                }
            }
            System.out.println(Arrays.toString(newDrinkOrder) + "");
        } else {
            int[] newLunchOrder = new int[9];
            for (int i = 0, j = 0; i < 10; i++) {
                if (lunchOrder[i] != orderId) {
                    newLunchOrder[j++] = lunchOrder[i];
                }
            }
            System.out.println(Arrays.toString(newLunchOrder) + "");
        }
    }
}
