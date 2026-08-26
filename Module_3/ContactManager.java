import java.util.*;

public class ContactManager {
    public static void main(String[] args){
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 617 555 0111"));
        contacts.put("Frances Allen", new Contact("Frances Allen", "+1 617 555 1000"));
        contacts.put("Ida Rhodes", new Contact("Ida Rhodes", "+1 617 555 1001"));
        contacts.put("Katherine Johnson", new Contact("Katherine Johnson", "+1 617 555 1010"));
        
        if(contacts.get("Ada Lovelace")==null){
            System.out.println("Contact not found");
        } else{
            System.out.println(contacts.get("Ada Lovelace").toString());
        }

        if(contacts.get("nobody")==null){
            System.out.println("Contact not found");
        } else{
            System.out.println(contacts.get("Ada Lovelace").toString());
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());  
        sorted.sort((a, b) -> a.getName().compareTo(b.getName())); 

        System.out.println("=== All Contacts ===");
        for(Contact contact : sorted){
            System.out.println(contact.toString()+"%n");
        }
    }
}
