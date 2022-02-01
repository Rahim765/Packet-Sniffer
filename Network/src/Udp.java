public class Udp {

    private int srcPort;
    private int desPort;


    public void setSrcPort(byte[] bytes) {
        this.srcPort = Byte.toUnsignedInt(bytes[0])*256+Byte.toUnsignedInt(bytes[1]);
    }

    public void setDesPort(byte[] bytes) {
        this.desPort = Byte.toUnsignedInt(bytes[0])*256+Byte.toUnsignedInt(bytes[1]);
    }


    @Override
    public String toString() {
        return "Udp{" +
                "srcPort=" + srcPort +
                ", desPort=" + desPort +
                '}';
    }
}
