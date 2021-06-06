package es.soteck.uoc.iscsd.pra2.ejb.bean;


import es.soteck.uoc.iscsd.pra2.ejb.entity.Address;
import es.soteck.uoc.iscsd.pra2.ejb.entity.Customer;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.AddressDO;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CustomerDO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddressCustomerBean implements AddressCustomerRemote, AddressCustomerLocal {

	@PersistenceContext(unitName = "AccountAddress")
	private EntityManager entman;

	public CustomerDO newCustomer(int id, String lname, String fname) {
		CustomerDO cusReturn = null;
		Customer customer = new Customer(id, lname, fname);
		entman.persist(customer);

		cusReturn = new CustomerDO(customer.getId(), customer.getLastName(), customer.getFirstName());
		return cusReturn;
	}

	public AddressDO addAddress(int idCustomer, AddressDO newAddress) {
		AddressDO adReturn = null;
		Address address = new Address();

		address.setId(newAddress.getId());
		address.setStreet(newAddress.getStreet());
		address.setCity(newAddress.getCity());
		address.setState(newAddress.getState());
		address.setZip(newAddress.getZip());
		entman.persist(address);

		Customer custo = entman.find(Customer.class, idCustomer);

		if (custo != null) {
			custo.setAddress(address);

			adReturn = new AddressDO(custo.getAddress().getId(), custo.getAddress().getStreet(),
					custo.getAddress().getCity(), custo.getAddress().getState(), custo.getAddress().getZip());
		}
		return adReturn;
	}

	public AddressDO setAddress(int idCustomer) {
		AddressDO adReturn = null;

		Customer custo = entman.find(Customer.class, idCustomer);

		if (custo != null) {

			adReturn = new AddressDO(custo.getAddress().getId(), custo.getAddress().getStreet(),
					custo.getAddress().getCity(), custo.getAddress().getState(), custo.getAddress().getZip());
		}
		return adReturn;

	}

	public boolean removeCustomer(int idCustomer) {
		Customer custo = entman.find(Customer.class, idCustomer);
		boolean ok = false;

		if (custo != null) {
			entman.remove(custo);
			ok = true;
		}
		return ok;
	}

	public boolean removeAddress(int idAddress) {
		Address address = entman.find(Address.class, idAddress);
		boolean ok = false;

		if (address != null) {
			entman.remove(address);
			ok = true;
		}
		return ok;
	}

}
