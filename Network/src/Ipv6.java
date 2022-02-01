public class Ipv6 {

    private String version;
    private String nextHeader;
    private String srcIPV6;
    private String desIPV6;

    public String getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        if (version == 96) {
            this.version = "ipv6";
        }
    }


    public void setNextHeader(byte b) {
        if (b == 6) {
            this.nextHeader = "tcp";
        } else {
            this.nextHeader = "udp";
        }
    }


    public void setSrcIPV6(byte[] sourceIPV6) {
        this.srcIPV6 = converter(sourceIPV6);
    }


    public void setDesIPV6(byte[] destinationIPV6) {
        this.desIPV6 = converter(destinationIPV6);
    }


    private String converter(byte[] desMac) {
        StringBuilder sb = new StringBuilder();
        for (byte b : desMac) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Ipv6{" +
                "versionV6='" + version + '\'' +
                ", nextHeaderV6='" + nextHeader + '\'' +
                ", sourceIPV6='" + srcIPV6 + '\'' +
                ", destinationIPV6='" + desIPV6 + '\'' +
                '}';
    }
}
