import com.praktikum.data.Item;
import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;

import java.util.ArrayList;
import java.util.Scanner;
public static ArrayList<User> userlist = new ArrayList<>();
public static ArrayList<Item> reportedItem = new ArrayList<>();


public class Main {
    public static void main(String [] args){

        Admin admin1 = new Admin("Admin425", "425");
        Mahasiswa mahasiswa1 = new Mahasiswa("Agraa", "202410370110425");
        Scanner input = new Scanner(System.in);

        userlist.add(admin1);
        userlist.add(mahasiswa1);

        System.out.println("Pilih: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih login(1/2): ");
        int login = input.nextInt();

        if(login == 1){
            admin1.login();

        }else if(login == 2){
            mahasiswa1.login();
            mahasiswa1.displayInfo();
        }else {
            System.out.println("Data tidak Valid!");
        }




    }
}

public void main() {
}

public void main() {
}

