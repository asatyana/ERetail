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

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Sapna Book House");
        publisher.setCity("Bangalore");
        publisher.setState("Karnataka");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author smurthy = new Author("Sudha", "Murthy");
        Book short_stories = new Book("Short Stories", "12345");
        smurthy.getBooks().add(short_stories);
        short_stories.getAuthors().add(smurthy);

        short_stories.setPublisher(publisher);
        publisher.getBooks().add(short_stories);

        authorRepository.save(smurthy);
        bookRepository.save(short_stories);
        publisherRepository.save(publisher);

        Author bhayrappa = new Author("S L", "Bhayrappa");
        Book yaana = new Book("Yaana", "987654");
        bhayrappa.getBooks().add(yaana);
        yaana.getAuthors().add(bhayrappa);

        yaana.setPublisher(publisher);
        publisher.getBooks().add(yaana);

        authorRepository.save(bhayrappa);
        bookRepository.save(yaana);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
