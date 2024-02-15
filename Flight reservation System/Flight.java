//Flight class
class Flight{
   private int flightNum;
   private String departureCity;
   private String destinationCity;
   private int AvailableSeats;

   //constructor
    public Flight(int flightNum, String departureCity, String destinationCity, int AvailableSeats) {
        this.flightNum = flightNum;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        try{
            if(AvailableSeats<=0){
                throw new ReservationException("Seats must be in positive numbers!!");
            }
            this.AvailableSeats = AvailableSeats;
        }
       catch(ReservationException e){
            System.out.println(e);
        } catch (Exception e) {
              e.printStackTrace();
        }
    }

    //getters
    public int getFlightNum() {
        return flightNum;
    }
    public String getDepartureCity() {
        return departureCity;
    }
    public String getDestinationCity() {
        return destinationCity;
    }
    public int getAvailableSeats() {
        return AvailableSeats;
    } 
    public int setAvailableSeats(int AvailableSeats) {
       return this.AvailableSeats= AvailableSeats;
    } 

    //function to get details of the flight
    public void  getDetails(Flight f){
        if(f.getAvailableSeats()>0){
            System.out.println("Flight number: "+f.getFlightNum()+", Departure city: "+f.getDepartureCity()+", Destination city: "+f.getDestinationCity()+"Available city: "+f.getAvailableSeats());
        }
    }
}

