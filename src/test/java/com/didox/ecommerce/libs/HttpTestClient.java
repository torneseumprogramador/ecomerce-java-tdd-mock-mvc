package com.didox.ecommerce.libs;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

public class HttpTestClient {
    private static final String host = "http://localhost:8080/";

    public static int get(String path) throws ClientProtocolException, IOException{
        HttpGet get = new HttpGet(host + path);
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        get.addHeader("Content-Type", "application/json");
        var response = client.execute(get);
        return response.getStatusLine().getStatusCode();
    }

    public static int delete(String path) throws ClientProtocolException, IOException{
        HttpDelete get = new HttpDelete(host + path);
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        get.addHeader("Content-Type", "application/json");
        var response = client.execute(get);
        return response.getStatusLine().getStatusCode();
    }

    public static int post(String path, Object objeto) throws ClientProtocolException, IOException{
        HttpPost post = new HttpPost(host + path);

		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        post.addHeader("Content-Type", "application/json");

		String jsonFile = new Gson().toJson(objeto);
		HttpEntity entity = new StringEntity(jsonFile);
		post.setEntity(entity);

        var response = client.execute(post);
        
        return response.getStatusLine().getStatusCode();
    }

    public static int put(String path, Object objeto) throws ClientProtocolException, IOException{
        HttpPut put = new HttpPut(host + path);

		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = clientBuilder.build();
        put.addHeader("Content-Type", "application/json");

		String jsonFile = new Gson().toJson(objeto);
		HttpEntity entity = new StringEntity(jsonFile);
		put.setEntity(entity);

        var response = client.execute(put);
        
        return response.getStatusLine().getStatusCode();
    }
}
