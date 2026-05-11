import java.util.Scanner;

public class chatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg;

        System.out.println("===== AI CUSTOMER CHATBOT =====");
        System.out.println("Chat with us! (Type 'bye' to exit)\n");

        while (true) {
            System.out.print("You: ");
            msg = sc.nextLine().toLowerCase();

            if (msg.contains("bye") || msg.equals("exit")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            }

            if (msg.contains("hello") || msg.contains("hi")) {
                System.out.println("Bot: Hi there! How can I help you today?");
            } 
            else if (msg.contains("product") || msg.contains("item")) {
                System.out.println("Bot: We offer high-quality Laptops, Mobiles, and Headphones.");
            } 
            else if (msg.contains("price") || msg.contains("cost")) {
                System.out.println("Bot: Our products range from ₹5,000 to ₹1,00,000.");
            } 
            else if (msg.contains("service") || msg.contains("support")) {
                System.out.println("Bot: We provide 24/7 technical support and 1-year warranty.");
            } 
            else if (msg.contains("delivery") || msg.contains("ship")) {
                System.out.println("Bot: Standard delivery takes 3-5 business days.");
            } 
            else if (msg.contains("location") || msg.contains("address")) {
                System.out.println("Bot: We are located in Pune, but we ship nationwide.");
            }
            else {
                System.out.println("Bot: I'm sorry, I didn't quite get that. Can you ask about our products or delivery?");
            }
        }
        sc.close();
    }
}