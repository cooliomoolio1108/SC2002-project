package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable{
    /**
	 * Java Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id number of movie
	 */
	private int movieID;
	/**
	 * Title of movie
	 */
    private String title;
    /**
     * Director name of movie
     */
    private String director;
    /**
     * List of cast acting in the movie
     */
    private ArrayList<String> casts;
    /**
     * Brief synopsis of movie
     */
    private String movieContent;
    /**
     * Duration of the movie
     */
    private double duration;
    /**
     * State of the movie screening
     */
    private MovieStates state;
    /**
     * Constructor
     * @param movieID
     * @param title
     * @param director
     * @param casts
     * @param movieContent
     * @param duration
     * @param state
     */
    public Movie(int movieID, String title, String director, ArrayList<String> casts, 
    		String movieContent, double duration, MovieStates state) {
    	this.movieID = movieID;
    	this.title = title;
    	this.director = director;
    	this.casts = casts;
    	this.movieContent = movieContent;
    	this.duration = duration;
    	this.state = state;

    }
    /**
     * Get and return a copy of the movie
     * @param another
     * @return movie
     */
    public static Movie copy(Movie another) {
    	Movie movie = new Movie(
    			another.getMovieID(),
    			another.getTitle(),
    			another.getDirector(),
    			another.getCasts(),
    			another.getMovieContent(),
    			another.getDuration(),
    			another.getMovieState()
    	);
    	return movie;
    }
    
    /**
     * Getter of movie state of this movie
     * @return this.state
     */
	
	public MovieStates getMovieState() {
		return this.state;
	}
	
	/**
	 * Setter of movie state of this movie
	 * @param movieState
	 */
	public void setMovieState(MovieStates movieState) {
		this.state = movieState;
	}

	/**
	 * Getter Movie Id of this movie
	 * @return this.movieID
	 */
    public int getMovieID(){
        return this.movieID;
    }
    
    /**
     * Setter Movie Id of this movie
     * @param id
     */
    public void setMovieID(int id){
        this.movieID = id;
    }
    
    /**
     * Getter title of this movie
     * @return this.title
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * Setter title of this movie
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Getter director name of this movie
     * @return this.director
     */
    public String getDirector(){
        return this.director;
    }

    /**
     * Setter director name of this movie
     * @param director
     */
    public void setDirector(String director){
        this.director = director;
    }

    /**
     * Getter list of cast of this movie
     * @return this.casts
     */
    public ArrayList<String> getCasts(){
        return this.casts;
    }

    /**
     * Setter List of cast of this movie
     * @param casts
     */
    public void setCasts(ArrayList<String> casts){
        this.casts = casts;
    }

    /**
     * Getter content (synopsis) of this movie
     * @return this.movieContent
     */
    public String getMovieContent(){
        return this.movieContent;
    }
    
    /**
     * Setter content of this movie
     * @param content
     */
    public void setMovieContent(String content){
        this.movieContent = content;
    }

    /**
     * Getter duration of this movie
     * @return this.duration
     */
    public double getDuration(){
        return this.duration;
    }

    /**
     * Setter duration of this movie
     * @param duration
     */
    public void setDuration(double duration){
        this.duration = duration;
    }


}