package es.soteck.uoc.iscsd.pra2.ejb.bean;

import es.soteck.uoc.iscsd.pra2.ejb.pojo.AddressDO;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CustomerDO;

import javax.ejb.Local;

@Local
public interface AddressCustomerLocal {
	
	public CustomerDO newCustomer(int id, String lname, String fname);
	
	public AddressDO addAddress(int idCustomer, AddressDO newAddress);
	
	public AddressDO setAddress(int idCustomer);
	
	public boolean removeCustomer (int idCustomer);

	public boolean removeAddress (int idAddress);

}
