package br.com.soat8.techchallenge.infra.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.TrustSelfSignedStrategy;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        try {
            // Cria um SSLContext que ignora certificados inválidos
            SSLContext sslContext = SSLContextBuilder.create()
                    .loadTrustMaterial(new TrustSelfSignedStrategy())
                    .build();

            Registry<ConnectionSocketFactory> socketRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(URIScheme.HTTPS.getId(), new SSLConnectionSocketFactory(sslContext))
                    .register(URIScheme.HTTP.getId(), new PlainConnectionSocketFactory())
                    .build();

            HttpClient httpClient = HttpClientBuilder.create()
                    .setConnectionManager(new PoolingHttpClientConnectionManager(socketRegistry))
                    .setConnectionManagerShared(true)
                    .build();

            // Cria uma fábrica de requisições usando o HttpClient
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

            return builder
                    .requestFactory(() -> factory)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao configurar RestTemplate para ignorar certificados inválidos", e);
        }
    }
}
