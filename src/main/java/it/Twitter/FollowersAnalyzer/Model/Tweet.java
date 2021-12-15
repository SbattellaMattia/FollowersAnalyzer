package it.Twitter.FollowersAnalyzer.Model;

public class Tweet extends Super{

	private int likes;
	private String text;
	
	public Tweet(String id) {
		super(id);
	}

	public int getLikes() {
		return likes;
	}

	public String getText() {
		return text;
	}
	
}