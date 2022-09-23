package util;

import passenger.Passenger;
import passenger.PassengerDAO;
import ticket.Ticket;
import train.Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TicketApp {

    static Scanner scannerNumber = new Scanner(System.in);
    static Scanner scannerText = new Scanner(System.in);

    public static void createTicket() throws ParseException {
        Ticket ticket;
        System.out.println("Enter the Train Number");
        int trainNumber = scannerNumber.nextInt();
        Train train = TrainDAO.findTrain(trainNumber);
        if(train==null) {
            System.out.println("Train with given train number does not exist");
            System.exit(0);
        }


        System.out.println("Enter Travel Date ");
        String sdate = scannerText.nextLine();
        Date travelDate = new SimpleDateFormat("dd-MM-yyyy").parse(sdate);

        if(travelDate.compareTo(new Date())<0) {
            System.out.println("Travel Date is before current date");
            System.exit(0);
        }

        System.out.println("Enter the number of passengers ");
        int numberOfPassengers = scannerNumber.nextInt();

        do {
            System.out.println("Enter Passenger Name ");
            String name = scannerText.nextLine();
            System.out.println("Enter Age ");
            int age = scannerNumber.nextInt();
            System.out.println("Enter Gender(M/F) ");
            char gender = scannerNumber.next().charAt(0);

            Passenger p = new Passenger(name,age,gender);
            PassengerDAO pdo = new PassengerDAO();
            pdo.insertIntoPassenger(p);

            ticket = new Ticket(travelDate,train);
            ticket.addPassenger(name, age, gender);


            numberOfPassengers--;

        }while(numberOfPassengers!=0);

        System.out.println("TICKET BOOKED\nPNR : "+ticket.generatePNR()+"\n");
        ticket.writeTicket();
        ticket.insertIntoTicketTable();


    }




    public static void main(String[] args) throws ParseException, InterruptedException {




        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("1.Create New Ticket (press n)\n2.Exit (press e)\nEnter Choice : ");
            String choice = sc.next();
            switch (choice){
                case "n":
                    createTicket();
                    Thread.sleep(2000);
                    continue;
                case "e":
                    scannerNumber.close();
                    scannerText.close();
                    break;
            }
            break;
        }
    }

}
