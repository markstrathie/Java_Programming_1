package books;

public class Audiobook extends Book {
	
	Double fileSize;
	int duration;

	public Audiobook(String authorsName, String title, String isbn10, Double fileSize, int duration)
	{
		super(authorsName, title, isbn10);
		this.fileSize = fileSize;
		this.duration = duration;
	}
	
	public void printDetails()
	{
		System.out.println(title + " " + authorsName + " " + isbn10 + " " + fileSize + " " + duration + "s");
    }

}
