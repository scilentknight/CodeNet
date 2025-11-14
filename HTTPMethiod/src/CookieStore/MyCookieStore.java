package CookieStore;// Write a program to implement the CookieStore Methods
// (add, get, getcookies, getURIs, remove, removeAll) cookies. (2022_14_Prakash)
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MyCookieStore implements CookieStore{
    List<HttpCookie> cookieList;
    MyCookieStore(){
        cookieList = new ArrayList<HttpCookie>();
    }

    @Override
    public void add(URI uri, HttpCookie cookie) {
        cookieList.add(cookie);
    }

    @Override
    public List<HttpCookie> get(URI uri) {
        List<HttpCookie> result = new ArrayList<HttpCookie>();
        for (HttpCookie cookie : cookieList){
            if(cookie.getDomain().equals(uri.getHost())){
                result.add(cookie);
            }
        }
        return result;
    }

    @Override
    public List<HttpCookie> getCookies() {
        return cookieList;
    }

    @Override
    public List<URI> getURIs() {
        List<URI> uriList = new ArrayList<URI>();
        for (HttpCookie cookie : cookieList){
            try{
                URI uri = new URI(cookie.getDomain());
                uriList.add(uri);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return uriList;
    }

    @Override
    public boolean remove(URI uri, HttpCookie cookie) {
        return cookieList.remove(cookie);
    }

    @Override
    public boolean removeAll() {
        cookieList.clear();
        return true;
    }
}
