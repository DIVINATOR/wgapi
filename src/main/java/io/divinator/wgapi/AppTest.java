package io.divinator.wgapi;

import io.divinator.wgapi.client.Region;
import io.divinator.wgapi.client.WgApiClient;
import io.divinator.wgapi.client.WgApiClientException;
import io.divinator.wgapi.method.wot.AuthenticationMethod;

public class AppTest {

    public static void main(String[] args) throws IllegalAccessException, WgApiClientException {

        WgApiClient client = new WgApiClient.Builder()
                .build();

        AuthenticationMethod methodBlock = client.getMethodBlock(AuthenticationMethod.class);
    }
}
