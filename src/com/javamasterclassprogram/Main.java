package com.javamasterclassprogram;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("8310133663");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\n Enter action :6 to show available actions");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\n Shutting Down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }

        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New Contact added Name:" + name + " phone= " + phone);
        } else {
            System.out.println("Can not add, " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new Contact name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new contact phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Succesfully updated");
        } else {
            System.out.println("error in updating");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully removed");
        } else {
            System.out.println("error in deleting the contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name:" + existingContactRecord.getName() +
                "Phone Number is- " + existingContactRecord.getPhoneNumber());
    }


    public static void startPhone() {
        System.out.println("Starting Phone...");
    }

    private static void printActions() {
        System.out.println("\n available action: \n PRess");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add new contact\n" +
                "3 - to update existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - to query if an existing contact exists\n" +
                "6 - to pring a list of actions available");
        System.out.println("Chose your action: ");
    }
}
