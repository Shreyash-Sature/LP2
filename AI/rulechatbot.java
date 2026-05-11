import java.util.Scanner;

public class rulechatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("===== AI CUSTOMER CHATBOT =====");
        System.out.println("Type 'exit' to stop\n");

        while (true) {

            System.out.print("You: ");

            input = sc.nextLine().toLowerCase();

            if (input.contains("hello") ||
                input.contains("hi")) {

                System.out.println(
                    "Bot: Hello! Welcome to our service."
                );
            }
            else if (input.contains("product")) {

                System.out.println(
                    "Bot: We provide laptops, mobiles and headphones."
                );
            }

            else if (input.contains("price") ||
                     input.contains("cost")) {

                System.out.println(
                    "Bot: Product prices start from Rs. 5000."
                );
            }

            // Service Query
            else if (input.contains("service")) {

                System.out.println(
                    "Bot: We provide delivery and warranty service."
                );
            }

            // Delivery Query
            else if (input.contains("delivery")) {

                System.out.println(
                    "Bot: Delivery takes 3 to 5 working days."
                );
            }

            else if (input.contains("payment")) {

                System.out.println(
                    "Bot: We accept UPI, Debit Card and Cash."
                );
            }

            // Contact Query
            else if (input.contains("contact")) {

                System.out.println(
                    "Bot: Contact us at 9876543210."
                );
            }

            // Thanks
            else if (input.contains("thank")) {

                System.out.println(
                    "Bot: You're welcome!"
                );
            }

            // Exit
            else if (input.contains("bye") ||
                     input.equals("exit")) {

                System.out.println(
                    "Bot: Thank you for visiting."
                );

                break;
            }

          
            else {

                System.out.println(
                    "Bot: Sorry, I did not understand your query."
                );
            }
        }

        sc.close();
    }
}