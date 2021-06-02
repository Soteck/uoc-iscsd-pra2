package es.soteck.uoc.iscsd.pra2.ejb.pojo;

public class AddressDO implements java.io.Serializable 
{
   private static final long serialVersionUID = 1L;

   private int id;
   private String street;
   private String city;
   private String state;
   private String zip;
    
   public AddressDO(int id, String street, String city,
                    String state, String zip ) 
   {
      this.id = id;
	  this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
   }
   public int getId() {
	   return id;
   }
   public String getStreet()
   {
      return street;
   }
   public String getCity()
   {
      return city;
   }
   public String getState()
   {
      return state;
   }
   public String getZip()
   {
      return zip;
   }
}