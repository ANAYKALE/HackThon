package daos;

import java.util.List;

import entities.movie;
import entities.review;
import entities.user;

public interface userDao extends AutoCloseable {
	user findByEmail(String email) throws Exception;
	List<review> DisplayAllReview() throws Exception;
	List<review> DisplayMyReview(int id) throws Exception;
	int save(user u) throws Exception;
	int UpdateProfile(user u) throws Exception;
	int writeReview(review r) throws Exception;
	int changePassword(int id,String changePassword) throws Exception;
	int editReview(int id,String editReview) throws Exception;
	List<movie> displayAllMovie() throws Exception;
	List<String>displayRvwShareWithMe() throws Exception;
	int deleteById(int id) throws Exception;
	
}
