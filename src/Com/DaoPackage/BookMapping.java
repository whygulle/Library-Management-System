package Com.DaoPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.BeanPackage.Book;

public class BookMapping {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();

		cfg.configure("Book.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		//self help short story auto biography 
//		Book b1 = new Book();
//		b1.setBookName("You Can Win");
//		b1.setGenre("self help");
//		b1.setAuthor("Shiv Khera");
//		b1.setReleasedate("2000-05-10");
//		b1.setAvailability(10);
//		b1.setIssued(0);
//
//		Book b2 = new Book();
//		b2.setBookName("Rich Dad Poor Dad");
//		b2.setGenre("finance");
//		b2.setAuthor("Robert Kiyosaki");
//		b2.setReleasedate("1997-04-08");
//		b2.setAvailability(10);
//		b2.setIssued(0);
//
//		Book b3 = new Book();
//		b3.setBookName("The Alchemist");
//		b3.setGenre("self help");
//		b3.setAuthor("Paulo Coelho");
//		b3.setReleasedate("1988-04-16");
//		b3.setAvailability(10);
//		b3.setIssued(0);
//
//		Book b4 = new Book();
//		b4.setBookName("The Great Gatsby");
//		b4.setGenre("fictional");
//		b4.setAuthor("F.Scott Fitzgerald");
//		b4.setReleasedate("1925-04-10");
//		b4.setAvailability(10);
//		b4.setIssued(0);
//
//		Book b5 = new Book();
//		b5.setBookName("Energize Your Mind");
//		b5.setGenre("self help");
//		b5.setAuthor("Gaur Gopal Das");
//		b5.setReleasedate("2022-04-07");
//		b5.setAvailability(10);
//		b5.setIssued(0);
//
//		Book b6 = new Book();
//		b6.setBookName("Wolf Hall");
//		b6.setGenre("fictional");
//		b6.setAuthor("Hilary Mantel");
//		b6.setReleasedate("2009-04-30");
//		b6.setAvailability(10);		
//		b6.setIssued(0);
//
//		Book b7 = new Book();
//		b7.setBookName("Charles III");
//		b7.setGenre("non fictional");
//		b7.setAuthor("Robert Hardman");
//		b7.setReleasedate("1980-10-10");
//		b7.setAvailability(10);
//		b7.setIssued(0);
//
//		Book b8 = new Book();
//		b8.setBookName("The Immortals Of Meluha");
//		b8.setGenre("fictional");
//		b8.setAuthor("Amit Tripathi");
//		b8.setReleasedate("2010-02-21");
//		b8.setAvailability(10);
//		b8.setIssued(0);
//
//		Book b9 = new Book();
//		b9.setBookName("Atomic Habits");
//		b9.setGenre("self help");
//		b9.setAuthor("James Clear");
//		b9.setReleasedate("2018-10-16");
//		b9.setAvailability(10);
//		b9.setIssued(0);
//
//		Book b10 = new Book();
//		b10.setBookName("Dear Life");
//		b10.setGenre("short story");
//		b10.setAuthor("Alice Munro");
//		b10.setReleasedate("2012-10-20");
//		b10.setAvailability(10);
//		b10.setIssued(0);
//
////		Book b11 = new Book();	
////		b11.setBookName("No One Belongs Here More Than You");
////		b11.setGenre("short story");
////		b11.setAuthor("Miranda July");
////		b11.setReleasedate("2007-05-15");
////		b11.setAvailability(10);
////		b11.setIssued(0);
//		
//		Book b12 = new Book();	
//		b12.setBookName("American Psycho");
//		b12.setGenre("fictional");
//		b12.setAuthor("Bret Easton Ellis");
//		b12.setReleasedate("1991-03-06");
//		b12.setAvailability(10);
//		b12.setIssued(0);
//		
//		
//		//continues..................................
//		
//		
//		Book b13 = new Book();	
//		b13.setBookName("The Green Budget Guide");
//		b13.setGenre("non fictional");
//		b13.setAuthor("Nancy Birtwhistle");
//		b13.setReleasedate("2024-01-04");
//		b13.setAvailability(10);
//		b13.setIssued(0);
//		
//		Book b14 = new Book();	
//		b14.setBookName("The Courage to be Disliked");
//		b14.setGenre("self help");
//		b14.setAuthor("Fumitake Koga and Ichiro Kishimi");
//		b14.setReleasedate("2013-12-12");
//		b14.setAvailability(10);
//		b14.setIssued(0);
//		
//		Book b15 = new Book();	
//		b15.setBookName("Fragile Things");
//		b15.setGenre("short story");
//		b15.setAuthor("Neil Gaiman");
//		b15.setReleasedate("2006-12-02");
//		b15.setAvailability(10);
//		b15.setIssued(0);
//		
//		Book b16 = new Book();	
//		b16.setBookName("Why am I an Atheist");
//		b16.setGenre("auto biography");
//		b16.setAuthor("Bhagat Singh");
//		b16.setReleasedate("1931-09-27");
//		b16.setAvailability(10);
//		b16.setIssued(0);
//		
//		Book b17 = new Book();	
//		b17.setBookName("Wings Of Fire");
//		b17.setGenre("auto biography");
//		b17.setAuthor("Dr APJ Abdul Kalam and Arun Tiwari");
//		b17.setReleasedate("2000-10-26");
//		b17.setAvailability(10);
//		b17.setIssued(0);
//
//		Book b18 = new Book();	
//		b18.setBookName("Nineteen Eighty-Four");
//		b18.setGenre("fictional");
//		b18.setAuthor("George Orwell");
//		b18.setReleasedate("1949-06-08");
//		b18.setAvailability(10);
//		b18.setIssued(0);
//		
//		Book b19 = new Book();	
//		b19.setBookName("Mans Search for Meaning");
//		b19.setGenre("self help");
//		b19.setAuthor("Viktor Frankl");
//		b19.setReleasedate("1946-10-11");
//		b19.setAvailability(10);
//		b19.setIssued(0);
//		
//		Book b20 = new Book();	
//		b20.setBookName("Runaway");
//		b20.setGenre("short story");
//		b20.setAuthor("Alice Munro");
//		b20.setReleasedate("2004-10-02");
//		b20.setAvailability(10);
//		b20.setIssued(0);
//		
//		
//		Book b21 = new Book();	
//		b21.setBookName("One Flew Over the Cuckoo's Nest");
//		b21.setGenre("fictional");
//		b21.setAuthor("Ken Kesey");
//		b21.setReleasedate("1975-11-19");
//		b21.setAvailability(10);
//		b21.setIssued(0);
//		
//		Book b22 = new Book();	
//		b22.setBookName("Stay True");
//		b22.setGenre("non fictional");
//		b22.setAuthor("Hua Hsu");
//		b22.setReleasedate("2022-09-27");
//		b22.setAvailability(10);
//		b22.setIssued(0);
//
//		Book b23 = new Book();	
//		b23.setBookName("What We Talk About When We Talk About Love");
//		b23.setGenre("short story");
//		b23.setAuthor("Raymond Carver");
//		b23.setReleasedate("1981-12-02");
//		b23.setAvailability(10);
//		b23.setIssued(0);
//		
//		Book b24 = new Book();	
//		b24.setBookName("Holding the Note");
//		b24.setGenre("non fictional");
//		b24.setAuthor("David Remnick");
//		b24.setReleasedate("2023-05-23");
//		b24.setAvailability(10);
//		b24.setIssued(0);
//		
//		Book b25 = new Book();	
//		b25.setBookName("Moby Dick");
//		b25.setGenre("fictional");
//		b25.setAuthor("Herman Melville");
//		b25.setReleasedate("1851-10-18");
//		b25.setAvailability(10);
//		b25.setIssued(0);
//		
//		Book b26 = new Book();	
//		b26.setBookName("To Kill a Mockingbird");
//		b26.setGenre("fictional");
//		b26.setAuthor("Harper Lee");
//		b26.setReleasedate("1960-07-11");
//		b26.setAvailability(10);
//		b26.setIssued(0);
		
//		Book b26 = new Book();	
//		b26.setBookName("Think and Grow Rich");
//		b26.setGenre("finance");
//		b26.setAuthor("Napoleon Hill");
//		b26.setReleasedate(1937);
//		b26.setAvailability(10);
//		b26.setIssued(0);

		//comic 
//		Book b1 = new Book();
//		b1.setBookName("Batman: The Killing Joke");
//		b1.setGenre("comic");
//		b1.setAuthor("Alan Moore");
//		b1.setReleasedate("1988-10-01");
//		b1.setAvailability(10);
//		b1.setIssued(0);
//
//		Book b2 = new Book();
//		b2.setBookName("Detective Comics (2016)");
//		b2.setGenre("comic");
//		b2.setAuthor("Warren Ellis");
//		b2.setReleasedate("2019-09-07");
//		b2.setAvailability(10);
//		b2.setIssued(0);
//
//		Book b3 = new Book();
//		b3.setBookName("Blankets");
//		b3.setGenre("comic");
//		b3.setAuthor("Craig Thompson");
//		b3.setReleasedate("2003-01-22");
//		b3.setAvailability(10);
//		b3.setIssued(0);
//
//		Book b4 = new Book();
//		b4.setBookName("Star Wars");
//		b4.setGenre("comic");
//		b4.setAuthor("Jason Aaron and John Cassaday");
//		b4.setReleasedate("2015-10-11");
//		b4.setAvailability(10);
//		b4.setIssued(0);
//
//		Book b5 = new Book();
//		b5.setBookName("Naruto");
//		b5.setGenre("comic");
//		b5.setAuthor("Shueisha");
//		b5.setReleasedate("1999-02-25");
//		b5.setAvailability(10);
//		b5.setIssued(0);
//
//		Book b6 = new Book();
//		b6.setBookName("One Piece");
//		b6.setGenre("comic");
//		b6.setAuthor("Eiichiro Oda");
//		b6.setReleasedate("1997-10-20");
//		b6.setAvailability(10);		
//		b6.setIssued(0);
//
//		Book b7 = new Book();
//		b7.setBookName("Dragon Ball");
//		b7.setGenre("comic");
//		b7.setAuthor("Akira Toriyama");
//		b7.setReleasedate("1984-10-20");
//		b7.setAvailability(10);
//		b7.setIssued(0);
//
//		Book b8 = new Book();
//		b8.setBookName("Doraemon");
//		b8.setGenre("comic");
//		b8.setAuthor("Fujiko Fujio");
//		b8.setReleasedate("1969-03-01");
//		b8.setAvailability(10);
//		b8.setIssued(0);
//
//		Book b9 = new Book();
//		b9.setBookName("Demon Slayer: Kimetsu no Yaiba");
//		b9.setGenre("comic");
//		b9.setAuthor("Koyoharu Gotōge");
//		b9.setReleasedate("2016-11-22");
//		b9.setAvailability(10);
//		b9.setIssued(0);
//
//		Book b10 = new Book();
//		b10.setBookName("Spider-Man #1");
//		b10.setGenre("comic");
//		b10.setAuthor("Todd McFarlane");
//		b10.setReleasedate("1990-08-22");
//		b10.setAvailability(10);
//		b10.setIssued(0);
//
//		Book b11 = new Book();	
//		b11.setBookName("X-Force #1");
//		b11.setGenre("comic");
//		b11.setAuthor("Fabian Nicieza and Rob Liefeld");
//		b11.setReleasedate("1991-10-20");
//		b11.setAvailability(10);
//		b11.setIssued(0);
		
//		Book b12 = new Book();	
//		b12.setBookName("An Immense World");
//		b12.setGenre("comic");
//		b12.setAuthor("Ed Yong");
//		b12.setReleasedate("2022-02-22");
//		b12.setAvailability(10);
//		b12.setIssued(0);
		
//		Book b13 = new Book();	
//		b13.setBookName("I Will Teach You To Be Rich");
//		b13.setGenre("finance");
//		b13.setAuthor("Ramit Sethi");
//		b13.setReleasedate("2009-03-23");
//		b13.setAvailability(10);
//		b13.setIssued(0);
//		
//		Book b14 = new Book();	
//		b14.setBookName("The Man Who Mistook His Wife for a Hat");
//		b14.setGenre("science");
//		b14.setAuthor("Oliver Sacks");
//		b14.setReleasedate("1998-04-02");
//		b14.setAvailability(10);
//		b14.setIssued(0);
//		
//		Book b15 = new Book();	
//		b15.setBookName("The Automatic Millionaire");
//		b15.setGenre("finance");
//		b15.setAuthor("David Bach");
//		b15.setReleasedate("2003-10-06");
//		b15.setAvailability(10);
//		b15.setIssued(0);
//		
//		Book b16 = new Book();	
//		b16.setBookName("My Father's Brain: Understanding Life in the Shadow of Alzheimer's");
//		b16.setGenre("science");
//		b16.setAuthor("Sandeep Jauhar");
//		b16.setReleasedate("2023-12-05");
//		b16.setAvailability(10);
//		b16.setIssued(0);
//		
//		Book b17 = new Book();	
//		b17.setBookName("Secrets Of The Millionaire Mind");
//		b17.setGenre("finance");
//		b17.setAuthor("T. Harv Eker");
//		b17.setReleasedate("2005-02-15");
//		b17.setAvailability(10);
//		b17.setIssued(0);
//
//		 
//		Book b18 = new Book();	
//		b18.setBookName("The Selfish Gene");
//		b18.setGenre("science");
//		b18.setAuthor("Richard Dawkins");
//		b18.setReleasedate("1976-10-10");
//		b18.setAvailability(10);
//		b18.setIssued(0);
//		 
//		Book b19 = new Book();	
//		b19.setBookName("The Millionaire Next Door");
//		b19.setGenre("finance");
//		b19.setAuthor("Thomas J. Stanley");
//		b19.setReleasedate("2018-10-23");
//		b19.setAvailability(10);
//		b19.setIssued(0);
//		
//		 
//		Book b20 = new Book();	
//		b20.setBookName("The Little Book That Beats The Market");
//		b20.setGenre("finance");
//		b20.setAuthor("Joel Greenblatt");
//		b20.setReleasedate("2006-11-09");
//		b20.setAvailability(10);
//		b20.setIssued(0);
		
		
//		Book b21 = new Book();	
//		b21.setBookName("One Flew Over the Cuckoo's Nest");
//		b21.setGenre("fictional");
//		b21.setAuthor("Ken Kesey");
//		b21.setReleasedate("1975-11-19");
//		b21.setAvailability(10);
//		b21.setIssued(0);
//		
//		Book b22 = new Book();	
//		b22.setBookName("Stay True");
//		b22.setGenre("non fictional");
//		b22.setAuthor("Hua Hsu");
//		b22.setReleasedate("2022-09-27");
//		b22.setAvailability(10);
//		b22.setIssued(0);
//
//		Book b23 = new Book();	
//		b23.setBookName("What We Talk About When We Talk About Love");
//		b23.setGenre("short story");
//		b23.setAuthor("Raymond Carver");
//		b23.setReleasedate("1981-12-02");
//		b23.setAvailability(10);
//		b23.setIssued(0);
//		
//		Book b24 = new Book();	
//		b24.setBookName("Holding the Note");
//		b24.setGenre("non fictional");
//		b24.setAuthor("David Remnick");
//		b24.setReleasedate("2023-05-23");
//		b24.setAvailability(10);
//		b24.setIssued(0);
//		
//		Book b25 = new Book();	
//		b25.setBookName("Moby Dick");
//		b25.setGenre("fictional");
//		b25.setAuthor("Herman Melville");
//		b25.setReleasedate("1851-10-18");
//		b25.setAvailability(10);
//		b25.setIssued(0);
//		
//		Book b26 = new Book();	
//		b26.setBookName("To Kill a Mockingbird");
//		b26.setGenre("fictional");
//		b26.setAuthor("Harper Lee");
//		b26.setReleasedate("1960-07-11");
//		b26.setAvailability(10);
//		b26.setIssued(0);
		
//		Book b26 = new Book();	
//		b26.setBookName("Think and Grow Rich");
//		b26.setGenre("finance");
//		b26.setAuthor("Napoleon Hill");
//		b26.setReleasedate(1937);
//		b26.setAvailability(10);
//		b26.setIssued(0);
		
		
		//reference books
//		Book b1 = new Book();
//		b1.setBookName("Encyclopedias");
//		b1.setGenre("reference");
//		b1.setAvailability(10);
//		b1.setIssued(0);

//		Book b2 = new Book();
//		b2.setBookName("Dictionaries");
//		b2.setGenre("reference");
//		b2.setAvailability(10);
//		b2.setIssued(0);
//
//		Book b3 = new Book();
//		b3.setBookName("Bibliographies");
//		b3.setGenre("reference");
//		b3.setAvailability(10);
//		b3.setIssued(0);
//
//		Book b4 = new Book();
//		b4.setBookName("Almanacs");
//		b4.setGenre("reference");
//		b4.setAvailability(10);
//		b4.setIssued(0);
//
//		Book b5 = new Book();
//		b5.setBookName("Biographies");
//		b5.setGenre("reference");
//		b5.setAvailability(10);
//		b5.setIssued(0);
//
//		Book b6 = new Book();
//		b6.setBookName("Indexes");
//		b6.setGenre("reference");
//		b6.setAvailability(10);		
//		b6.setIssued(0);
//
//		Book b7 = new Book();
//		b7.setBookName("Directories");
//		b7.setGenre("reference");
//		b7.setAvailability(10);
//		b7.setIssued(0);
//
//		Book b8 = new Book();
//		b8.setBookName("Life on Mars");
//		b8.setGenre("poetry");
//		b8.setAuthor("Tracy K. Smith");
//		b8.setReleasedate("2011-02-01");
//		b8.setAvailability(10);
//		b8.setIssued(0);
//
//		Book b9 = new Book();
//		b9.setBookName("The World Keeps Ending, and the World Goes On");
//		b9.setGenre("poetry");
//		b9.setAuthor("Franny Choi");
//		b9.setReleasedate("2022-01-22");
//		b9.setAvailability(10);
//		b9.setIssued(0);
//
//		Book b10 = new Book();
//		b10.setBookName("Call Us What We Carry");
//		b10.setGenre("poetry");
//		b10.setAuthor("Amanda Gorman");
//		b10.setReleasedate("2021-09-12");
//		b10.setAvailability(10);
//		b10.setIssued(0);

//		Book b11 = new Book();	
//		b11.setBookName("X-Force #1");
//		b11.setGenre("comic");
//		b11.setAuthor("Fabian Nicieza and Rob Liefeld");
//		b11.setReleasedate("1991-10-20");
//		b11.setAvailability(10);
//		b11.setIssued(0);
//		
//		Book b12 = new Book();	
//		b12.setBookName("An Immense World");
//		b12.setGenre("comic");
//		b12.setAuthor("Ed Yong");
//		b12.setReleasedate("2022-02-22");
//		b12.setAvailability(10);
//		b12.setIssued(0);
//		
//		Book b13 = new Book();	
//		b13.setBookName("I Will Teach You To Be Rich");
//		b13.setGenre("finance");
//		b13.setAuthor("Ramit Sethi");
//		b13.setReleasedate("2009-03-23");
//		b13.setAvailability(10);
//		b13.setIssued(0);
//		
//		Book b14 = new Book();	
//		b14.setBookName("The Man Who Mistook His Wife for a Hat");
//		b14.setGenre("science");
//		b14.setAuthor("Oliver Sacks");
//		b14.setReleasedate("1998-04-02");
//		b14.setAvailability(10);
//		b14.setIssued(0);
//		
//		Book b15 = new Book();	
//		b15.setBookName("The Automatic Millionaire");
//		b15.setGenre("finance");
//		b15.setAuthor("David Bach");
//		b15.setReleasedate("2003-10-06");
//		b15.setAvailability(10);
//		b15.setIssued(0);
//		
//		Book b16 = new Book();	
//		b16.setBookName("My Father's Brain: Understanding Life in the Shadow of Alzheimer's");
//		b16.setGenre("science");
//		b16.setAuthor("Sandeep Jauhar");
//		b16.setReleasedate("2023-12-05");
//		b16.setAvailability(10);
//		b16.setIssued(0);
//		
//		Book b17 = new Book();	
//		b17.setBookName("Secrets Of The Millionaire Mind");
//		b17.setGenre("finance");
//		b17.setAuthor("T. Harv Eker");
//		b17.setReleasedate("2005-02-15");
//		b17.setAvailability(10);
//		b17.setIssued(0);
//
//		 
//		Book b18 = new Book();	
//		b18.setBookName("The Selfish Gene");
//		b18.setGenre("science");
//		b18.setAuthor("Richard Dawkins");
//		b18.setReleasedate("1976-10-10");
//		b18.setAvailability(10);
//		b18.setIssued(0);
//		 
//		Book b19 = new Book();	
//		b19.setBookName("The Millionaire Next Door");
//		b19.setGenre("finance");
//		b19.setAuthor("Thomas J. Stanley");
//		b19.setReleasedate("2018-10-23");
//		b19.setAvailability(10);
//		b19.setIssued(0);
//		
//		 
//		Book b20 = new Book();	
//		b20.setBookName("The Little Book That Beats The Market");
//		b20.setGenre("finance");
//		b20.setAuthor("Joel Greenblatt");
//		b20.setReleasedate("2006-11-09");
//		b20.setAvailability(10);
//		b20.setIssued(0);
		
		//spiritual books
			
		Book b10 = new Book();	
		b10.setBookName("The Book of Joy");
		b10.setGenre("spiritual");
		b10.setAuthor("Desmond Tutu");
		b10.setReleasedate("2016-01-09");
		b10.setAvailability(10);
		b10.setIssued(0);
		
		Book b11 = new Book();	
		b11.setBookName("The Power of Now: A Guide to Spiritual Enlightenment");
		b11.setGenre("spiritual");
		b11.setAuthor("Eckhart Tolle");
		b11.setReleasedate("1997-08-19");
		b11.setAvailability(10);
		b11.setIssued(0);
		
		Book b12 = new Book();	
		b12.setBookName("The Art of Happiness");
		b12.setGenre("spiritual");  
		b12.setAuthor(" Dalai Lama");
		b12.setReleasedate("1999-11-08");
		b12.setAvailability(10);
		b12.setIssued(0);
		
		Book b13 = new Book();	
		b13.setBookName("The Seven Spiritual Laws of Successs");
		b13.setGenre("spiritual");
		b13.setAuthor("Deepak Chopra");
		b13.setReleasedate("1994-06-13");
		b13.setAvailability(10);
		b13.setIssued(0);
		
		Book b14 = new Book();	
		b14.setBookName("Autobiography of a Yogi");
		b14.setGenre("spiritual");
		b14.setAuthor("Paramahansa Yogananda");
		b14.setReleasedate("1946-09-02");
		b14.setAvailability(10);
		b14.setIssued(0);
		
		Book b15 = new Book();	
		b15.setBookName("Death; An inside Story");
		b15.setGenre("spiritual");
		b15.setAuthor("Sadhguru");
		b15.setReleasedate("2020-07-06");
		b15.setAvailability(10);
		b15.setIssued(0);
		
		Book b16 = new Book();	
		b16.setBookName("Inner Engineering: A Yogi's Guide to Joy");
		b16.setGenre("spiritual");
		b16.setAuthor("Sadhguru");
		b16.setReleasedate("2016-02-10");
		b16.setAvailability(10);
		b16.setIssued(0);
		
		Book b17 = new Book();	
		b17.setBookName("Bhagavad Gita");
		b17.setGenre("spiritual");
		b17.setAuthor("Vyasa");
		b17.setReleasedate("2015-12-05");
		b17.setAvailability(10);
		b17.setIssued(0);

		 
		Book b18 = new Book();	
		b18.setBookName("Eat, Pray, Love");
		b18.setGenre("spiritual");
		b18.setAuthor("Elizabeth Gilbert");
		b18.setReleasedate("2006-09-11");
		b18.setAvailability(10);
		b18.setIssued(0);
		 
		Book b19 = new Book();	
		b19.setBookName("Life's Amazing Secrets: How to Find Balance and Purpose in Your Life");
		b19.setGenre("spiritual");
		b19.setAuthor("Gaur Gopal Das");
		b19.setReleasedate("2018-12-03");
		b19.setAvailability(10);
		b19.setIssued(0);
		
		 
		Book b20 = new Book();	
		b20.setBookName("The Power of One Thought: Master Your Mind, Master Your Life");
		b20.setGenre("spiritual");
		b20.setAuthor("BK Shivani");
		b20.setReleasedate("2023-01-19");
		b20.setAvailability(10);
		b20.setIssued(0);
		Session s = factory.openSession();

		Transaction ts = s.beginTransaction();

//		s.save(b1);
//		s.save(b2);
//		s.save(b3);
//		s.save(b4);
//		s.save(b5);
//		s.save(b6);
//		s.save(b7);
//		s.save(b8);
//		s.save(b9);
//		s.save(b10);
//		s.save(b11);
//		s.save(b12);
//		s.save(b13);
//		s.save(b14);
//		s.save(b15);
//		s.save(b16);
//		s.save(b17);
//		s.save(b18);
//		s.save(b19);
//		s.save(b20);	
//		s.save(b21);
//		s.save(b22);
//		s.save(b23);
//		s.save(b24);
//		s.save(b25);
//		s.save(b26);
		
		ts.commit();

		s.close();
		factory.close();
	}
}
