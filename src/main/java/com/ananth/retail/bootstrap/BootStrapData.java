package com.ananth.retail.bootstrap;

import com.ananth.retail.domain.Author;
import com.ananth.retail.domain.Book;
import com.ananth.retail.domain.Publisher;
import com.ananth.retail.repositories.AuthorRepository;
import com.ananth.retail.repositories.BookRepository;
import com.ananth.retail.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ananth = new Author("Ananth", "Satyanarayana");
        Book book1 = new Book("123123", "Spring Framework");

        Author girish = new Author("Girish", "Nagaraj");
        Book book2 = new Book("234321", "MDS Fundamentals");

        Publisher publisher = new Publisher("Sapne Book House", "Majestic", "Bangalore", "Karnataka", 560076);

        ananth.getBooks().add(book1);
        book1.getAuthors().add(ananth);

        authorRepository.save(ananth);
        bookRepository.save(book1);

        girish.getBooks().add(book2);
        book2.getAuthors().add(girish);

        authorRepository.save(girish);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publishers " + publisherRepository.count());
        System.out.println(publisher.toString());

    }
}
