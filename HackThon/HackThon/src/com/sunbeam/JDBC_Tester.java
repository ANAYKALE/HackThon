package com.sunbeam;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import daos.userDao;
import daos.userDaoImp;
import entities.review;
import entities.user;

public class JDBC_Tester {
	public static user curUser;
	public static Timestamp timestamp ;
   public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
//	try(userDao userDao=new userDaoImp())
//	{
//		System.out.println("Enter Email:");
//		String email=sc.next();
//		System.out.println("Enter Password");
//		String pass=sc.next();
//		
//		user u=userDao.findByEmail(email);
//		if(u!=null&&u.getPassword().equals(pass))
//		{
//			System.out.println("Login Successfully");
//			//curUser=u;
//			//userMenu();
//		}
//		else {
//			System.out.println("Login Failed");
//		}
//		
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	try(userDao userDao=new userDaoImp())
//	{
//		List<review> list=userDao.DisplayAllReview();
//		list.forEach(System.out::println);
//		
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//	try(userDao userDao=new userDaoImp())
//	{
//		List<review> list=userDao.DisplayMyReview(2);
//		list.forEach(System.out::println);
//		
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
		//SIGNUP	
//	try(userDao userDao = new userDaoImp()) {
//		System.out.print("Enter first name: ");
//		String fName = sc.next();
//		System.out.print("Enter last name: ");
//		String lName = sc.next();
//		System.out.print("Enter email: ");
//		String email = sc.next();
//		System.out.print("Enter mobile: ");
//		String mobile = sc.next();
//		System.out.print("Enter birth date (yyyy-MM-dd): ");
//		String birth = sc.next();
//		Date birthDate = Date.valueOf(birth);
//		System.out.print("Enter passwd: ");
//		String passwd = sc.next();
//		user u = new user(0, fName, lName, email, mobile, birthDate, passwd);
//		int count = userDao.save(u);
//		System.out.println("User Saved: " + count);
//	} // userDao.close();
//	catch (Exception e) {
//		e.printStackTrace();
//	}
	
	//updateProfile	
//	try(userDao userDao = new userDaoImp()) {
//		System.out.print("Enter first name: ");
//		String fName = sc.next();
//		System.out.print("Enter last name: ");
//		String lName = sc.next();
//		System.out.print("Enter email: ");
//		String email = sc.next();
//		System.out.print("Enter mobile: ");
//		String mobile = sc.next();
//		System.out.print("Enter birth date (yyyy-MM-dd): ");
//		String birth = sc.next();
//		Date birthDate = Date.valueOf(birth);
//		System.out.print("Enter passwd: ");
//		String passwd = sc.next();
//		user u = new user(3, fName, lName, email, mobile, birthDate, passwd);
//		int count = userDao.UpdateProfile(u);
//		System.out.println("User Saved: " + count);
//	} // userDao.close();
//	catch (Exception e) {
//		e.printStackTrace();
//	}

	
	
	try(userDao userDao=new userDaoImp())
	{
		System.out.println("Enter Movie id:");
		int movie_id=sc.nextInt();
		System.out.println("Enter Reviews:");
		String review=sc.next();
		System.out.println("Enter rating");
		int rating=sc.nextInt();
		review r=new review(0, movie_id, review, rating, 3,timestamp);
		int count=userDao.writeReview(r);
		System.out.println("User Saved: " + count);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	//System.out.println(timestamp);
	
}
}
