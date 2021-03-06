package io.patriot_framework.network_simulator.kubernetes.utils;

import io.patriot_framework.network_simulator.kubernetes.device.KubeDevice;

/**
 * Class containing static methods that are used as utils.
 */
public class Utils {
    public static final String HTTP_COAP_TESTING_APP_IMAGE = "jsmadis/patriot-http-coap-testing-app:latest";

    /**
     * Returns Kubernetes URL where to run the tests.
     *
     * @return kubernetes URL
     */
    public static String getKubernetesUrl() {
        String url = System.getenv("PATRIOT_KUBERNETES_URL");
        if (url == null || url.equals("")) {
            throw new IllegalArgumentException(
                    "You need to specify ENV variable PATRIOT_KUBERNETES_URL with valid kubernetes URL");
        }
        return url;
    }

    /**
     * Returns local IP address of machine,
     * it is used for deployed devices in order to make it possible to access them from this machine
     *
     * @return local IP address
     */
    public static String getLocalIp() {
        String ip = System.getenv("PATRIOT_LOCAL_IP_ADDR");
        if (ip == null || ip.equals("")) {
            throw new IllegalArgumentException(
                    "You need to specify ENV variable PATRIOT_LOCAL_IP_ADDR with valid IP address of this PC");
        }
        return ip;
    }

    /**
     * Creates http url from given arguments
     *
     * @param device KubeDevice to get public IP from
     * @param path   path of the URL
     * @return URL in format http://<device_public_ip>:<device_management_port><path>
     */
    public static String httpTestingHostname(KubeDevice device, String path) {
        return String.format("http://%s:%s%s", device.getPublicIpAddress(), device.getManagementPort().getPort(), path);
    }
}
