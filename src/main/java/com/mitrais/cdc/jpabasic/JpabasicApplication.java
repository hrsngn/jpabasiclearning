package com.mitrais.cdc.jpabasic;

import com.mitrais.cdc.jpabasic.model.unidirectional.PostUni;
import com.mitrais.cdc.jpabasic.model.unidirectional.PostCommentUni;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class JpabasicApplication {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(JpabasicApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void doSomethingAfterStartup() {
//		PostUni post = new PostUni();
//		post.setTitle("First Post");
//		post.getComments().add(
//				new PostCommentUni("First Review")
//		);
//		post.getComments().add(
//				new PostCommentUni("Second Review")
//		);
//		em.persist(post);
//		System.out.println("complete insert");
//	}
}
