package entities;

import java.sql.Date;
import java.sql.Timestamp;

public class review {
private int id;
private int movie_id;
private String review;
private int rating;
private int user_id;
private Timestamp modified;

Timestamp timestamp = new Timestamp(System.currentTimeMillis());
public review() {
	
}
public review(String review) {
	this.review=review;
}
public review(int id,int movie_id,String review,int rating,int user_id,Timestamp timestamp)
{
	this.id=id;
	this.movie_id=movie_id;
	this.review=review;
	this.rating=rating;
	this.user_id=user_id;
	this.modified=timestamp;
	
	
}
public void setId(int id) {
	this.id = id;
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public void setReview(String review) {
	this.review = review;
}
public void setRating(int rating) {
	this.rating = rating;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public void setModified(Timestamp modified) {
	this.modified = modified;
}
public int getId() {
	return id;
}
public int getMovie_id() {
	return movie_id;
}
public String getReview() {
	return review;
}
public int getRating() {
	return rating;
}
public int getUser_id() {
	return user_id;
}
public Timestamp getModified() {
	return modified;
}
@Override
public String toString() {
	return "review [id=" + id + ", movie_id=" + movie_id + ", review=" + review + ", rating=" + rating + ", user_id="
			+ user_id + ", modified=" + modified + "]";
}
}


