package it.photo.album;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.photo.album.core.AlbumInsertion;

@SpringBootApplication
public class PhotoAlbumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAlbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Integer> index = Arrays.asList(0,1,2,1,2);
		List<Integer> identity = Arrays.asList(0,1,2,3,4);
		
		System.out.println(new AlbumInsertion().photoAlbum(index, identity));
	}

}
