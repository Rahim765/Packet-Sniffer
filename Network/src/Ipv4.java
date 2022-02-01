public class Ipv4 {
     String version;
     int length;
     int ttl;
     String protocol;
     String srcIpv4;
     String desIpv4;



    public String getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        if (version == 69) {
            this.version = "4";
        }

    }

    public int getLength() {
        return length;
    }

    public void setLength(byte[] bytes) {
        this.length = Byte.toUnsignedInt(bytes[0]) * 256 + Byte.toUnsignedInt(bytes[1]);
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(byte ttl) {
        this.ttl = Byte.toUnsignedInt(ttl);
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(byte protocol) {
        if (protocol == 6) {
            this.protocol = "tcp";
        } else if (protocol == 17||protocol==2) {
            this.protocol = "udp";
        } else if (protocol == 1) {
            this.protocol = "icmp";
        }
    }


    public void setSrcIpv4(byte[] bytes) {
        int x = Byte.toUnsignedInt(bytes[0]);
        int x2 = Byte.toUnsignedInt(bytes[1]);
        int x3 = Byte.toUnsignedInt(bytes[2]);
        int x4 = Byte.toUnsignedInt(bytes[3]);
        this.srcIpv4 = x + "." + x2 + "." + x3 + "." + x4;
    }


    public void setDesIpv4(byte[] bytes) {

        int y = Byte.toUnsignedInt(bytes[0]);
        int y2 = Byte.toUnsignedInt(bytes[1]);
        int y3 = Byte.toUnsignedInt(bytes[2]);
        int y4 = Byte.toUnsignedInt(bytes[3]);
        this.desIpv4 = y + "." + y2 + "." + y3 + "." +y4;

    }

    @Override
    public String toString() {
        return "Ipv4{" +
                "version='" + version + '\'' +
                ", ttl=" + ttl +
                ", protocol='" + protocol + '\'' +
                ", sourceIpv4='" + srcIpv4 + '\'' +
                ", destinationIpv4='" + desIpv4 + '\'' +
                '}';
    }
}
