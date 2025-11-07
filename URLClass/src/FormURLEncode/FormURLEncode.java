// 6. Write a program to demonstrate the x-www-form-urlencoded strings. (2022_14_Prakash)
package FormURLEncode;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class FormURLEncode {
    public static void main(String[] args) {
        try {
            // Sample form data
            String name = "Scilent Knight";
            String age = "22";
            String city = "Kathmandu";

            // Encode each key-value pair
            String encodedName = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
            String encodedAge = URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age, "UTF-8");
            String encodedCity = URLEncoder.encode("city", "UTF-8") + "=" + URLEncoder.encode(city, "UTF-8");

            // Combine all parameters with &
            String formData = encodedName + "&" + encodedAge + "&" + encodedCity;

            System.out.println("x-www-form-urlencoded string:");
            System.out.println(formData);

        } catch (UnsupportedEncodingException e) {
            System.err.println("❌ Encoding not supported: " + e.getMessage());
        }
    }
}
