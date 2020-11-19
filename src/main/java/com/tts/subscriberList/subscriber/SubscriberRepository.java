package com.tts.subscriberList.subscriber;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
	List<Subscriber> findByUserName(String userName);
	List<Subscriber> findByLastName(String lastName);
}