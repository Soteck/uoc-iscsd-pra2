package es.soteck.uoc.iscsd.pra2.rmiclient;


import es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryRemote;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;
import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

@Slf4j
public class CategoryRMIClient {

	public static void main(String[] args) throws Exception {
		CategoryRMIClient client = new CategoryRMIClient();
		try {
			client.run();
		} catch (NamingException e) {
			log.error("Error", e);
			throw new RuntimeException(e);
		}
	}

	protected void run() throws NamingException {
		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProps.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		jndiProps.put(Context.SECURITY_PRINCIPAL, "USER");
		jndiProps.put(Context.SECURITY_CREDENTIALS, "PASSWORD");
		jndiProps.put("jboss.naming.client.ejb.context", true);

		Context ctx = new InitialContext(jndiProps);

		CategoryRemote beanRemote = (CategoryRemote) ctx.lookup("java:pra2-ear/pra2-ejb/CategoryBean!es.soteck.uoc.iscsd.pra2.ejb.bean.CategoryRemote");

		log.info("Creando categoria lirica");
		beanRemote.add("Lirico", "Eventos líricos ya sea operísticos o teatrales");


		log.info("Creando categoria musical");
		beanRemote.add("Musical", "Eventos musicales ya sean en directo o exclusivos");

		log.info("Listando categorias: ");
		this.listar(beanRemote);

		log.info("Modificando categoria musical");
		beanRemote.update("Musical", "Eventos modificados!!!");

		log.info("Listando catgegorias con modificacion");
		this.listar(beanRemote);

		log.info("Eliminando categoria Lirico");
		beanRemote.delete("Lirico");

		log.info("Listando categorias con borrado:");
		this.listar(beanRemote);

		log.info("Borrando Musical");
		beanRemote.delete("Musical");


	}

	private void listar(CategoryRemote beanRemote) {
		List<CategoryVO> categorias = beanRemote.list();
		int i = 0;
		for (CategoryVO category : categorias) {
			i++;
			log.info("Categoria " + i + ". N: " + category.getName() + ". D: " + category.getDescription());
		}
	}

}
