package ph.com.dsm.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;

import ph.com.dsm.config.SpringMongoConfig;
import ph.com.dsm.user.User;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringMongoConfig.class);

		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		User user = new User("1001", "yong", "mook kim", 30);

		mongoOperation.save("userprofile", user);

		User savedUser = mongoOperation.findOne("userprofile", new Query(
				Criteria.where("id").is("1001")), User.class);
		
		System.out.println("savedUser : " + savedUser);
	}

}
