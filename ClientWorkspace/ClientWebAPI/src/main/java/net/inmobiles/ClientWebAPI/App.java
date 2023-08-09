package net.inmobiles.ClientWebAPI;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class App {
	
	private final OkHttpClient client = new OkHttpClient();
	private String listAllURL = "http://localhost:1559/class/list";
	private String searchByIdURL = "http://localhost:1559/class/";
	private String addURL = "http://localhost:1559/class/add";
	private String updateURL = "http://localhost:1559/class/update";
	private String deleteURL = "http://localhost:1559/class/delete";
	
	public void listAll() {		
		Request listAllRequest = new Request.Builder().url(listAllURL).build();
		
		try {
			Response response = client.newCall(listAllRequest).execute();
			String jsonFormat = response.body().string();
						
			Gson gson = new GsonBuilder().create();
			Name[] names = gson.fromJson(jsonFormat, Name[].class);
			
			for (int i = 0; i < names.length; i++) {				
				System.out.println(names[i].toString());		
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void searchNameById() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID: ");
		String id = scanner.nextLine();
		
		Request request = new Request.Builder().url(searchByIdURL + id).build();
		
		try {
			Response response = client.newCall(request).execute();
			String jsonFormat = response.body().string();
						
			Gson gson = new GsonBuilder().create();
			Name name = gson.fromJson(jsonFormat, Name.class);
			
			System.out.println(name.toString());
			
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
//	public void addName() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the name: ");
//		String name = scanner.nextLine();
//		
//		RequestBody body = RequestBody.create(Gson, gson);
//		
//		
//	}
	
	public void disconnect() {
		System.out.println("Client disconnected");
		System.exit(0);
	}
	
	public void run() {
		int flag = 1;
		int option;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		while(flag == 1) {
			System.out.println();
			System.out.println("1. List All");
			System.out.println("2. Search by ID");
			System.out.println("3. Add Name");
			System.out.println("4. Update Name");
			System.out.println("5. Delete Name");
			System.out.println("6. Exit");
			System.out.println("---------------");
			System.out.println("Enter your choice: ");
			
			option = scanner.nextInt();
			
			switch(option) {		
				case 1:
					listAll();
					break;
				
				case 2:
					searchNameById();
					break;
					
				case 3:
					//addName();
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					disconnect();
					break;
				
				default:
					break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		App client = new App();
		client.run();
	}
}
