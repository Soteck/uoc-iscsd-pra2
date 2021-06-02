package es.soteck.uoc.iscsd.pra2.ejb.pojo;

public class CustomerDO implements java.io.Serializable 
{
   private static final long serialVersionUID = 1L;

   private int id;
   private String lname;
   private String fname;
    
   public CustomerDO(int id, String lname,
                    String fname) 
   {
      this.id = id;
      this.lname = lname;
      this.fname = fname;
   }
   public int getId()
   {
      return id;
   }
   public String getLname()
   {
      return lname;
   }
   public String getFname()
   {
      return fname;
   }
}
