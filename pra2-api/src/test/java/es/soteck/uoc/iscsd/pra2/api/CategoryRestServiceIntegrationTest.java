package es.soteck.uoc.iscsd.pra2.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.soteck.uoc.iscsd.pra2.ejb.pojo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryRestServiceIntegrationTest {
	protected ObjectMapper mapper = new ObjectMapper();

	private static final String BASE_URI = "http://localhost:8080/api/services/";
	private static final Class<CategoryVO> objectClass = CategoryVO.class;
	private static final Class<?> arayClass = Array.newInstance(CategoryVO.class, 0).getClass();

	private static final String[][] TEST_DATA = new String[][]{
			{"Libros", "Categoria original de libros"},
			{"Musica", "Cat orig de musica"},
	};

	@Test
	@Order(1)
	public void insertTest() throws IOException {
		for (int i = 0; i < TEST_DATA.length; i++) {
			HttpPost request = new HttpPost(BASE_URI + "category");
//			request.setHeader("Content-Type", MediaType.APPLICATION_JSON);

			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("name", TEST_DATA[i][0]));
			params.add(new BasicNameValuePair("description", TEST_DATA[i][1]));
			request.setEntity(new UrlEncodedFormEntity(params));

			HttpResponse response = HttpClientBuilder.create().build().execute(request);
			String jsonFromResponse = EntityUtils.toString(response.getEntity());

			CategoryVO result = mapper.readValue(jsonFromResponse, objectClass);
			log.info("Categoria añadida:  " + i + ". N: " + result.getName() + ". D: " + result.getDescription());
		}

	}

	@Test
	@Order(2)
	public void getListTest() throws IOException {
		HttpGet request = new HttpGet(BASE_URI + "category");

		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());

		CategoryVO[] result = (CategoryVO[]) mapper.readValue(jsonFromResponse, arayClass);

		int i = 0;
		for (CategoryVO category : result) {
			i++;
			log.info("Listando categorias: Categoria " + i + ". N: " + category.getName() + ". D: " + category.getDescription());
		}
	}


	@Test
	@Order(3)
	public void updateTest() throws IOException {
		HttpPut request = new HttpPut(BASE_URI + "category/" + TEST_DATA[0][0]);

		List<NameValuePair> params = new ArrayList<>();
//		params.add(new BasicNameValuePair("name", TEST_DATA[0][0]));
		params.add(new BasicNameValuePair("description", "Categoria actualizada "));
		request.setEntity(new UrlEncodedFormEntity(params));

		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());

		CategoryVO result = mapper.readValue(jsonFromResponse, objectClass);
		log.info("Categoria actualizada. N: " + result.getName() + ". D: " + result.getDescription());
	}


	@Test
	@Order(4)
	public void getListTest2() throws IOException {
		HttpGet request = new HttpGet(BASE_URI + "category");

		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		String jsonFromResponse = EntityUtils.toString(response.getEntity());

		CategoryVO[] result = (CategoryVO[]) mapper.readValue(jsonFromResponse, arayClass);

		int i = 0;
		for (CategoryVO category : result) {
			i++;
			log.info("Listando categorias:  Categoria " + i + ". N: " + category.getName() + ". D: " + category.getDescription());
		}
	}

	@Test
	@Order(5)
	public void deleteTest() throws IOException {
		for (int i = 0; i < TEST_DATA.length; i++) {
			HttpDelete request = new HttpDelete(BASE_URI + "category/" + TEST_DATA[i][0]);


			HttpResponse response = HttpClientBuilder.create().build().execute(request);
			String jsonFromResponse = EntityUtils.toString(response.getEntity());

//			CategoryVO result =  mapper.readValue(jsonFromResponse, objectClass);
			log.info("Categoria eliminada:  " + i + ". R: " + jsonFromResponse);
		}

	}
}
