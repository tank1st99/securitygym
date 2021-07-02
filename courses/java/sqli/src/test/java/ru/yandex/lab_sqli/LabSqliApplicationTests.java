package ru.yandex.lab_sqli;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LabSqliApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testFunctional() throws IOException{
		/*Random random = new Random();
		Path testPath = Files.createTempFile("bill", ".xml");
		String xml_content = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
			"<bill>\n";
		Integer totalPrice = 0;
		for(int i=0; i < 10; i++) {
			Integer price = random.nextInt(10000);
			Integer count = random.nextInt(10);
			totalPrice += count * price;

			xml_content += 
			"	<product id=\"" + i + "\">\n" +
			"		<name>Product " + i + "</name>\n" +
			"		<quantity>" + count +"</quantity>\n" +
			"		<price>" + price +"</price>\n" +
			"	</product>\n";
		}
		xml_content += "</bill>";
		Files.write(testPath, xml_content.getBytes());
		Resource testFile = new FileSystemResource(testPath.toFile());
		LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
		parameters.add("bill_xml", testFile);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(parameters, headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/bill", entity, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).contains(totalPrice.toString());
		if(response.getBody().contains(totalPrice.toString())){
			System.out.println("Functional tests are passed.");
		}*/
	}

	@Test
	public void testSQLiDefense() throws Exception{
		/*LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
		parameters.add("bill_xml", new org.springframework.core.io.ClassPathResource("bill_entity.xml"));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(parameters, headers);
		ResponseEntity<String> response = restTemplate.exchange("/bill", HttpMethod.POST, entity, String.class,
				"");
		
		assertThat(response.getBody()).doesNotContain("XXETESTXXE");
		if(!response.getBody().contains("XXETESTXXE")){
			System.out.println("Security tests are passed.");
		}*/
	}

}
