import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class AddressBookClient {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1: 添加联系人\n2: 修改联系人\n3: 删除联系人\n4: 查看所有联系人\n5: 退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    updateContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    listContacts();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("输入姓名: ");
        String name = scanner.next();
        System.out.print("输入电话: ");
        String phone = scanner.next();
        contacts.add(new Contact(name, phone));
        System.out.println("联系人已添加");
    }

    private static void updateContact(Scanner scanner) {
        System.out.print("输入要修改的联系人姓名: ");
        String name = scanner.next();
        for (Contact contact : contacts) {
            if (contact.name.equals(name)) {
                System.out.print("输入新电话: ");
                contact.phone = scanner.next();
                System.out.println("联系人已修改");
                return;
            }
        }
        System.out.println("联系人未找到");
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("输入要删除的联系人姓名: ");
        String name = scanner.next();
        contacts.removeIf(contact -> contact.name.equals(name));
        System.out.println("联系人已删除");
    }

    private static void listContacts() {
        for (Contact contact : contacts) {
            System.out.println("姓名: " + contact.name + ", 电话: " + contact.phone);
        }
    }
}
