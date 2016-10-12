package GoogleGuava.Multimaps;

/**
 * Created by islabukhin on 04.10.16.
 */
public class MultimapsSample {
    // Multimap is like a Map, but allow multiple values to be stored for every key.
    // The following example is a a variant of a typesafe hetereogeneous container using multimap
    // to realize a product catalogue of items.
    public static void main(String[] args) {
        ProductCatalogue catalogue = new ProductCatalogue();
        catalogue.add(new Book("1", "Book1"));
        catalogue.add(new Book("3", "Book2"));
        catalogue.add(new Movie("2", "Movie1"));
// only get books
        System.out.println("Books " + catalogue.list(Book.class));
// only get movies
        System.out.println("Movies " + catalogue.list(Movie.class));
    }
}

