package books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Library {
	
	//fields
	List<Book> library = new ArrayList<>();
	
	public Library()
	{
		
	}
	
	public void addBook(Book book)
	{
		library.add(book);
	}
	
	public void removeBook(Book bookToBeRemoved)
	{
		for (Book book : library)
		{
			if (book.equals(bookToBeRemoved))
			{
				library.remove(book);
				break;
			}
		}
	}
	
	//Task 2_2
	public void printByTitleAscending()
	{
		Collections.sort(library, new Comparator<Book>()
		{
			public int compare(Book b1, Book b2)
			{
				return b1.title.compareTo(b2.title);
		    }
		});
		
		for (Book book : library)
		{
			book.printDetails();
		}
	}
	
	//Task 2_3
	public void printSummaryByTitle()
	{
		HashMap<String, Integer> summary = new HashMap<String, Integer>();
		
		for (Book book : library)
		{
			if (summary.containsKey(book.title))
			{
				summary.put(book.title, summary.get(book.title) + 1);
			}
			else
			{
				summary.put(book.title, 1);
			}
		}
		
		for (String title : summary.keySet())
		{
			if (summary.get(title) == 1)
			{
				System.out.println(title + ", " + summary.get(title) + " copy");
			}
			else
			{
				System.out.println(title + ", " + summary.get(title) + " copies");
			}
		}
	}
	
	//Task 3_1
	//Add a method to the Library class which takes a single string parameter and prints out
	//the details of all books whose ISBN number contains that string.
	//you must implement the method by
	//creating a stream based on the array, establishing a filter, and then passing a lambda to that filter.
//	public void printContainsISBN(String isbn)
//	{
//		for (Book book : library)
//		{
//			if(book.isbn10.contains(isbn))
//			{
//				book.printDetails();
//			}
//		}
//	}
	
	public void printContainsISBN(String isbn)
	{
		List<Book> containsISBN = library
				  .stream()
				  .filter(c -> c.getIsbn10().contains(isbn))
				  .collect(Collectors.toList());
		
		for (Book book : containsISBN)
		{
			book.printDetails();
		}
	}
	
	public static void main(String args[])
	{
		PhysicalBook b1 = new PhysicalBook("HG WELLS", "The Time Machine", "304013342X", 666);
		Audiobook b2 = new Audiobook("HG WELLS", "The Invisible Man", "0306406152", 66.6, 120);
		Library l1 = new Library();
		l1.addBook(b1);
		l1.addBook(b1);
		l1.addBook(b2);
		l1.printByTitleAscending();
		l1.printSummaryByTitle();
		l1.printContainsISBN("03");
	}

}