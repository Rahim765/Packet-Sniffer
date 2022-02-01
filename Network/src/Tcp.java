public class Tcp {

    int srcPort;
    int desPort;
    long seqNum;
    long acknowledgmentNumber;




    public void setSrcPort(byte[] bytes) {
        this.srcPort = Byte.toUnsignedInt(bytes[0]) * 256 + Byte.toUnsignedInt(bytes[1]);
    }



    public void setDesPort(byte[] bytes) {
        this.desPort = Byte.toUnsignedInt(bytes[0]) * 256 + Byte.toUnsignedInt(bytes[1]);
        ;
    }



    public void setSeqNum(byte[] bytes) {
        this.seqNum = Byte.toUnsignedInt(bytes[0]) * 256 * 256 * 256 + Byte.toUnsignedInt(bytes[1]) * 256 * 256 + Byte.toUnsignedInt(bytes[2]) * 256 + Byte.toUnsignedInt(bytes[3]);
    }




    public void setAcknowledgmentNumber(byte[] bytes) {
        acknowledgmentNumber = Byte.toUnsignedInt(bytes[0]) * 256 * 256 * 256 + Byte.toUnsignedInt(bytes[1]) * 256 * 256 + Byte.toUnsignedInt(bytes[2]) * 256 + Byte.toUnsignedInt(bytes[3]);
    }



    @Override
    public String toString() {
        return "Tcp{" +
                "srcPort=" + srcPort +
                ", desPort=" + desPort +
                ", seqNum=" + seqNum +
                ", acknowledgmentNumber=" + acknowledgmentNumber +
                '}';
    }
}
