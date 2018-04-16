package ph.com.dsm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new Mongo("localhost");
	}

	@Override
	public MongoTemplate mongoTemplate() throws Exception {
		// TODO Auto-generated method stub
		return new MongoTemplate(mongo(),"yourdb","yourCollection");
	}

}
