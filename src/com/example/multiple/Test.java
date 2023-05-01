package com.example.multiple;
// Programmer: Pepper Berry
// Class: CS &145
// Date: 4/26/23
//assignment 2- phone book
// Purpose: allows you to look through add and remove stuff from a phonebook
import java.util.*;
public class Test {



    public static void main(String[] args) {

        LinkedList<Object> ll = new LinkedList<>();


        boolean is_Changing = true;
        while (is_Changing) {
            System.out.println("\n1.Add new contact\n2.View all contacts\n3.View a contact\n4.Modify a contact" +
            "\n5.Delete a contact\n6.Find all contacts with (First name/Last name...)\n7.Exit");
            Scanner input = new Scanner(System.in);
            String action = input.next();
            switch (action) {
                case "1":// Add new contact

                    Object person = Manager.newContact();
                    ll.add(person);
                    break;
                case "2":// View all contacts
                    if (ll.size() == 0) {
                        System.out.println("there are no contacts to view");
                        break;
                    }
                    int contact = 0;
                    while (contact < ll.size()) {
                        System.out.println("[" + ll.get(contact) + "]");
                        ++contact;
                    }
                    break;
                case "3":// View a contact
                    if (ll.size() == 0) {
                        System.out.println("there are no contacts to view");
                        break;
                    }
                    int intContact = Manager.lookupContact(ll);

                    System.out.println("the contact you are looking for is: \n[" + ll.get(intContact) + "]");
                    break;
                case "4":// Modify contact
                    if (ll.size() == 0) {
                        System.out.println("there are no contacts to modify");
                        break;
                    }
                    System.out.println("First, find the contact you want to modify\n");
                    int contactToChange = Manager.lookupContact(ll);

                    System.out.println("the contact you are changing is: \n[" + ll.get(contactToChange) + "]");
                    Manager.changeContact(ll, contactToChange);
                    System.out.println("the contact now reads: \n[" + ll.get(contactToChange) + "]");
                    break;
                case "5":// Delete a Contact
                    if (ll.size() == 0) {
                        System.out.println("there are no contacts to delete");
                        break;
                    }
                    System.out.println("First, find the contact you want to delete\n");
                    int contactToDelete = Manager.lookupContact(ll);
                    System.out.println("the contact you are deleting is: \n[" + ll.get(contactToDelete) + "]");
                    ll.remove(contactToDelete);
                    break;
                case "6"://to find all with
                    ArrayList<Object> contactsWith = Manager.allWith(ll);
                    contact = 0;
                    while (contact < contactsWith.size()) {
                        System.out.println("[" + contactsWith.get(contact) + "]");
                        ++contact;
                    }

                    break;
                case "7":// To exit
                    is_Changing = false;
                    break;
                default:// if they get it wrong
                    System.out.println("oops that is not a choice!\n");
            }
        }
    }


}
class Manager {

    //add, delete, modify, or search for an entry at the  beginning, middle, or end of the node
    // (name, address, city, phone #) or print.

