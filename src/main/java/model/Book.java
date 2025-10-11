package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Book {

    private String name;
    private String author;
    private int publishingYear;
    private String isbn;
    private String publisher;
}
