package books;

public class PhysicalBook extends Book {
	
	int numberOfPages;

	public PhysicalBook(String authorsName, String title, String isbn10, int numberOfPages)
	{
		super(authorsName, title, isbn10);
		this.numberOfPages = numberOfPages;
	}
	
	public void printDetails()
	{
		System.out.println(title + " " + authorsName + " " + isbn10 + " " + numberOfPages + " pages");
    }

}
