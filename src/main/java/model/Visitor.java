package model;

import lombok.*;
import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Visitor {

    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private ArrayList<Book> favoriteBooks;
}