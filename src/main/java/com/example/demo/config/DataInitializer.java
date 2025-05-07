package com.example.demo.config;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {
        // Create authors
        Author author1 = new Author();
        author1.setName("J.K. Rowling");
        author1.setEmail("jkrowling@example.com");
        author1.setBiography("British author best known for the Harry Potter series");

        Author author2 = new Author();
        author2.setName("George R.R. Martin");
        author2.setEmail("grmartin@example.com");
        author2.setBiography("American novelist and short story writer");

        Author author3 = new Author();
        author3.setName("Stephen King");
        author3.setEmail("sking@example.com");
        author3.setBiography("American author of horror, supernatural fiction, suspense, and fantasy novels");

        Author author4 = new Author();
        author4.setName("J.R.R. Tolkien");
        author4.setEmail("tolkien@example.com");
        author4.setBiography("English writer, best known for The Lord of the Rings");

        Author author5 = new Author();
        author5.setName("Agatha Christie");
        author5.setEmail("achristie@example.com");
        author5.setBiography("English writer known for her detective novels");

        Author author6 = new Author();
        author6.setName("Dan Brown");
        author6.setEmail("dbrown@example.com");
        author6.setBiography("American author known for thriller novels");

        Author author7 = new Author();
        author7.setName("Suzanne Collins");
        author7.setEmail("scollins@example.com");
        author7.setBiography("American television writer and author of The Hunger Games");

        Author author8 = new Author();
        author8.setName("Isaac Asimov");
        author8.setEmail("iasimov@example.com");
        author8.setBiography("Russian-born American science fiction writer");

        Author author9 = new Author();
        author9.setName("Neil Gaiman");
        author9.setEmail("ngaiman@example.com");
        author9.setBiography("British author of short fiction, novels, comic books, and more");

        Author author10 = new Author();
        author10.setName("C.S. Lewis");
        author10.setEmail("cslewis@example.com");
        author10.setBiography("British writer and theologian best known for The Chronicles of Narnia");

        Author author11 = new Author();
        author11.setName("Margaret Atwood");
        author11.setEmail("matwood@example.com");
        author11.setBiography("Canadian author and poet, known for The Handmaid's Tale");

        Author author12 = new Author();
        author12.setName("Haruki Murakami");
        author12.setEmail("hmurakami@example.com");
        author12.setBiography("Japanese writer known for surreal and melancholic fiction");

        Author author13 = new Author();
        author13.setName("Khaled Hosseini");
        author13.setEmail("khosseini@example.com");
        author13.setBiography("Afghan-American novelist, known for The Kite Runner");

        Author author14 = new Author();
        author14.setName("Brandon Sanderson");
        author14.setEmail("bsanderson@example.com");
        author14.setBiography("American author known for epic fantasy works");

        authorRepository.saveAll(Arrays.asList(
                author1, author2, author3, author4, author5, author6, author7,
                author8, author9, author10, author11, author12, author13, author14));

        // Create books
        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Philosopher's Stone");
        book1.setIsbn("978-0747532743");
        book1.setDescription("The first book in the Harry Potter series");
        book1.setPrice(new BigDecimal("19.99"));
        book1.setPublicationDate(LocalDate.of(1997, 6, 26));
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setTitle("A Game of Thrones");
        book2.setIsbn("978-0553103540");
        book2.setDescription("The first book in A Song of Ice and Fire series");
        book2.setPrice(new BigDecimal("24.99"));
        book2.setPublicationDate(LocalDate.of(1996, 8, 1));
        book2.setAuthor(author2);

        Book book3 = new Book();
        book3.setTitle("The Shining");
        book3.setIsbn("978-0385121675");
        book3.setDescription("A horror novel by Stephen King");
        book3.setPrice(new BigDecimal("14.99"));
        book3.setPublicationDate(LocalDate.of(1977, 1, 28));
        book3.setAuthor(author3);

        Book book4 = new Book();
        book4.setTitle("Harry Potter and the Chamber of Secrets");
        book4.setIsbn("978-0747538493");
        book4.setDescription("The second book in the Harry Potter series");
        book4.setPrice(new BigDecimal("19.99"));
        book4.setPublicationDate(LocalDate.of(1998, 7, 2));
        book4.setAuthor(author1);

        Book book5 = new Book();
        book5.setTitle("A Clash of Kings");
        book5.setIsbn("978-0553108033");
        book5.setDescription("The second book in A Song of Ice and Fire series");
        book5.setPrice(new BigDecimal("25.99"));
        book5.setPublicationDate(LocalDate.of(1998, 11, 16));
        book5.setAuthor(author2);

        Book book6 = new Book();
        book6.setTitle("It");
        book6.setIsbn("978-0450411434");
        book6.setDescription("A horror novel about a shape-shifting entity");
        book6.setPrice(new BigDecimal("16.99"));
        book6.setPublicationDate(LocalDate.of(1986, 9, 15));
        book6.setAuthor(author3);

        Book book7 = new Book();
        book7.setTitle("The Hobbit");
        book7.setIsbn("978-0345339683");
        book7.setDescription("Prequel to The Lord of the Rings");
        book7.setPrice(new BigDecimal("17.99"));
        book7.setPublicationDate(LocalDate.of(1937, 9, 21));
        book7.setAuthor(author4);

        Book book8 = new Book();
        book8.setTitle("The Fellowship of the Ring");
        book8.setIsbn("978-0261103573");
        book8.setDescription("First part of The Lord of the Rings");
        book8.setPrice(new BigDecimal("22.99"));
        book8.setPublicationDate(LocalDate.of(1954, 7, 29));
        book8.setAuthor(author4);

        Book book9 = new Book();
        book9.setTitle("Murder on the Orient Express");
        book9.setIsbn("978-0062693662");
        book9.setDescription("Detective Hercule Poirot investigates a murder");
        book9.setPrice(new BigDecimal("13.99"));
        book9.setPublicationDate(LocalDate.of(1934, 1, 1));
        book9.setAuthor(author5);

        Book book10 = new Book();
        book10.setTitle("The Da Vinci Code");
        book10.setIsbn("978-0307474278");
        book10.setDescription("A thriller exploring historical secrets");
        book10.setPrice(new BigDecimal("18.99"));
        book10.setPublicationDate(LocalDate.of(2003, 3, 18));
        book10.setAuthor(author6);

        Book book11 = new Book();
        book11.setTitle("The Hunger Games");
        book11.setIsbn("978-0439023481");
        book11.setDescription("A dystopian novel");
        book11.setPrice(new BigDecimal("12.99"));
        book11.setPublicationDate(LocalDate.of(2008, 9, 14));
        book11.setAuthor(author7);

        Book book12 = new Book();
        book12.setTitle("Foundation");
        book12.setIsbn("978-0553293357");
        book12.setDescription("The first book in the Foundation series");
        book12.setPrice(new BigDecimal("15.99"));
        book12.setPublicationDate(LocalDate.of(1951, 6, 1));
        book12.setAuthor(author8);

        Book book13 = new Book();
        book13.setTitle("American Gods");
        book13.setIsbn("978-0062472106");
        book13.setDescription("A fantasy novel");
        book13.setPrice(new BigDecimal("17.49"));
        book13.setPublicationDate(LocalDate.of(2001, 6, 19));
        book13.setAuthor(author9);

        Book book14 = new Book();
        book14.setTitle("The Lion, the Witch and the Wardrobe");
        book14.setIsbn("978-0064471046");
        book14.setDescription("First published of The Chronicles of Narnia");
        book14.setPrice(new BigDecimal("10.99"));
        book14.setPublicationDate(LocalDate.of(1950, 10, 16));
        book14.setAuthor(author10);

        Book book15 = new Book();
        book15.setTitle("The Handmaid's Tale");
        book15.setIsbn("978-0385490818");
        book15.setDescription("A dystopian novel by Margaret Atwood");
        book15.setPrice(new BigDecimal("14.49"));
        book15.setPublicationDate(LocalDate.of(1985, 9, 1));
        book15.setAuthor(author11);

        Book book16 = new Book();
        book16.setTitle("Kafka on the Shore");
        book16.setIsbn("978-1400079278");
        book16.setDescription("A surreal novel by Haruki Murakami");
        book16.setPrice(new BigDecimal("13.59"));
        book16.setPublicationDate(LocalDate.of(2002, 9, 12));
        book16.setAuthor(author12);

        Book book17 = new Book();
        book17.setTitle("The Kite Runner");
        book17.setIsbn("978-1594631931");
        book17.setDescription("A powerful story of friendship and redemption");
        book17.setPrice(new BigDecimal("14.99"));
        book17.setPublicationDate(LocalDate.of(2003, 5, 29));
        book17.setAuthor(author13);

        Book book18 = new Book();
        book18.setTitle("Mistborn: The Final Empire");
        book18.setIsbn("978-0765311788");
        book18.setDescription("First book in the Mistborn series");
        book18.setPrice(new BigDecimal("18.99"));
        book18.setPublicationDate(LocalDate.of(2006, 7, 17));
        book18.setAuthor(author14);

        bookRepository.saveAll(Arrays.asList(
                book1, book2, book3, book4, book5, book6, book7, book8, book9,
                book10, book11, book12, book13, book14, book15, book16, book17, book18));

    }
}