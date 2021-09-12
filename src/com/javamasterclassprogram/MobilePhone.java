package com.javamasterclassprogram;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    // Contact is object
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) > 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldcontact, Contact newcontact) {
        int foundPosition = findContact(oldcontact);
        if(foundPosition<0){
            System.out.println(oldcontact.getName()+" Was not found");
            return false;
        }
        this.myContacts.set(foundPosition, newcontact);
        System.out.println(oldcontact.getName()+", was replaced with "+ newcontact.getName());
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName()+", was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName()+" was deleted");
        return true;
    }

    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public  Contact queryContact(String name){
        int position = findContact(name);
        if(position>0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact list");
        for (int i= 0; i<this.myContacts.size(); i++){
            System.out.println((i+1)+"."+
                    this.myContacts.get(i).getName()+" ->"+
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
