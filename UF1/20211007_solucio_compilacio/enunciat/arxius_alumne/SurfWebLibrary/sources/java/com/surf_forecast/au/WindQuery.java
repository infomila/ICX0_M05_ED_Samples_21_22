package com.surf_forecast.au;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.Callable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Utilitza la p�gina web http://es.surf-forecast.com/ per consultar la for�a
 * del vent a una platja de les que es disposa informaci�. Cal proporcionar un
 * codi de platja conegut per la web.
 *
 * @author BERNAT
 */
public class WindQuery implements Callable<String> {

    private String mCodiPlatja;

    public WindQuery(String codiPlatja) {
        this.mCodiPlatja = codiPlatja;
    }

    @Override
    public String call() throws Exception {
        return WindQuery.forcaVent(this.mCodiPlatja);
    }

    private static void disableSSLCertCheck() throws NoSuchAlgorithmException, KeyManagementException {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    /**
     * Funci� que consulta a la p�gina web de la platja i n'extreu la velocitat
     * actual del vent. NOTES: - aquesta funci� requereix connexi� a Internet -
     * est� programada usant l'util�ssima API JSoup.
     *
     * @param codiPlatja �s el codi de la platja de la que busquem el vent
     * @return la velocitat del vent en kil�metres per hora
     */
    public static String forcaVent(String codiPlatja) {
        try {
            String url = "https://es.surf-forecast.com/breaks/" + codiPlatja + "/forecasts/feed/m";
            System.out.println(">" + url + "|");
            disableSSLCertCheck();
            Document doc = Jsoup.connect(url).get();
            System.out.println("*");
            //System.out.printf(".ttt>"+title );
            //String title = doc.toString();

            Elements e = doc.select("#table-current .windcell span");

            System.out.printf(".>" + e.text());
            return e.text();//Integer.parseInt(e.text());

        } catch (Exception e) {
            //e.printStackTrace();
            return "not found";
        }
    }

    public String getCodiPlatja() {
        return mCodiPlatja;
    }

}
