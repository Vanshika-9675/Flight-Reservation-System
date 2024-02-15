import java.util.Scanner;

//flight reservation system 
public class FlightReservationSystem {
    public static void main(String[] args) {
        ReservationSystem r = new ReservationSystem();
        Scanner sc = new Scanner(System.in);
       
        boolean flag = true;

        do {
        
            System.out.println("1.Add flights\n2.Show available flights\n3.Reserve seat\n4.Cancel seat\n5.Exit");
            System.out.print("Enter the choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                   boolean isValidflightNumber = true; 
                   sc.nextLine();
                   System.out.print("Enter the departure city: ");
                   String departure = sc.nextLine();
                   System.out.print("Enter the destination city: ");
                   String destination = sc.nextLine();
                   System.out.print("Enter the available seats: ");
                   int seats = sc.nextInt();
                   //taking the flight number input until user enters a flight number
                   do {
                        System.out.print("Enter the flight Number: ");
                        int n = sc.nextInt();      
                        Flight f = new Flight(n, departure, destination, seats);
                    try{
                        r.addFlight(f);
                        isValidflightNumber = false;
                     }
                   catch (ReservationException e) {
                        System.out.println(e);
                        System.out.println("Please add a flight with different number!!");
                     }
                   } while (isValidflightNumber);
                    break;
                case 2:
                    r.displayAllFlightInfo();
                    break;
                case 3:
                   System.out.print("Enter the flight number in which you want to reserve seat: ");
                   int flightNum = sc.nextInt();
                   System.out.print("Enter your adhar card number: ");
                   int adhar = sc.nextInt();
                   r.reserving(adhar, flightNum);
                   break;

                case 4:
                   System.out.print("Enter your adhar card number: ");
                   int a = sc.nextInt();
                   r.cancelling(a);
                   break;

                case 5:
                   flag = false;
                   break;

                default:
                    System.out.println("Invalid input!!");
                    break;
            }
        } while (flag);

        sc.close();
    }
}
