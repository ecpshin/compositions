package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> coments = new ArrayList<>();
	
	public Post() {
	}
	
	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}	
	
	public List<Comment> getComents() {
		return coments;
	}

	public void addComent(Comment coment) {
		this.coments.add(coment);
	}
	
	public void removeComent(Comment coment) {
		this.coments.remove(coment);
	}

	@Override
	public String toString() {
	    
		StringBuilder sb = new StringBuilder();
	    
		sb.append(title + "\n")
	    .append(likes)
	    .append(" Likes - ")
	    .append(SDF.format(moment))
	    .append("\n")
	    .append(content + "\n").append("Comments:\n");
		
		for (Comment c : coments) {
			sb.append(c.getText() + "\n");
		}
		
		return sb.toString();
	}

}
