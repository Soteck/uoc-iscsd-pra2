package es.soteck.uoc.iscsd.pra2.ejb.rmiclient;


import es.soteck.uoc.iscsd.pra2.ejb.bean.AddressCustomerRemote;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.AddressDO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Example showing use of relationship entity beans
 * 
 */

public class AddressCustoClient 
{

   public static void main(String [] args) throws Exception 
   {
		try
		{
			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL,"http-remoting://127.0.0.1:8080");
			jndiProps.put(Context.SECURITY_PRINCIPAL, "USER");
			jndiProps.put(Context.SECURITY_CREDENTIALS, "PASSWORD");
			jndiProps.put("jboss.naming.client.ejb.context", true);			
			
			Context ctx = new InitialContext(jndiProps);

    		AddressCustomerRemote beanRemote = (AddressCustomerRemote) ctx.lookup("java:pra2-ejb/AddressCustomerBean!es.soteck.uoc.iscsd.pra2.ejb.bean.AddressCustomer");

    		System.out.println("Creating Customer 1..");
    		// create a Customer
    		beanRemote.newCustomer(1, "Jenson", "Button");
 
    		// create an address data object
    		System.out.println("Creating AddressDO data object..");
    		AddressDO address = new AddressDO(1,"1010 Colorado","Austin", "TX", "78701");

    		// set address in Customer bean
    		System.out.println("Setting Address in Customer 1...");
    		beanRemote.addAddress(1, address);
    		
    		System.out.println("Acquiring Address data object from Customer 1...");
    		address = beanRemote.setAddress(1);
    		
    		System.out.println("Customer 1 Address data: ");
    		System.out.println(address.getStreet( ));
    		System.out.println(address.getCity( )+","+
                         address.getState()+" "+
                         address.getZip());


    		// create a new address
    		System.out.println("Creating new AddressDO data object..");
    		address = new AddressDO(2,"1600 Pennsylvania Avenue NW","DC", "WA", "20500");
  
    		// change customer's address
    		System.out.println("Setting new Address in Customer 1...");
    		beanRemote.addAddress(1, address);

    		address = beanRemote.setAddress(1);
    		System.out.println("Customer 1 Address data: ");
    		System.out.println(address.getStreet( ));
    		System.out.println(address.getCity( )+","+
                         address.getState()+" "+
                         address.getZip());

      // remove Customer to clean up
    		System.out.println("Removing Customer 1...");
    		beanRemote.removeCustomer(1);
    		beanRemote.removeAddress(1);
    		beanRemote.removeAddress(2);
    	
		} catch (NamingException e)
		{
			e.printStackTrace();
			/* I rethrow it as runtimeexception as there is really no need to continue if an exception happens and I
			 * do not want to catch it everywhere.
			 */ 
		throw new RuntimeException(e);
		}
   }
    

}
