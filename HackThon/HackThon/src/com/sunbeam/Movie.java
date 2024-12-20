package com.sunbeam;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import daos.userDao;
import daos.userDaoImp;
import entities.movie;
import entities.review;
import entities.user;

public class Movie {
	public static Scanner sc=null;
	public static user curUser=null;
	public static Timestamp timestamp ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 sc=new Scanner(System.in);
			while(true) {
				System.out.println("0.Exit\n1. Sign In\n2. Sign Up\nEnter choice:");
				int choice=sc.nextInt();
				switch(choice) {
				case 0:
					System.exit(0);
					break;
				case 1:
					Authenticate();
					break;
				case 2:UserSignUp();
					break;
					
				}
			}
	}
	private static void UserSignUp() {
		// TODO Auto-generated method stub
		try(userDao userDao = new userDaoImp()) {
		System.out.print("Enter first name: ");
		String fName = sc.next();
		System.out.print("Enter last name: ");
		String lName = sc.next();
		System.out.print("Enter email: ");
		String email = sc.next();
		System.out.print("Enter mobile: ");
		String mobile = sc.next();
		System.out.print("Enter birth date (yyyy-MM-dd): ");
		String birth = sc.next();
		Date birthDate = Date.valueOf(birth);
		System.out.print("Enter passwd: ");
		String passwd = sc.next();
		user u = new user(0, fName, lName, email, mobile, birthDate, passwd);
		int count = userDao.save(u);
		System.out.println("User Saved: " + count);
	} // userDao.close();
	catch (Exception e) {
		e.printStackTrace();
	}

	}
	private static void Authenticate() {
		// TODO Auto-generated method stub
		
		
		try(userDao userDao=new userDaoImp())
		{
			System.out.println("Enter Email:");
			String email=sc.next();
			System.out.println("Enter Password");
			String pass=sc.next();
			
			user u=userDao.findByEmail(email);
			if(u!=null&&u.getPassword().equals(pass))
			{
				System.out.println("Login Successfully");
				curUser=u;
				userMenu();
			}
			else {
				System.out.println("Login Failed");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void userMenu() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("\n0. Log Out\n1. Edit Profile\n2. Change Password\n3. Write a Review\n4.Edit Review\n5.Display all Movies\n6.Display all Reviews\n7.Display my Reviews\n8.Display Reviews share with me\n9.Share a Review\n10.Delete a Review Enter choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 0: // Sign Out
				curUser = null;
				return;
			case 1: // Edit Profile
				EditProfile();
				break;
			case 2:ChangePassword();
				break;
			case 3:WriteReview();
			break;
			case 4:EditReview();
			break;
			case 5:DisplayAllMovie();
			break;
			case 6:DisplayAllReviews();
			break;
			case 7:
				DisplayMyReviews();
				break;
			case 8:
				DisplayReviewSharewithMe();
				break;
			case 9:
				break;
			case 10:Deletereview();
			}
		}
	}
	private static void Deletereview() {
		// TODO Auto-generated method stub
		 try(userDao userDao = new userDaoImp()) {
			 System.out.print("Enter Id (to delete): ");
			 int id = sc.nextInt();
			 int rvw = userDao.deleteById(id);
			 System.out.println("Review Deleted: " + rvw);
			 }
			 catch (Exception e) {
			 e.printStackTrace();
			 }
	}
	private static void DisplayReviewSharewithMe() {
		// TODO Auto-generated method stub
		List<String> list;
		try(userDao userDao = new userDaoImp()) {
			
			
			list = userDao.displayRvwShareWithMe();
			list.forEach(System.out::println);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	private static void DisplayMyReviews() {
		// TODO Auto-generated method stub
		try(userDao userDao=new userDaoImp())
		{
			List<review> list=userDao.DisplayMyReview(curUser.getId());
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void DisplayAllReviews() {
		// TODO Auto-generated method stub
		try(userDao userDao=new userDaoImp())
		{
			List<review> list=userDao.DisplayAllReview();
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void DisplayAllMovie() {
		// TODO Auto-generated method stub
		try(userDao userDao = new userDaoImp()) {
			List<movie> list;
			
			list = userDao.displayAllMovie();
			list.forEach(System.out::println);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	private static void EditReview() {
		// TODO Auto-generated method stub
		try(userDao userDao = new userDaoImp()) {
			System.out.println("Edit Review: ");
			String review = sc.next();
			int count = userDao.editReview(curUser.getId(), review);
			System.out.println("Review Edited Successfully" + count);

			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	private static void WriteReview() {
		// TODO Auto-generated method stub
		try(userDao userDao=new userDaoImp())
		{
			System.out.println("Enter Movie id:");
			int movie_id=sc.nextInt();
			System.out.println("Enter Reviews:");
			String review=sc.next();
			System.out.println("Enter rating");
			int rating=sc.nextInt();
			review r=new review(0, movie_id, review, rating, curUser.getId(),timestamp);
			int count=userDao.writeReview(r);
			System.out.println("User Saved: " + count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private static void ChangePassword() {
		// TODO Auto-generated method stub
		try(userDao userDao = new userDaoImp()) {
			System.out.println("Enter Password to change: ");
			String password = sc.next();
			int count = userDao.changePassword(curUser.getId(), password);
			System.out.println("Password Change Successfully" + count);

			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	private static void EditProfile() {
		// TODO Auto-generated method stub
		try(userDao userDao = new userDaoImp()) {
		System.out.print("Enter first name: ");
		String fName = sc.next();
		System.out.print("Enter last name: ");
		String lName = sc.next();
		System.out.print("Enter email: ");
		String email = sc.next();
		System.out.print("Enter mobile: ");
		String mobile = sc.next();
		System.out.print("Enter birth date (yyyy-MM-dd): ");
		String birth = sc.next();
		Date birthDate = Date.valueOf(birth);
		System.out.print("Enter passwd: ");
		String passwd = sc.next();
		user u = new user(curUser.getId(), fName, lName, email, mobile, birthDate, passwd);
		int count = userDao.UpdateProfile(u);
		System.out.println("User Saved: " + count);
	} // userDao.close();
	catch (Exception e) {
		e.printStackTrace();
	}

	}

}
