package com.movieplatform.movieservice;

import com.movieplatform.movieservice.constants.MovieStatus;
import com.movieplatform.movieservice.model.Movie;
import com.movieplatform.movieservice.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieServiceApplication implements CommandLineRunner {

	private final MovieRepository movieRepository;

	public MovieServiceApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Movie movie = Movie.builder()
				.name("Spiderman 2")
				.description("Spiderman")
				.movieStatus(MovieStatus.RELEASED)
				.releaseDate(Date.from(Instant.now()))
				.build();
		movieRepository.save(movie);
	}
}
