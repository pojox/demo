package Tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Test05_api_schema {
	
	@Test (description = "Verify json schema", enabled = true)
	void verifyJsonSchema() {
		String baseURI = "https://api.picsart.com/localizations/en/messages?project=reusable_components,photo_editor";
		String schema_messages_json = "schema_messages.json";
		
		given()
			.header("accept", "text/html")
			.header("accept", "application/json");
		when()
			.get(baseURI)
		.then()
			.contentType(ContentType.JSON)
            .assertThat().statusCode(200)
            .body(matchesJsonSchemaInClasspath(schema_messages_json));
	}
}
