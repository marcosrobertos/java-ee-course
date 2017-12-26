/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macrob.course.jee.restfull;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class MyClient {

	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		try {
			System.out.println("*** Create a new Customer ***");
			String xml = "<customer>"
					  + "<first-name>Bill</first-name>"
					  + "<last-name>Burke</last-name>"
					  + "<street>256 Clarendon Street</street>"
					  + "<city>Boston</city>"
					  + "<state>MA</state>"
					  + "<zip>02115</zip>"
					  + "<country>USA</country>"
					  + "</customer>";
			Response response = client.target(
					  "http://localhost:8080/java-ee-course/services/customers")
					  .request().post(Entity.xml(xml));
			System.out.println(response.getStatusInfo().getReasonPhrase());
			if (response.getStatus() != 201) {
				throw new RuntimeException(
						  "Failed to create");
			}
			String location = response.getLocation().toString();
			System.out.println("Location: " + location);
			response.close();
			System.out.println("*** GET Created Customer **");
			String customer = client.target(location).request().get(String.class);
			System.out.println(customer);
			String updateCustomer = "<customer>"
					  + "<first-name>William</first-name>"
					  + "<last-name>Burke</last-name>"
					  + "<street>256 Clarendon Street</street>"
					  + "<city>Boston</city>"
					  + "<state>MA</state>"
					  + "<zip>02115</zip>"
					  + "<country>USA</country>"
					  + "</customer>";
			response = client.target(location)
					  .request()
					  .put(Entity.xml(updateCustomer));

			if (response.getStatus() != 204) {
				throw new RuntimeException("Failed to update");
			}
			response.close();
			System.out.println("**** After Update ***");
			customer = client.target(location).request().get(String.class);
			System.out.println(customer);
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			client.close();
		}
	}
}
