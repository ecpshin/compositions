package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class ProgramPosts {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("Wow that' awesome!");
		
		Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Travelign to New Zeland", "I'm going to visit this woderful Country!", 12);
		p1.addComent(c1);
		p1.addComent(c2);
		
		
		Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), "Good night guys!", "See you tomorrow.", 5);
		p2.addComent(new Comment("Good night"));
		p2.addComent(new Comment("May the force be with you"));
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
