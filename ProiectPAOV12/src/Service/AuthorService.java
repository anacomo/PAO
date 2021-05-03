package Service;

import IO.Output;
import Library.Author;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthorService {
    private List<Author> authorList;
    private static AuthorService instance = null;

    private AuthorService() {
        authorList = new ArrayList<>();
    }

    public static AuthorService getInstance() {
        if(instance == null) {
            instance = new AuthorService();
        }
        return instance;
    }

    public void addAuthor(Author author, boolean csv) {
        boolean exists = false;
        for (Author a : authorList)
            if (a.equals(author)) {
                exists = true;
                break;
            }
        if(!exists) {
            authorList.add(new Author(author));
            if(!csv) {
                Output.writeAuthorOnCsv(author);
                Output.userAudit("Add Author");
            }
            sortAuthors();
        }
    }

    private void sortAuthors() {
        Collections.sort(authorList);
    }

    public void showAuthors() {
        for (Author a : authorList)
            System.out.println(a.toString());
    }
}
