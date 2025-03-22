import java.util.*;

// This class creates a book. A book has all the functionality of media, and also has a unique
// feature that compares other books based on the amount of reviews they get
public class Book implements Comparable<Book>, Media {

    private String title;
    private List<String> authors;
    private List<String> contentList;
    private List<Integer> ratings;

    // Behavior: 
    //   - This method makes a book, and a book has a title, authors, a list of ratings, and the
    //   - words in the book
    // Parameters:
    //   - title: the book's title
    //   - authors: the list of authors
    //   - content: the text of the book
    public Book(String title, List<String> authors, Scanner content){
        this.title = title;
        this.authors = authors;
        contentList = new ArrayList<>();
        while(content.hasNext()){
            contentList.add(content.next());
        }
        ratings = new ArrayList<>();
    }

    // Behavior: 
    //   - This method is a getter method for the title of the book
    // Returns:
    //   - String: the title of the book
    public String getTitle(){
        return title;
    }

    // Behavior: 
    //   - This method is a getter method for the artists of the method
    // Returns:
    //   - List<String>: the list of authors of the book
    public List<String> getArtists(){
        return authors;
    }

    // Behavior: 
    //   - This method allows user to add a score to the list of ratings for the book
    // Parameters:
    //   - score: the rating the user adds
    public void addRating(int score){
        ratings.add(score);
    }

    // Behavior: 
    //   - This method is a getter method for the number of ratings in the book 
    // Returns:
    //   - int: the numbers of ratings
    public int getNumRatings(){
        return ratings.size();
    }

    // Behavior: 
    //   - This method finds the average rating out of all the ratings in the book
    // Returns:
    //   - double: the average rating out of all the ratings
    public double getAverageRating(){
        if(this.getNumRatings() < 1){
            return 0.0;
        }
        double sum = 0.0;
        for(int num : ratings){
            sum += num;
        }
        return (sum/this.getNumRatings());
    }

    // Behavior: 
    //   - This method is a getter method for the words in the book
    // Returns:
    //   - List<String>: the list of words in the book
    public List<String> getContent(){
        return contentList;
    }

    // Behavior: 
    //   - This method compares two books in terms of which has more ratings
    // Parameters:
    //   - other: the book to be compared with
    // Returns:
    //   - int: if a positive value is returned, that means the current book has more ratings than
    //   the one being compared to. If a negative value is returned, then that means the book being
    //   compared to has more reviews than the current book.
    public int compareTo(Book other){
        return this.getNumRatings() - other.getNumRatings();
    }

    // Behavior: 
    //   - This method returns all of the important info of a book in a nicely organized manner.
    //   - If a book has ratings however, it returns the average rating rounded to the nearest
    //   - hundredth. If a book doesn't have ratings, it simply returns the book's title and 
    //   - authors.
    // Returns:
    //   - String: the title, authors regardless and the average rating and number of ratings
    //   - if a book has ratings.
    public String toString(){
        if(ratings.isEmpty()){
            return this.getTitle() + " by " + this.getArtists();
        }
        double average =  Math.round(this.getAverageRating() * 100.0)/100.0;
        return this.getTitle() + " by " + this.getArtists() + ": " + average + " ("
            + this.getNumRatings() + " ratings)"; 

    }
}
