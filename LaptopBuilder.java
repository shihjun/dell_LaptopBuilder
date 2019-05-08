import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class LaptopBuilder {

  static int screenPrice(String screen) {
    if (screen.equals("1080p")) {
      return 100;
    }
    if (screen.equals("4k")) {
      return 200;
    }
    if (screen.equals("Touchscreen")) {
      return 300;
    }
    return 0;
  }

  static int ramPrice(String screen) {
    if (screen.equals("8GB")) {
      return 100;
    }
    if (screen.equals("16GB")) {
      return 200;
    }
    if (screen.equals("32GB")) {
      return 300;
    }
    return 0;
  }

  static int hddPrice(String screen) {
    if (screen.equals("1TB HDD")) {
      return 100;
    }
    if (screen.equals("128GB SSD")) {
      return 200;
    }
    if (screen.equals("256GB SSD")) {
      return 300;
    }
    if (screen.equals("512 GB SSD")) {
      return 400;
    }
    return 0;
  }

  static int processorPrice(String screen) {
    if (screen.equals("i3")) {
      return 100;
    }
    if (screen.equals("i5")) {
      return 200;
    }
    if (screen.equals("i7")) {
      return 300;
    }
    return 0;
  }

  static Boolean checkCoupon(String coupon, ArrayList<String> coupons) {
    return coupons.contains(coupon);
  }

  static double calculateDisc(String coupon) {
    if (coupon.equals("dell10")) {
      return 0.1;
    }
    if (coupon.equals("dell20")) {
      return 0.2;
    }
    return 0;
  }

  static String discMsg(String coupon) {
    if (coupon.equals("dell10")) {
      return "10%";
    }
    if (coupon.equals("dell20")) {
      return "20%";
    }
    return null;
  }

  public static void main(String args[]) {

    boolean homePage = true;
    boolean buildLaptop = false;
    boolean shoppingCart = false;
    boolean checkout = false;

    double discount = 0;
    String couponCode = "-";
    String discountMsg = "-  ";

    String[] screen = { "1080p", "4k", "Touchscreen" };
    String[] ram = { "8GB", "16GB", "32GB" };
    String[] hdd = { "1TB HDD", "128GB SSD", "256GB SSD", "512 GB SSD" };
    String[] processor = { "i3", "i5", "i7" };

    String[] couponCodes = { "dell10", "dell20" };
    ArrayList<String> coupons = new ArrayList<>(Arrays.asList(couponCodes));

    ArrayList<String> cart = new ArrayList<>();
    ArrayList<Integer> subtotalPriceList = new ArrayList<>();

    System.out.println("<<Welcome to laptop builder>>");

    while (!checkout) {

      while (homePage) {
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("| Choose your options:  |");
        System.out.println("|  1. Build Laptop      |\n|  2. Shopping Cart     |");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~");

        Scanner userInput = new Scanner(System.in);
        Integer homeOption = Integer.parseInt(userInput.nextLine());

        if (homeOption == 1) {
          buildLaptop = !buildLaptop;
          homePage = !homePage;
        } else if (homeOption == 2) {
          shoppingCart = !shoppingCart;
          homePage = !homePage;
        }
      }

      if (buildLaptop) {
        ArrayList<String> tempCart = new ArrayList<>();
        String[] configOptions = { "Screen", "Ram", "Hdd", "Processor", "Price" };
        String tempCart1 = "";
        int price = 1000;

        System.out.println("\nLaptop base price is RM" + price);

        // choose screen options
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Choose screen options:");
        for (int i = 0; i < screen.length; i++) {
          int screenPrice = screenPrice(screen[i]);
          System.out.println("  " + (i + 1) + ". " + screen[i] + " - RM" + screenPrice);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner screenInput = new Scanner(System.in);
        Integer screenIndex = Integer.parseInt(screenInput.nextLine());
        tempCart.add(screen[screenIndex - 1]);
        price = price + screenPrice(screen[screenIndex - 1]);

        // choose ram options
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Choose ram options: ");
        for (int i = 0; i < ram.length; i++) {
          int ramPrice = ramPrice(ram[i]);
          System.out.println("  " + (i + 1) + ". " + ram[i] + " - RM" + ramPrice);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner ramInput = new Scanner(System.in);
        Integer ramIndex = Integer.parseInt(ramInput.nextLine());
        tempCart.add(ram[ramIndex - 1]);
        price = price + ramPrice(ram[ramIndex - 1]);

        // choose hdd options
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Choose hdd options: ");
        for (int i = 0; i < hdd.length; i++) {
          int hddPrice = hddPrice(hdd[i]);
          System.out.println("  " + (i + 1) + ". " + hdd[i] + " - RM" + hddPrice);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner hddInput = new Scanner(System.in);
        Integer hddIndex = Integer.parseInt(hddInput.nextLine());
        tempCart.add(hdd[hddIndex - 1]);
        price = price + hddPrice(hdd[hddIndex - 1]);

        // choose processor options
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Choose processor options: ");
        for (int i = 0; i < processor.length; i++) {
          int processorPrice = processorPrice(processor[i]);
          System.out.println("  " + (i + 1) + ". " + processor[i] + " - RM" + processorPrice);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner processorInput = new Scanner(System.in);
        Integer processorIndex = Integer.parseInt(processorInput.nextLine());
        tempCart.add(processor[processorIndex - 1]);
        price = price + processorPrice(processor[processorIndex - 1]);

        // Config price
        String price1 = Integer.toString(price);
        tempCart.add(price1);

        // config items
        System.out.println("===========================");
        System.out.println("Below is your configurations:");
        for (int i = 0; i < tempCart.size(); i++) {
          System.out.println("  " + configOptions[i] + ": " + tempCart.get(i));
          tempCart1 = tempCart1 + "|" + configOptions[i] + ": " + tempCart.get(i) + "| ";
        }
        System.out.println("===========================");

        // Add config to cart
        System.out.println("Do you want to add to cart?\n1. Yes\n2. No");
        Scanner addCartInput = new Scanner(System.in);
        Integer addCartOption = Integer.parseInt(addCartInput.nextLine());
        if (addCartOption == 1) {
          cart.add(tempCart1);
          subtotalPriceList.add(price);
          System.out.println("Laptop added to cart. Build another laptop or checkout at shopping cart.\n");
        }
        buildLaptop = !buildLaptop;
        homePage = !homePage;

      }

      if (shoppingCart) {
        int totalPrice = 0;
        int subTotal = 0;

        for (int i = 0; i < subtotalPriceList.size(); i++) {
          subTotal += subtotalPriceList.get(i);
        }

        if (cart.size() == 0) {
          System.out.println("Cart is empty! Build your laptop.");
          shoppingCart = !shoppingCart;
          homePage = !homePage;
        } else {
          // check is coupon exist
          if (couponCode != "-") {
            totalPrice = (int) (subTotal - (subTotal * discount));
          } else {
            totalPrice = subTotal;
          }

          // show all cart items and price
          System.out.println("===============================");
          System.out.println("Shopping Cart items:");
          for (int i = 0; i < cart.size(); i++) {
            System.out.println(i + 1 + ". " + cart.get(i));
          }
          System.out.println("Coupon Code: " + couponCode);
          System.out.println(" ~~~~~~~~~~~~~~~~~~~");
          System.out.println("|Sub-Total: RM" + subTotal + "  |\n|Discount: " + discountMsg
              + "      |\n|Total Price: RM" + totalPrice + "|");
          System.out.println(" ~~~~~~~~~~~~~~~~~~~");

          // add coupon, checkout, remove item, back to homepage
          System.out.println("1. Add coupon code\n2. Checkout\n3. Remove item\n4. Back");
          Scanner checkoutInput = new Scanner(System.in);
          Integer checkoutOption = Integer.parseInt(checkoutInput.nextLine());
          if (checkoutOption == 1) {
            if (couponCode == "-") {
              System.out.println("Enter the coupon code:");
              Scanner couponInput = new Scanner(System.in);
              String tempCoupon = couponInput.nextLine();
              if (checkCoupon(tempCoupon, coupons)) {
                couponCode = tempCoupon;
                discount = calculateDisc(couponCode);
                discountMsg = discMsg(couponCode);
                System.out.println("<< discount " + discountMsg + " >>");
              } else {
                System.out.println("Coupon code not valid.");
              }
            } else {
              totalPrice = subTotal;
              System.out.println("Coupon code (" + couponCode + ") already added.");
            }
          } else if (checkoutOption == 2) {
            checkout = !checkout;
            System.out.println("Thank you for shopping with Dell.");
          } else if (checkoutOption == 3) {
            System.out.println("Enter the remove item:");
            Scanner removeItemInput = new Scanner(System.in);
            Integer removeItemIndex = Integer.parseInt(removeItemInput.nextLine());
            subTotal -= subtotalPriceList.get(removeItemIndex - 1);
            cart.remove(removeItemIndex - 1);
            subtotalPriceList.remove(removeItemIndex - 1);
            System.out.println("Item: " + removeItemIndex + " removed from cart.");
          } else if (checkoutOption == 4) {
            totalPrice = subTotal;
            shoppingCart = !shoppingCart;
            homePage = !homePage;
          }
        }
      }
    }
  }
}