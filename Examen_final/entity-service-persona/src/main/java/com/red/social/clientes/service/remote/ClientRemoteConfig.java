package com.red.social.clientes.service.remote;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

import static feign.FeignException.errorStatus;

public class ClientRemoteConfig {
    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            InputStream initialStream;
            byte[] targetArray;
            String result = "";
            try {
                initialStream = response.body().asInputStream();
                targetArray = new byte[initialStream.available()];
                initialStream.read(targetArray);
                result = new String(targetArray);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            if (response.status() >= 400 && response.status() <= 499) {
                return new ClientException(response.reason(), response.status(), result);
            }
            if (response.status() >= 500 && response.status() <= 599) {
                return new RuntimeException(response.reason());
            }
            return errorStatus(methodKey, response);
        };
    }
}
