package books;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
	
	//fields
	
	String authorsName;
	String title;
	String isbn10;
	
	//constructor
	
	public Book(String authorsName, String title, String isbn10)
	{
		setAuthorsName(authorsName);
		setTitle(title);
		setIsbn10(isbn10);
	}

	//setters
	
	public void setAuthorsName(String authorsName) throws IllegalArgumentException
	{
		Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(authorsName);
		boolean containsSpecialCharacter = matcher.find();
		
		if (authorsName.length() == 0)
		{
			throw new IllegalArgumentException("Author's name cannot be an empty string.");
		}
		else if (containsSpecialCharacter)
		{
			throw new IllegalArgumentException("Author's name cannot contain any special characters.");
		}
		else
		{
			this.authorsName = authorsName;
		}
	}

	public void setTitle(String title) throws IllegalArgumentException
	{
		if (title.length()>0)
		{
			this.title = title;
		}
		else
		{
			throw new IllegalArgumentException("Title cannot be an empty string.");
		}
	}

	public void setIsbn10(String isbn10) throws IllegalArgumentException
	{
		if (isbn10.length() != 10)
		{
			throw new IllegalArgumentException("ISBN-10 needs to be 10 characters long.");
		}
		else
		{
			int isbnSum = 0;
			int charInt = 0;
			
			for (int i = 0; i < isbn10.length(); i++)
			{ 
				char c = isbn10.charAt(i);
			    
				if (c == 'X')
			    {
			    	charInt = 10;
			    }
				else
				{
					charInt = Character.getNumericValue(c);
				}
			    
			    isbnSum += charInt * -(i - 10);
			}
			
			if (isbnSum % 11 != 0)
			{
				throw new IllegalArgumentException("ISBN-10 is invalid.");
			}
			else
			{
				this.isbn10 = isbn10;
			}
		}
	}
	
	public String getIsbn10()
	{
		return isbn10;
	}

	//Task 1_2
	public void printDetails()
	{
		System.out.println(authorsName + " " + title + " " + isbn10);
    }

}