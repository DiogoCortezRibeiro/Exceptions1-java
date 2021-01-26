package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;
import models.excepetions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			System.out.println();
			
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println(reserva);
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			System.out.println();
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println(reserva);
		}catch(ParseException e) {
			System.out.println("Invalid date format!!");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
			
		sc.close();
	}

}
