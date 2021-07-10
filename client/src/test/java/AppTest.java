import io.github.divinator.wgapi.client.Cluster;
import io.github.divinator.wgapi.client.Parameter;
import io.github.divinator.wgapi.client.Region;
import io.github.divinator.wgapi.client.WgApiUriBuilder;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void test() {
        WgApiUriBuilder wgApiUriBuilder = new WgApiUriBuilder()
                .withRegion(Region.RU)
                .withCluster(Cluster.WARGAMING)
                .withMethod("a", "b")
                .withApplicationID("1231")
                .withParameters(new Parameter("a", 1), new Parameter("b", 2), new Parameter("c", 3));
    }
}
