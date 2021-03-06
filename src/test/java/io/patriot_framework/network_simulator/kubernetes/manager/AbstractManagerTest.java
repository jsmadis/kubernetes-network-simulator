package io.patriot_framework.network_simulator.kubernetes.manager;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.patriot_framework.network_simulator.kubernetes.utils.Utils;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractManagerTest {
    protected static KubernetesClient kubernetesClient;
    protected static KubernetesManager kubernetesManager;

    @BeforeAll
    public static void setup() {
        Config config = new ConfigBuilder().withMasterUrl(Utils.getKubernetesUrl()).build();
        kubernetesClient = new DefaultKubernetesClient(config);
        kubernetesManager = new KubernetesManager(kubernetesClient);
    }
}
