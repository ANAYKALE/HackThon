package daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entities.movie;
import entities.review;
import entities.user;

public class userDaoImp extends Dao implements userDao {
	private PreparedStatement smtFindByEmail;
	private PreparedStatement smtDispAllReview;
	private PreparedStatement smtDispMyReview;
	private PreparedStatement smtSave;
	private PreparedStatement smtUpdate;
	private PreparedStatement smtWriteReview;
	private PreparedStatement stmtChangePassword;
	private PreparedStatement stmtEditReview;
	private PreparedStatement stmtDisplayAllMovie;
	private PreparedStatement stmtDisplayRvwShareWithMe;
	private PreparedStatement stmtDeleteById;
	
	public userDaoImp() throws Exception {
	
		// TODO Auto-generated constructor stub
		String sqlFindByEmail="select * from users where email=?";
		smtFindByEmail=con.prepareStatement(sqlFindByEmail);
		String sqlDispAllRev="select * from reviews";
		smtDispAllReview=con.prepareStatement(sqlDispAllRev);
		String sqlDispMyRev="select * from reviews where user_id=?";
		smtDispMyReview=con.prepareStatement(sqlDispMyRev);
		String sqlSave = "INSERT INTO users (first_name, last_name, email, mobile,birth,password) VALUES(?, ?, ?, ?, ?, ?)";
		smtSave = con.prepareStatement(sqlSave);
		String sqlUpdateProfile="update users set first_name=?, last_name=?, email=?, mobile=?,birth=?,password=? where id=?";
		smtUpdate=con.prepareStatement(sqlUpdateProfile);
		String sqlwriteReview="insert into reviews(movie_id,review,rating,user_id,modified) values(?,?,?,?,?) ";
		smtWriteReview=con.prepareStatement(sqlwriteReview);
		String sqlChangePassword = "UPDATE users SET password=? WHERE id=?";
		stmtChangePassword = con.prepareStatement(sqlChangePassword);
		String sqlEditReview = "UPDATE reviews SET review=? WHERE user_id=?";
		stmtEditReview = con.prepareStatement(sqlEditReview);
		String sqlDisplayAllMovie = "SELECT * FROM movies";
		stmtDisplayAllMovie = con.prepareStatement(sqlDisplayAllMovie);
		String sqlDisplayRvwShareWithMe = "select review from reviews r,shares s where r.user_id=s.user_id";
		stmtDisplayRvwShareWithMe = con.prepareStatement(sqlDisplayRvwShareWithMe);
		String sqlDeleteById = "DELETE FROM reviews WHERE id=?";
		stmtDeleteById = con.prepareStatement(sqlDeleteById);
		
	}
	public void close() throws Exception{
		
		smtFindByEmail.close();
		
	}
	@Override
	public user findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		smtFindByEmail.setString(1, email);
		try(ResultSet rs=smtFindByEmail.executeQuery()){
			if(rs.next()) {
			int id=rs.getInt("id");
			String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			email=rs.getString("email");
			String mobile=rs.getString("mobile");;
			Date birth = rs.getDate("birth");
			String password = rs.getString("password");
			
			user u=new user(id, firstName, lastName, email, mobile, birth, password);
			return u;
		}
			
		}
		return null;
	}
	@Override
	public List<review> DisplayAllReview() throws Exception {
		// TODO Auto-generated method stub
		List<review> list=new ArrayList<review>();
		try(ResultSet rs=smtDispAllReview.executeQuery())
		{
			while(rs.next())
			{
				int id=rs.getInt("id");
				int movie_id=rs.getInt("movie_id");
				String review=rs.getString("review");
				int rating=rs.getInt("rating");
				int user_id=rs.getInt("user_id");
				Timestamp modified=rs.getTimestamp("modified");
				
				review r=new review(id, movie_id, review, rating, user_id, modified);
				list.add(r);
			}
		}
		
		return list;
		
	}
	@Override
	public List<review> DisplayMyReview(int id1) throws Exception {
		// TODO Auto-generated method stub
		smtDispMyReview.setInt(1, id1);
		List<review> list=new ArrayList<review>();
		try(ResultSet rs=smtDispMyReview.executeQuery())
		{
			while(rs.next())
			{
				int id=rs.getInt("id");
				int movie_id=rs.getInt("movie_id");
				String review=rs.getString("review");
				int rating=rs.getInt("rating");
				int user_id=rs.getInt("user_id");
				Timestamp modified=rs.getTimestamp("modified");
				
				review r=new review(review);
				list.add(r);
			}
		}
		
		return list;
	}
	@Override
	public int save(user u) throws Exception {
		// TODO Auto-generated method stub
		smtSave.setString(1, u.getFirst_name());
		smtSave.setString(2, u.getLast_name());
		smtSave.setString(3, u.getEmail());
		smtSave.setString(4, u.getMobile());
		smtSave.setDate(5, u.getBirth());
		smtSave.setString(6, u.getPassword());
		int count=smtSave.executeUpdate();
		return count;
		
	}
	@Override
	public int UpdateProfile(user u) throws Exception {
		// TODO Auto-generated method stub
		smtUpdate.setString(1, u.getFirst_name());
		smtUpdate.setString(2, u.getLast_name());
		smtUpdate.setString(3, u.getEmail());
		smtUpdate.setString(4, u.getMobile());
		smtUpdate.setDate(5, u.getBirth());
		smtUpdate.setString(6, u.getPassword());
		smtUpdate.setInt(7, u.getId());
		int count=smtUpdate.executeUpdate();
		return count;
	}
	@Override
	public int writeReview(review r) throws Exception {
		// TODO Auto-generated method stub
		smtWriteReview.setInt(1,r.getMovie_id());
		smtWriteReview.setString(2,r.getReview());
		smtWriteReview.setInt(3,r.getRating());
		smtWriteReview.setInt(4, r.getUser_id());
		smtWriteReview.setTimestamp(5,  Timestamp.valueOf(LocalDateTime.now()));
		
		int count=smtWriteReview.executeUpdate();
		return count;
	}
	@Override
	public int changePassword(int id, String changePassword) throws Exception {
	// TODO Auto-generated method stub
	stmtChangePassword.setString(1, changePassword);
	stmtChangePassword.setInt(2, id);
	int count=stmtChangePassword.executeUpdate();
	return count;
	}
	
	public int editReview(int id, String editReview) throws Exception {
		// TODO Auto-generated method stub
		stmtEditReview.setString(1, editReview);
		stmtEditReview.setInt(2, id);
		int count=stmtEditReview.executeUpdate();
		return count;
		}
	
	@Override
	public List<movie> displayAllMovie() throws Exception {
	List<movie> list = new ArrayList<movie>();
	try(ResultSet rs = stmtDisplayAllMovie.executeQuery()) {
	while(rs.next()) {
	int id = rs.getInt("id");
	String title = rs.getString("title");
	Date rel_date = rs.getDate("rel_date");

	movie m = new movie(id, title, rel_date);
	list.add(m);
	}
	} // rs.close();
	return list;
	}
	
	@Override
	public List<String> displayRvwShareWithMe() throws Exception {
	List<String> list = new ArrayList<String>();
	try(ResultSet rs = stmtDisplayRvwShareWithMe.executeQuery()) {
	while(rs.next()) {
	String review = rs.getString("review");
	//shares s = new shares();
	review r=new review(review);
	list.add( r.getReview());
	}
	} // rs.close();
	return list;
	}
	
	public int deleteById(int id) throws Exception {
		stmtDeleteById.setInt(1, id);
		int count = stmtDeleteById.executeUpdate();
		return count;
		}
}
