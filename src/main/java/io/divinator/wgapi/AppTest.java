package io.divinator.wgapi;

import io.divinator.wgapi.client.Cluster;
import io.divinator.wgapi.client.Parameter;
import io.divinator.wgapi.client.Region;
import io.divinator.wgapi.client.WgApiUriBuilder;

public class AppTest {
    public static void main(String[] args) {
        WgApiUriBuilder wgApiUriBuilder = new WgApiUriBuilder()
                .withRegion(Region.RU)
                .withCluster(Cluster.WARGAMING)
                .withMethod("a", "b")
                .withApplicationID("1231")
                .withParameters(new Parameter("a", 1), new Parameter("b", 2), new Parameter("c", 3));

        System.out.println(wgApiUriBuilder);
        System.out.println(wgApiUriBuilder.getParamsToString());
    }
}
