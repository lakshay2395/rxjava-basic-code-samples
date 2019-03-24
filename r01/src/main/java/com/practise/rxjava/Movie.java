package com.practise.rxjava;

public class Movie {
	
	public String name;
	
	public Integer ratings;
	
	public String synopsis;

	public Movie() {
		super();
	}

	public Movie(String name, Integer ratings, String synopsis) {
		super();
		this.name = name;
		this.ratings = ratings;
		this.synopsis = synopsis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", ratings=" + ratings + ", synopsis=" + synopsis + "]";
	}

}
