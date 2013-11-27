import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suki
 * Date: 27/11/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyClass {

    public static void main (String[] args) throws Exception {
        MyClass myClass = new MyClass();

        //Search flight
        myClass.searchFlightAA();

        //Search any information on airasia website
        //myClass.searchWebAA();
    }

    public void searchFlightAA() throws Exception {
        String url = "http://booking.airasia.com/Select.aspx";
        HttpClient httpClient = HttpClientBuilder.create().build();

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        //Form Elements based on website
        nameValuePairs.add(new BasicNameValuePair("__VIEWSTATE","/wEPDwUKMTU1OTkyOTU2Nw9kFgJmDxYCHgZhY3Rpb24FLmh0dHA6Ly9ib29raW5nMTEuYWlyYXNpYS5jb20vUGFnZS9Db21wYWN0LmFzcHgWAgIBD2QWAmYPFgIeBWNsYXNzBTZ1Y1NlYXJjaEZvcm0gdWNTZWFyY2hGb3JtLUxBWU9VVC1jb21wYWN0IGN1bHR1cmUtaWQtSURkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYDBRRTZWFyY2hGb3JtJHJkYlJldHVybgUUU2VhcmNoRm9ybSRyZGJPbmVXYXkFFFNlYXJjaEZvcm0kcmRiT25lV2F5"));
        nameValuePairs.add(new BasicNameValuePair("__EVENTVALIDATION","/wEWJwK/l9mABALGkpvlAQKa6qXcAQKF2PKaCwLZ0+bGDQLirb7CAQLTrtToDgKIhYe4AgKB55yODQLXiKLwCQLWiKLwCQLViKLwCQLUiKLwCQLTiKLwCQLSiKLwCQLRiKLwCQLAiKLwCQLPiKLwCQKOres7ApGt6zsCkK3rOwKTres7ApKt6zsCla3rOwKUres7Apet6zsChq3rOwKJres7Asn1/KsEAtb1/KsEAtf1/KsEAtT1/KsEAtX1/KsEAvjlgcAFAvP3hpwDAuXXvpAPAp701+oGAsrfhe0OAuOxvN8H"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$rdgFlightType","rdbReturn"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$cmbDepartureStation","CGK"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$cmbArrivalStation","DPS"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$txtDepartDate","2013-11-29"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$txtReturnDate","2013-12-03"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$cmbNoAdult","1"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$cmbNoChild","0"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$cmbNoInfant","0"));
        nameValuePairs.add(new BasicNameValuePair("SearchForm$hfCurrency","IDR"));
        nameValuePairs.add(new BasicNameValuePair("hfCulture","id-ID"));
        nameValuePairs.add(new BasicNameValuePair("hfCountry","ID"));
        nameValuePairs.add(new BasicNameValuePair("hfLanguage","ID"));
        nameValuePairs.add(new BasicNameValuePair("",""));

        HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairs);

        HttpPost post = new HttpPost(url);
        post.setEntity(httpEntity);
        HttpResponse httpResponse = httpClient.execute(post);
        HttpEntity entity = httpResponse.getEntity();
        String response = entity != null ? EntityUtils.toString(entity) : "No Response";

        System.out.println(response);
    }

    public void searchWebAA() throws Exception{
        String url = "http://www.airasia.com/ask/search-templates.do";
        HttpClient httpClient = HttpClientBuilder.create().build();

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("query","kelebihan bagasi"));
        nameValuePairs.add(new BasicNameValuePair("action","search"));
        nameValuePairs.add(new BasicNameValuePair("locale","in_ID"));
        HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairs);

        HttpPost post = new HttpPost(url);
        post.setEntity(httpEntity);
        HttpResponse httpResponse = httpClient.execute(post);
        HttpEntity entity = httpResponse.getEntity();
        String response = entity != null ? EntityUtils.toString(entity) : "No Response";

        System.out.println(response);
    }
}
