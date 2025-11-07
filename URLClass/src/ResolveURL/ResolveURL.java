// 4. Write a program for resolving relative URL.
// [https://kathford.edu.np/about-us/, /kathford-scholarships] (2022_14_Prakash)

package ResolveURL;
import java.net.MalformedURLException;
import java.net.URL;

public class ResolveURL {
    public static void main(String[] args) {
        try {
            // Base URL
            URL baseURL = new URL("https://kathford.edu.np/about-us/");

            // Relative path (not a full URL)
            String relativePath = "/kathford-scholarships";

            // Resolve the relative path against the base URL
            URL resolvedURL = new URL(baseURL, relativePath);

            System.out.println("Base URL:      " + baseURL);
            System.out.println("Relative URL:  " + relativePath);
            System.out.println("Resolved URL:  " + resolvedURL);

        } catch (MalformedURLException e) {
            System.out.println("❌ Invalid URL: " + e.getMessage());
        }
    }
}
