import java.util.Scanner;

public class OrderingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Food items and their prices
        String item1 = "Shawarma";
        String item2 = "Pizza";
        String item3 = "Fried Chicken";
        String item4 = "Spaghetti";
        String item5 = "Chicken Sandwich";

        double price1 = 50.00;
        double price2 = 75.00;
        double price3 = 100.00;
        double price4 = 125.00;
        double price5 = 150.00;

        // Variables for the customer's total purchases
        int totalQuantity = 0;
        double totalAmount = 0.00;
        double totalDeduction = 0.00;

        String orderAgain = "Y";

        System.out.println("==============================================");
        System.out.println("          CANTEEN ORDERING SYSTEM");
        System.out.println("==============================================");

        // Continue accepting orders while the customer chooses Y
        while (orderAgain.equalsIgnoreCase("Y")) {

            // Display the canteen menu
            System.out.println("\n--------------- CANTEEN MENU ----------------");
            System.out.printf("%-5s %-25s %10s%n",
                    "No.", "Food Item", "Price");
            System.out.println("----------------------------------------------");
            System.out.printf("%-5d %-25s $%9.2f%n",
                    1, item1, price1);
            System.out.printf("%-5d %-25s $%9.2f%n",
                    2, item2, price2);
            System.out.printf("%-5d %-25s $%9.2f%n",
                    3, item3, price3);
            System.out.printf("%-5d %-25s $%9.2f%n",
                    4, item4, price4);
            System.out.printf("%-5d %-25s $%9.2f%n",
                    5, item5, price5);
            System.out.println("----------------------------------------------");

            // Get item number
            System.out.print("Enter item number: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid order. Item number must be a number.");
                input.nextLine();

            } else {

                int itemNumber = input.nextInt();

                // Get quantity
                System.out.print("Enter quantity (1-10): ");

                if (!input.hasNextInt()) {
                    System.out.println(
                            "Invalid order. Quantity must be a number from 1 to 10."
                    );
                    input.nextLine();

                } else {

                    int quantity = input.nextInt();

                    // Check if item number and quantity are valid
                    if (itemNumber < 1 || itemNumber > 5) {

                        System.out.println(
                                "Invalid order. Item number must be from 1 to 5."
                        );

                        // Invalid order:
                        // Skip remaining processing and go to next attempt.

                    } else if (quantity < 1 || quantity > 10) {

                        System.out.println(
                                "Invalid order. Quantity must be from 1 to 10."
                        );

                        // Invalid order:
                        // Skip remaining processing and go to next attempt.

                    } else {

                        // Get student's status
                        System.out.print("Are you a student? (Y/N): ");
                        String student = input.next();

                        // Check whether student input is valid
                        if (!student.equalsIgnoreCase("Y")
                                && !student.equalsIgnoreCase("N")) {

                            System.out.println(
                                    "Invalid order. Student status must be Y or N."
                            );

                        } else {

                            // Determine the price of the selected item
                            double itemPrice = 0.00;
                            String itemName = "";

                            if (itemNumber == 1) {
                                itemPrice = price1;
                                itemName = item1;

                            } else if (itemNumber == 2) {
                                itemPrice = price2;
                                itemName = item2;

                            } else if (itemNumber == 3) {
                                itemPrice = price3;
                                itemName = item3;

                            } else if (itemNumber == 4) {
                                itemPrice = price4;
                                itemName = item4;

                            } else if (itemNumber == 5) {
                                itemPrice = price5;
                                itemName = item5;
                            }

                            // Calculate the amount for this order
                            double orderAmount = itemPrice * quantity;

                            // Determine the discount
                            double deductionRate = 0.00;

                            if (student.equalsIgnoreCase("Y")
                                    && orderAmount >= 500.00) {

                                // Student with $500 or more = 15%
                                deductionRate = 0.15;

                            } else if (student.equalsIgnoreCase("Y")) {

                                // Student = 10%
                                deductionRate = 0.10;

                            } else if (orderAmount >= 500.00) {

                                // Non-student with $500 or more = 5%
                                deductionRate = 0.05;

                            } else {

                                // Does not qualify for a discount
                                deductionRate = 0.00;
                            }

                            // Calculate deduction for this order
                            double deduction = orderAmount * deductionRate;

                            // Add the valid order to the customer's totals
                            totalQuantity = totalQuantity + quantity;
                            totalAmount = totalAmount + orderAmount;
                            totalDeduction = totalDeduction + deduction;

                            // Display order details
                            System.out.println("\n------------- ORDER DETAILS ---------------");
                            System.out.println("Item: " + itemName);
                            System.out.println("Quantity: " + quantity);
                            System.out.printf("Amount: $%.2f%n", orderAmount);
                            System.out.printf("Discount: %.0f%%%n",
                                    deductionRate * 100);
                            System.out.printf("Deduction: $%.2f%n",
                                    deduction);
                            System.out.printf("Amount after deduction: $%.2f%n",
                                    orderAmount - deduction);
                            System.out.println("--------------------------------------------");
                        }
                    }
                }
            }

            // Ask if the customer wants to order again
            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next();

            // Validate the answer
            while (!orderAgain.equalsIgnoreCase("Y")
                    && !orderAgain.equalsIgnoreCase("N")) {

                System.out.println(
                        "Invalid choice. Please enter Y or N."
                );

                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = input.next();
            }
        }

        // Final computation
        double finalAmount = totalAmount - totalDeduction;

        // Display final summary
        System.out.println("\n==============================================");
        System.out.println("              FINAL SUMMARY");
        System.out.println("==============================================");

        System.out.println("Total quantity of items purchased: "
                + totalQuantity);

        System.out.printf("Total amount before deductions: $%.2f%n",
                totalAmount);

        System.out.printf("Total deduction: $%.2f%n",
                totalDeduction);

        System.out.printf("Final amount to pay: $%.2f%n",
                finalAmount);

        System.out.println("==============================================");
        System.out.println("          THANK YOU FOR ORDERING!");
        System.out.println("==============================================");

        input.close();
    }
}
