package Airport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import java.util.SplittableRandom;

import static java.lang.System.exit;

public class Airservice {
    /* all entered data  are in small case
     for airline : airindia,indigo,spicejet,vistara,AirAsia,
     for batch : morning, afternoon, evening, night,
     fair range : 1k to 10k
     traveld :0 to 1k
     */
    public static void main(String[] args) throws IOException, SQLException {
        String log;
        int choice ;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Aircontroller acobj = new Aircontroller();
        System.out.println("Welcome to Airport Portal !!! ");
        System.out.println("Kindly select your login ");
        try {
            do {

                System.out.println("Enter your choice :");
                System.out.println("Enter 1 for Admin login :");
                System.out.println("Enter 2 for User login");
                System.out.println("Enter 3 to exit from system");
                choice = sc1.nextInt();

                switch (choice) {
                    case 1 -> {
                        acobj.admin();
                    }
                    case 2 -> {
                        acobj.user();
                    }
                    case 3 -> {
                        System.out.println("You have succefully exited from system");
                        exit(0);
                    }
                }
                System.out.println("Do You wish to change the login ?...Yes!! or NO!! ");
                log = String.valueOf(sc1.next().charAt(0));
            } while ((Objects.equals(log, "Y") || Objects.equals(log, "y")));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("!!! Shutting down system !!!");
    }
}
