import java.util.HashMap;

//reservation system class
public class ReservationSystem {
   private HashMap<Integer,Flight> flights = new HashMap<>();
   private HashMap<Integer , Integer > bookings= new HashMap<>();

   //function to add flight
    public void addFlight(Flight f) throws ReservationException{
     
            if (flights.containsKey(f.getFlightNum())) {
                  throw new ReservationException("Flight with this id already exist!");
            }
            flights.put(f.getFlightNum(), f);
            System.out.println("Flight successfully added!!");
     
    }

    //function to reserve the seat
    public void reserving(int adhar , int flightNum){
          try{
            if (!flights.containsKey(flightNum)) {
                  throw new ReservationException("Flight with this id doesn't exist!");
            }
            if(bookings.containsKey(adhar) && flights.containsKey(flightNum)){
                  throw new ReservationException("The flight number "+flightNum+" is already booked with the given adhar");
            }
            bookings.put(adhar,flightNum);
            Flight f = flights.get(flightNum);
            if (f.getAvailableSeats() ==0 ) {
                  throw new ReservationException("Flight is completely booked!!");
            }
            f.setAvailableSeats(f.getAvailableSeats()-1);
            System.out.println("Seat reserved successfully!!");
          }
          catch(ReservationException e){
            System.out.println(e);
          }
          catch (Exception e) {
            e.printStackTrace();
         }  
    }

    //fucntion to cancel the seat
    public void cancelling(int adhar){
        try{
            if (!bookings.containsKey(adhar)) {
                  throw new ReservationException("You trying to cancel reservation that hasn't made!!");
                }
                int flightNum =  bookings.get(adhar);
                Flight f = flights.get(flightNum);
                f.setAvailableSeats(f.getAvailableSeats()+1);
                bookings.remove(adhar);
                System.out.println("Seat cancelled successfully!!");
        }
        catch(ReservationException e){
            System.out.println(e);
          }
          catch (Exception e) {
            e.printStackTrace();
         }  
    }

    //function to display all flights info
    public void displayAllFlightInfo(){
      try{
            if(flights.size()==0){
                  throw new ReservationException("No flights available!!");
                }
                System.out.println("Here is the info of all availble flights: ");
                for (Flight f : flights.values()) {
                     f.getDetails(f);
                }
      }
      catch(ReservationException e){
            System.out.println(e);
      } catch (Exception e) {
            e.printStackTrace();
      }
    }

} 
