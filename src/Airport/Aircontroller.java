package Airport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Aircontroller {
     int tfno;
     String tairline, tbatch, tsource, tdestination;
     int tfare,tdura;
     double ttraveld;
    int choice;
    String str;
    Scanner sc1 = new Scanner(System.in);  // For string values
    Scanner sc2 = new Scanner(System.in);  //for int value
    public void admin() throws SQLException, IOException {
        String user,choice;
        int pass;
        System.out.println("Are you a existing admin or new");
        choice= String.valueOf(sc1.next().charAt(0));
        if((Objects.equals(choice, "N") || Objects.equals(choice, "n"))){
            System.out.println("Register yourself now");
            System.out.println("enter user name");
            user = sc1.next();
            System.out.println("enter pass for user");
            pass = sc2.nextInt();
            System.out.println("Admin name ="+" "+ user +" " + "with password (*****) accesing data");

        } else if((Objects.equals(choice, "E") || Objects.equals(choice, "e"))){

            System.out.println("welcome admin!!!");
        }else
        {
            System.out.println("please provide a valid input");
            System.out.println("Admin Access Over Ruled.. system hacked");
        }
        Properties prop = new Properties();
        prop.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        PreparedStatement prepStat;
        try {
            do {
                int choice1;
                System.out.println("Enter your choice :");
                System.out.println("Enter 1 to create flight :");
                System.out.println("Enter 2 to insert flight details:");
                System.out.println("Enter 3 to See the available data of flight");
                System.out.println("Enter 4 to update source:");
                System.out.println("Enter 5 to update  price :");
                System.out.println("Enter any key for exit:");
                choice1 = sc2.nextInt();

                switch (choice1) {
                    case 1 -> {
                        prepStat = conn.prepareStatement("create table airpotab (fno SERIAL primary key, airline varchar(50) not null, batch varchar(50) not null, source varchar(50) not null,destination varchar(50) not null,traveld double precision not null, fare int not null, duration int not null)");
                        prepStat.executeUpdate();
                        System.out.println("Table created.");
                    }
                    case 2 -> {
                        prepStat = conn.prepareStatement("insert into airpotab (airline, batch, source, destination, traveld, fare, duration) values(?, ?, ?, ?, ?, ? , ?)");

                        System.out.println("Enter airline name");
                        tairline = sc1.next();
                        System.out.println("Enter batch time in small case for ex: morning, afternoon, evening, night ");
                        tbatch = sc1.next();
                        System.out.println("Enter the place from you want to take flight i.e source");
                        tsource = sc1.next();
                        System.out.println("Enter the destination where you want to go");
                        tdestination = sc1.next();
                        System.out.println("Enter the distance you are going to travel");
                        ttraveld = sc2.nextDouble();
                        System.out.println("Enter the fare for the current route");
                        tfare = sc2.nextInt();
                        System.out.println("Please enter the travel duration for this flight in minute only");
                        tdura = sc2.nextInt();

                        prepStat.setString(1, tairline);
                        prepStat.setString(2, tbatch);
                        prepStat.setString(3, tsource);
                        prepStat.setString(4, tdestination);
                        prepStat.setDouble(5, ttraveld);
                        prepStat.setInt(6, tfare);
                        prepStat.setInt(7 ,tdura);

                        prepStat.executeUpdate();
                        System.out.println("Row inserted in airpotab table.");
                    }
                    case 3 -> {
                        prepStat = conn.prepareStatement("select * from airpotab");
                        ResultSet resultSet = prepStat.executeQuery();
                        while (resultSet.next()) {
                            System.out.println(resultSet.getInt("fno") + "    " + resultSet.getString("airline") + "   " + resultSet.getString("batch") + "    " + resultSet.getString("source") + "    " + resultSet.getString("destination") + "     " + resultSet.getDouble("traveld") + "    " + resultSet.getInt("fare")+ "    " + resultSet.getInt("duration"));
                        }
                        System.out.println("All rows are retrieved.");
                    }
                    case 4 -> {
                        prepStat = conn.prepareStatement("update airpotab set source = ? where source = ?");
                        System.out.println("enter the available source which you want to update ");
                        tsource = sc1.next();
                        System.out.println("enter the new updating source name");
                        tbatch = sc1.next();
                        prepStat.setString(1, tbatch);
                        prepStat.setString(2, tsource);
                        prepStat.executeUpdate();
                        System.out.println("source updated in airpotab table.");
                    }
                    case 5 -> {
                        prepStat = conn.prepareStatement("update airpotab set fare = ? where fno = ?");
                        System.out.println("enter the flight no for which you want to update price");
                        tfno = sc1.nextInt();
                        System.out.println("enter the updating price");
                        tfare = sc1.nextInt();
                        prepStat.setInt(1, tfare);
                        prepStat.setInt(2, tfno);
                        prepStat.executeUpdate();
                        System.out.println("price updated in airpotab table.");
                    }
                }
                System.out.println("Do you want to continue ? ? ?");
                str = sc1.next();
            } while (Objects.equals(str, "y") || Objects.equals(str, "Y"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void user () throws IOException, SQLException {
        String choice,user;
        int choice11;
        int pass1;
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);//string
        System.out.println("Are you a existing user or new");
        choice= String.valueOf(sc1.next().charAt(0));
        if((Objects.equals(choice, "N") || Objects.equals(choice, "n"))){
            System.out.println("Register yourself now");
            System.out.println("enter user name");
            user = sc1.next();
            System.out.println("enter pass for user");
            pass1 = sc2.nextInt();
            System.out.println("User name ="+" "+ user +" " + "with password (*****) accesing data");

        } else if((Objects.equals(choice, "E") || Objects.equals(choice, "e"))){

            System.out.println("!!!  welcome user   !!!");
        }else
        {
            System.out.println("please provide a valid input");
            System.out.println("User Access Over Ruled.. system hacked");
        }

        Properties prop = new Properties();
        prop.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        PreparedStatement prepStat;
        try {
            do {
                System.out.println(" HELLO USER ");
                System.out.println("Enter your choice :");
                System.out.println("Enter 1 to find flight :");
                System.out.println("Enter 2 to find the most affordable price:");
                System.out.println("Enter 3 to find shortest distance flight");
                System.out.println("Enter 4 to see flight according to batch");
                System.out.println("Enter 5 to see all flight details");
                System.out.println("Enter 6 to see shortest duration flight");
                System.out.println("Enter any key for exit:");
                choice11 = sc3.nextInt();
                switch (choice11) {
                    case 1 -> {
                        prepStat = conn.prepareStatement("select * from airpotab where source = ? and destination = ?");
                        System.out.println("enter the source from where you want to see flight");
                        tsource = sc1.next();
                        System.out.println("enter the destination where you want to go");
                        tdestination = sc1.next();
                        prepStat.setString(1, tsource);
                        prepStat.setString(2, tdestination);
                        ResultSet resultSet = prepStat.executeQuery();
                        while (resultSet.next()) {
                                // Retrieve and print values for each column in the row
                                int fno = resultSet.getInt("fno");
                                String airline = resultSet.getString("airline");
                                String batch = resultSet.getString("batch");
                                String source = resultSet.getString("source");
                                String destination = resultSet.getString("destination");
                                int fare = resultSet.getInt("fare");
                                double traveld = resultSet.getDouble("traveld");
                                int dura = resultSet.getInt("duration");

                                System.out.println(fno + "   " + airline + "   " + batch + "  " + source + "  " + destination + "  " + fare + "   " + traveld + "  " + dura);

                        }
                        System.out.println("All rows are retrieved.");
                    }
                    case 2 -> {
                       // prepStat = conn.prepareStatement("SELECT * FROM airpotab WHERE source = ? and destination = ? and fare = (SELECT MIN(fare) FROM airpotab)");
                        prepStat = conn.prepareStatement("SELECT a.* FROM airpotab a JOIN ( SELECT source, destination, MIN(fare) AS min_fare  FROM airpotab WHERE source = ? AND destination = ? GROUP BY source, destination) b ON a.source = b.source AND a.destination = b.destination AND a.fare = b.min_fare");
                        System.out.println("enter the source ");
                        tsource = sc4.next();
                        System.out.println("enter the destination where you want to go");
                        tdestination = sc4.next();
                        prepStat.setString(1, tsource);
                        prepStat.setString(2, tdestination);

                        ResultSet resultSet = prepStat.executeQuery();
                        if (resultSet.next()) {
                            // Retrieve and print values for each column in the row
                            int fno = resultSet.getInt("fno");
                            String airline = resultSet.getString("airline");
                            String batch = resultSet.getString("batch");
                            String source = resultSet.getString("source");
                            String destination = resultSet.getString("destination");
                            int fare = resultSet.getInt("fare");
                            double traveld = resultSet.getDouble("traveld");
                            int dura = resultSet.getInt("duration");
                            System.out.println(fno + "    " + airline +"    " + batch +"    " + source +"    " + destination + "    " + traveld+ "    " + fare + "   " + dura);
                        } else {
                            System.out.println("No result found.");
                        }
                        System.out.println("most affordable flight for this route is retrieved.");

                    }
                    case 3 -> {
                        //prepStat = conn.prepareStatement("SELECT * FROM airpotab WHERE source = ? and destination = ? and traveld = (SELECT MIN(traveld) FROM airpotab)");
                        prepStat = conn.prepareStatement("SELECT a.* FROM airpotab a JOIN ( SELECT source, destination, MIN(traveld) AS min_fare  FROM airpotab WHERE source = ? AND destination = ? GROUP BY source, destination) b ON a.source = b.source AND a.destination = b.destination AND a.traveld = b.min_fare");
                        System.out.println("enter the source ");
                        tsource = sc1.next();
                        System.out.println("enter the destination where you want to go");
                        tdestination = sc1.next();
                        prepStat.setString(1, tsource);
                        prepStat.setString(2, tdestination);
                        ResultSet resultSet = prepStat.executeQuery();
                        if (resultSet.next()) {
                            // Retrieve and print values for each column in the row
                            int fno = resultSet.getInt("fno");
                            String airline = resultSet.getString("airline");
                            String batch = resultSet.getString("batch");
                            String source = resultSet.getString("source");
                            String destination = resultSet.getString("destination");
                            int fare = resultSet.getInt("fare");
                            double traveld = resultSet.getDouble("traveld");
                            int dura = resultSet.getInt("duration");

                            System.out.println(fno + "   " + airline + "   " + batch + "  " + source + "  " + destination + "  " + traveld+ "   " + fare + "   "+ dura);
                        } else {
                            System.out.println("No result found.");
                        }
                        System.out.println("shortest distance flight is retrieved.");

                    }
                    case 4 -> {
                        prepStat = conn.prepareStatement("select * from airpotab where batch = ?");
                        System.out.println("Enter the batch timing for which you want data for ex: morning");
                        tbatch = sc1.next();
                        prepStat.setString(1, tbatch);
                        ResultSet resultSet = prepStat.executeQuery();
                        while (resultSet.next()) {
                            System.out.println(resultSet.getInt("fno") + " " + resultSet.getString("airline") + " " + resultSet.getString("batch") + " " + resultSet.getString("source") + " " + resultSet.getString("destination") + " " + resultSet.getDouble("traveld") + " " + resultSet.getInt("fare") + "  " + resultSet.getInt("duration"));
                        }
                        System.out.println(tbatch + " "+"time flight data is retrieved");
                    }
                    case 5 -> {
                        prepStat = conn.prepareStatement("select * from airpotab");
                        ResultSet resultSet = prepStat.executeQuery();
                        while (resultSet.next()) {
                            System.out.println(resultSet.getInt("fno") + "    " + resultSet.getString("airline") + "     " + resultSet.getString("batch") + "     " + resultSet.getString("source") + "     " + resultSet.getString("destination") + "     " + resultSet.getDouble("traveld") + "     " + resultSet.getInt("fare") +"     " +resultSet.getInt("duration"));
                        }
                        System.out.println("All rows are retrieved.");

                    }
                    case 6 -> {
                        //prepStat = conn.prepareStatement("SELECT * FROM airpotab WHERE source = ? and destination = ? and duration = (SELECT MIN(duration) FROM airpotab)");
                        prepStat = conn.prepareStatement("SELECT a.* FROM airpotab a JOIN ( SELECT source, destination, MIN(duration) AS min_fare  FROM airpotab WHERE source = ? AND destination = ? GROUP BY source, destination) b ON a.source = b.source AND a.destination = b.destination AND a.duration = b.min_fare");

                        System.out.println("enter the source ");
                        tsource = sc1.next();
                        System.out.println("enter the destination where you want to go");
                        tdestination = sc1.next();
                        prepStat.setString(1, tsource);
                        prepStat.setString(2, tdestination);

                        ResultSet resultSet = prepStat.executeQuery();
                        if (resultSet.next()) {
                            // Retrieve and print values for each column in the row
                            int fno = resultSet.getInt("fno");
                            String airline = resultSet.getString("airline");
                            String batch = resultSet.getString("batch");
                            String source = resultSet.getString("source");
                            String destination = resultSet.getString("destination");
                            int fare = resultSet.getInt("fare");
                            double traveld = resultSet.getDouble("traveld");
                            int dura = resultSet.getInt("duration");
                            System.out.println(fno + "   " + airline + "   " + batch + "  " + source + "  " + destination + "  " + traveld+ "   " + fare + "  "+ dura);
                            int h = dura/60;
                            int m = dura % 60;
                            System.out.print("shortest duration in this route in minute is "+ ""+ dura +""+"min"+" "+ "in hour is"+" ");
                            System.out.printf("%dhr:%02dmin",h,m);
                            System.out.println();

                        } else {
                            System.out.println("No result found.");
                        }
                    }
                }
                System.out.println("Do you want to continue ? ? ?");
                str = sc1.next();
            } while (Objects.equals(str, "y") || Objects.equals(str, "Y"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}