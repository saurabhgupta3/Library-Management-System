import java.util.Scanner;

class Book {
    String title;
    boolean isBorrowed;

    Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }
}

public class LibraryManagementSystem {
    static Book[] books = new Book[100];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        books[count++] = new Book(title);
        System.out.println("Book added successfully!");
    }

    public static void viewBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < count; i++) {
            if (!books[i].isBorrowed) {
                System.out.println("- " + books[i].title);
            }
        }
    }

    public static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title) && !books[i].isBorrowed) {
                books[i].isBorrowed = true;
                System.out.println("You borrowed: " + title);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Available Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: borrowBook(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }
}