    static void changeContact(LinkedList<Object> ll, int contactToChange) {
        Scanner input = new Scanner(System.in);
        boolean is_Changing = true;
        Object contact = ll.get(contactToChange);
        while (is_Changing) {
            System.out.println("\n1.Modify the first name\n2.Modify the last name\n3.Modify the address\n4.Modify the city\n5.Modify the phone number\n6.Exit");
            String add = input.nextLine();
            is_Changing = false;
            switch (add) {
                case "1":// change first name
                    System.out.println("What is the new first name of the contact?");
                    contact.firstName = input.nextLine();
                    break;
                case "2"://change last name
                    System.out.println("What is the new last name of the contact?");
                    contact.lastName = input.nextLine();
                    break;
                case "3":// change address
                    System.out.println("What is the new address of the contact?");
                    contact.address = input.nextLine();
                    break;
                case "4":// change city
                    System.out.println("What is the new city of the contact?");
                    contact.city = input.nextLine();
                    break;
                case "5":// change phone number
                    System.out.println("What is the new phone number of the contact?");
                    contact.phoneNumber = (input.nextLine());
                    break;
                case "6":// To exit
                    break;
                default:// if they get it wrong
                    System.out.println("oops that is not a choice!\n");
                    is_Changing = true;

            }
        }
    }
    static ArrayList allWith(LinkedList<Object> ll) {
        Scanner input = new Scanner(System.in);
        int intContact = 0;
        boolean is_Changing = true;
        String contactInfo = "";
        ArrayList<Object> contactsWith = new ArrayList<>();
        while (is_Changing) {
            System.out.println("1.Find all with the same first name\n2.Find all with the same last name\n3.Find all with the same address" +
            "\n4.Find all with the same city\n5.Find all with the same phone number\n6.Exit");
            String add = input.nextLine();
            switch (add) {
                case "1":// To look by first name
                    System.out.println("What is the first name?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.firstName)) {

                            contactsWith.add(contact);
                        }
                        ++intContact;
                    }
                    if (contactsWith.size()==0){
                        System.out.println("that first name does not exist\ntry finding the contact by something else\n");
                    }else {
                        System.out.println("all contacts with that first name are:");
                        is_Changing = false;
                    }
                    break;
                case "2"://To look by last name
                    System.out.println("What is the last name?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.lastName)) {

                            contactsWith.add(contact);
                        }
                        ++intContact;
                    }
                    if (contactsWith.size()==0){
                        System.out.println("that last name does not exist\ntry finding the contact by something else\n");
                    }else {
                        System.out.println("all contacts with that last name are:");
                        is_Changing = false;
                    }
                    break;
                case "3":// To look by address
                    System.out.println("What is the address?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.address)) {

                            contactsWith.add(contact);
                        }
                        ++intContact;
                    }
                    if (contactsWith.size()==0){
                        System.out.println("that address does not exist\ntry finding the contact by something else\n");
                    }else {
                        is_Changing = false;
                        System.out.println("all contacts with that address are:");
                    }
                    break;
                case "4":// To look by city
                    System.out.println("What is the city?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.city)) {

                            contactsWith.add(contact);
                        }
                        ++intContact;
                    }
                    if (contactsWith.size()==0){
                        System.out.println("that city does not exist\ntry finding the contact by something else\n");
                    }else {
                        System.out.println("all contacts with that city are:");
                        is_Changing = false;
                    }
                    break;
                case "5":// To look by phone number
                    System.out.println("What is the phone number?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.phoneNumber)) {

                            contactsWith.add(contact);
                        }
                        ++intContact;
                    }
                    if (contactsWith.size()==0){
                        System.out.println("that phone number does not exist\ntry finding the contact by something else\n");
                    }else {
                        System.out.println("all contacts with that phone number are:");
                        is_Changing = false;
                    }
                    break;
                case "6":// To exit
                    is_Changing = false;
                    break;
                default:// if they get it wrong
                    System.out.println("oops that is not a choice!\n");

            }

        }
        return contactsWith;


    }
    static Object newContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the first name of the new contact?");
        String newFirstName = input.nextLine();
        System.out.println("What is the last name of the new contact?");
        String newLastName = input.nextLine();
        System.out.println("What is the address of the new contact?");
        String newAddress = input.nextLine();
        System.out.println("What is the city of the new contact?");
        String newCity = input.nextLine();
        System.out.println("What is the phone number of the new contact?");
        String newPhoneNumber = input.nextLine();


        return new Object(newFirstName, newLastName, newAddress, newCity, newPhoneNumber);
    }
    static int lookupContact(LinkedList<Object> ll) {
        Scanner input = new Scanner(System.in);
        int intContact = 0;
        boolean is_Changing = true;
        String contactInfo = "";
        while (is_Changing) {
            System.out.println("1.Look by the first name\n2.Look by the last name\n3.Look by the address\n4.Look by the city\n5.Look by the phone number\n6.Exit");
            String add = input.nextLine();
            switch (add) {
                case "1":// To look by first name
                    System.out.println("What is the first name of the contact?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.firstName)) {
                            is_Changing = false;
                            break;
                        }
                        ++intContact;
                    }
                    System.out.println("that first name does not exist\ntry finding the contact by something else\n");
                    break;
                case "2"://To look by last name
                    System.out.println("What is the last name of the contact?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.lastName)) {
                            is_Changing = false;
                            break;
                        }
                        ++intContact;
                    }
                    System.out.println("that last name does not exist\ntry finding the contact by something else\n");
                    break;
                case "3":// To look by address
                    System.out.println("What is the address of the contact?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.address)) {
                            is_Changing = false;
                            break;
                        }
                        ++intContact;
                    }
                    System.out.println("that address does not exist\ntry finding the contact by something else\n");
                    break;
                case "4":// To look by city
                    System.out.println("What is the city of the contact?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.city)) {
                            is_Changing = false;
                            break;
                        }
                        ++intContact;
                    }
                    System.out.println("that city does not exist\ntry finding the contact by something else\n");
                    break;
                case "5":// To look by phone number
                    System.out.println("What is the phone number of the contact?");
                    contactInfo = input.nextLine();
                    while (intContact < ll.size()) {
                        Object contact = ll.get(intContact);
                        if (Objects.equals(contactInfo, contact.phoneNumber)) {
                            is_Changing = false;
                            break;
                        }
                        ++intContact;
                    }
                    System.out.println("that phone number does not exist\ntry finding the contact by something else\n");
                    break;
                case "6":// To exit
                    is_Changing = false;
                    break;
                default:// if they get it wrong
                    System.out.println("oops that is not a choice!\n");

            }
        }
        return intContact;
    }
}
class Object {

    String firstName;
    String lastName;
    String address;
    String phoneNumber;
    String city;


    Object(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }



    public String toString() {
        return firstName + ", " + lastName + ", "+address+ ", "+city+ ", "+phoneNumber;
    }


}












