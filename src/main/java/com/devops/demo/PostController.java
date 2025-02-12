package com.devops.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class PostController {
	@GetMapping("/post/{uid}")
	public Post getPost(@PathVariable("uid") String uid) {
		
		return RestClient.builder().build().get()
				.uri("https://jsonplaceholder.typicode.com/posts/"+uid).retrieve().body(Post.class);
	}

}
