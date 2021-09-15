package maktab58_HW3_abiri;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Resturant {
    static Scanner input = new Scanner(System.in);
    static int choices = 0;
    static boolean choice = false;

    public static void welcome() {
        System.out.println("************Welcome to resturant system****************");
        System.out.println("1.login as manager\n2.login as customer\n3.Exit");
        System.out.println("Select a Choice:");
    }

    public static int paternId() {
        int idFood = 0;
        Pattern patternId = Pattern.compile("[A-Za-z]{0}[0-9]+");
        String foodId = input.next();
        Matcher matcherId = patternId.matcher(foodId);
        if (matcherId.find()) {
            idFood = (int) Long.parseLong((matcherId.group()));
        }
        return idFood;
    }

    public static int paternCount() {
        int count = 0;
        Pattern patternCount = Pattern.compile("[A-Za-z]{0}[0-9]+");
        String foodCount = input.next();
        Matcher matcherCount = patternCount.matcher(foodCount);
        if (matcherCount.find()) {
            count = (int) Long.parseLong((matcherCount.group()));
        }
        return count;
    }

    public static int paternPrice() {
        int price = 0;
        Pattern patternPrice = Pattern.compile("[A-Za-z]{0}[0-9]+");
        String foodPrice = input.next();
        Matcher matcherPrice = patternPrice.matcher(foodPrice);
        if (matcherPrice.find()) {
            price = (int) Long.parseLong((matcherPrice.group()));
        }
        return price;
    }

    public static String paternName() {
        Pattern patternName = Pattern.compile("[0-9]{0}[A-Za-z]+");
        String name = input.next();
        Matcher matcherName = patternName.matcher(name);
        if (matcherName.find()) {
            name = (matcherName.group());
        }
        return name;
    }

    public static String paternPhone() {
        Pattern patternName = Pattern.compile("[0-9]{11}[A-Za-z]{0}");
        String name = input.next();
        Matcher matcherName = patternName.matcher(name);
        if (matcherName.find()) {
            name = (matcherName.group());
        }
        return name;
    }

    public static int chekChoice() {
        do {
            while (!input.hasNextInt()) {
                System.out.println("That's not a number! \n Enter number");
                input.next();
            }
            choices = input.nextInt();
            choice = true;
        } while (choice == false);
        choice = false;
        return choices;
    }

    private static void customerOrders(Manager manager, String status) {
        System.out.println("you can enter max 10 item from lunch/dinner");
        System.out.println("enter the number of your order");
        int countFood = input.nextInt();
        int dinner[] = new int[countFood];
        for (int i = 0; i < countFood; i++) {
            System.out.println("enter the id of your order");
            dinner[i] = input.nextInt();
        }
        System.out.println("you can enter just 5 item from drink menu");
        System.out.println("enter the number of your order");
        int drinkCount = input.nextInt();
        int drink[] = new int[drinkCount];
        for (int i = 0; i < drinkCount; i++) {
            System.out.println("enter the id of your order");
            drink[i] = input.nextInt();
        }
        manager.addNewOrder(dinner, drink, status);
    }

    public static void main(String[] args) {

        Manager manager = new Manager();
        boolean backToMainMenue = false;
        int customerChoice;
        int manegerChoice;
        do {
            welcome();
            System.out.println("enter choice");
            if (chekChoice() == 1) {
                do {
                    System.out.println("************Manager Menu****************");
                    System.out.println("1.Add to dinner menu\n2.Add to lunch menue \n3.Add to drink menu" +
                            "\n4.Customer info\n5.Back to main menu");
                    System.out.println("Select a Choice:");
                    manegerChoice = chekChoice();
                    switch (manegerChoice) {
                        case 1:
                            System.out.println("you can just add 10 food for dinner(id start from 120)");
                            System.out.println("enter id,name,price,count");
                            manager.addDinner(paternId(), paternName(), paternPrice(), paternCount());
                            choice = false;
                            break;
                        case 2:
                            System.out.println("you can just add 10 food for lunch(id start from 140)");
                            System.out.println("enter id,name,price,count");
                            manager.addLunch(paternId(), paternName(), paternPrice(), paternCount());
                            choice = false;
                            break;
                        case 3:
                            System.out.println("you can just add 5  drink menu(id start from 130)");
                            System.out.println("enter id,name,price,count");
                            manager.addDrink(paternId(), paternName(), paternPrice(), paternCount());
                            choice = false;
                            break;
                        case 4:
                            manager.CustomerInfo();
                            choice = false;
                            break;
                        case 5:
                            choice = true;
                            break;
                    }
                } while (!choice);
            } else if (choices == 2) {
                System.out.println("please enter your id,name,family,phoneNumber and gender");
                int id = paternId();
                String name = paternName();
                String family = paternName();
                String phoneNumber = paternPhone();
                String gender = paternName();
                manager.addCustomer(id, name, family, phoneNumber, gender);
                do {
                    System.out.println("************Customer Menu****************");
                    System.out.println("1.Add new order\n2.Show order details\n3.Cancel an order\n4.back to main menu");
                    System.out.println("Select a Choice:");
                    customerChoice = chekChoice();
                    String status;
                    switch (customerChoice) {
                        case 1:
                            System.out.println("enter lunch or dinner");
                            status = paternName();
                            if (status.equalsIgnoreCase("dinner")) {
                                customerOrders(manager, status);
                            } else {
                                customerOrders(manager, status);
                            }
                            choice = false;
                            break;
                        case 2:
                            System.out.println("enter lunch or dinner");
                            status = paternName();
                            manager.showOrderDetaild(status);
                            choice = false;
                            break;
                        case 3:
                            System.out.println("enter the order id you want to cancel");
                            int orderId = paternId();
                            manager.cancelOrder(orderId);
                            choice = false;
                            break;
                        case 4:
                            choice = true;
                            break;
                    }
                } while (!choice);
            } else if (chekChoice() == 3) {
                break;
            }
        } while (!backToMainMenue);
    }



}
