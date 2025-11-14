// Testing Cookie Store. (2022_14_Prakash)
import java.net.URI;
import java.net.HttpCookie;

public class TestCookieStore {

    public static void main(String[] args) throws Exception {

        MyCookieStore store = new MyCookieStore();

        // Create some URIs
        URI uri1 = new URI("https://example.com");
        URI uri2 = new URI("https://google.com");

        // Create some cookies
        HttpCookie c1 = new HttpCookie("session", "12345");
        c1.setDomain("example.com");

        HttpCookie c2 = new HttpCookie("theme", "dark");
        c2.setDomain("example.com");

        HttpCookie c3 = new HttpCookie("userid", "999");
        c3.setDomain("google.com");

        // Add cookies
        store.add(uri1, c1);
        store.add(uri1, c2);
        store.add(uri2, c3);

        System.out.println("All cookies:");
        System.out.println(store.getCookies());

        System.out.println("\nCookies for example.com:");
        System.out.println(store.get(uri1));

        System.out.println("\nStored URIs:");
        System.out.println(store.getURIs());

        // Remove a cookie
        store.remove(uri1, c1);

        System.out.println("\nCookies after removing session cookie:");
        System.out.println(store.getCookies());

        // Remove all
        store.removeAll();

        System.out.println("\nAfter removeAll:");
        System.out.println(store.getCookies());
    }
}

