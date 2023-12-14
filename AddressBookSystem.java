import java.util.Scanner;
public class AddressBookSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        AddressBook addressBook = new AddressBook ();

        while (true) {
            System.out.println ("\nAddress Book System Menu:");
            System.out.println ("1. Add Contact");
            System.out.println ("2. Remove Contact");
            System.out.println ("3. Search Contact");
            System.out.println ("4. Display All Contacts");
            System.out.println ("5. Save Contacts to File");
            System.out.println ("6. Load Contacts from File");
            System.out.println ("7. Exit");
            System.out.print ("Enter your choice: ");

            int choice = scanner.nextInt ();
            scanner.nextLine ();

            switch (choice) {
                case 1:
                    System.out.print ("Enter name: ");
                    String name = scanner.nextLine ();
                    System.out.print ("Enter phone number: ");
                    String phoneNumber = scanner.nextLine ();
                    System.out.print ("Enter email address: ");
                    String emailAddress = scanner.nextLine ();
                    Contact newContact = new Contact (name, phoneNumber, emailAddress);
                    addressBook.addContact (newContact);
                    System.out.println ("Contact added successfully!");
                    break;

                case 2:
                    System.out.print ("Enter name to remove: ");
                    String removeName = scanner.nextLine ();
                    Contact contactToRemove = addressBook.searchContact (removeName);
                    if (contactToRemove != null) {
                        addressBook.removeContact (contactToRemove);
                        System.out.println ("Contact removed successfully!");
                    } else {
                        System.out.println ("Contact not found!");
                    }
                    break;

                case 3:
                    System.out.print ("Enter name to search: ");
                    String searchName = scanner.nextLine ();
                    Contact searchedContact = addressBook.searchContact (searchName);
                    if (searchedContact != null) {
                        System.out.println ("Contact found:\n" + searchedContact);
                    } else {
                        System.out.println ("Contact not found!");
                    }
                    break;

                case 4:
                    System.out.println ("All Contacts:");
                    addressBook.displayAllContacts ();
                    break;

                case 5:
                    System.out.print ("Enter file name to save contacts: ");
                    String saveFileName = scanner.nextLine ();
                    addressBook.saveContactsToFile (saveFileName);
                    System.out.println ("Contacts saved to file successfully!");
                    break;

                case 6:
                    System.out.print ("Enter file name to load contacts: ");
                    String loadFileName = scanner.nextLine ();
                    addressBook.loadContactsFromFile (loadFileName);
                    System.out.println ("Contacts loaded from file successfully!");
                    break;

                case 7:
                    System.out.println ("Exiting Address Book System. Goodbye!");
                    System.exit (0);
                    break;

                default:
                    System.out.println ("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
