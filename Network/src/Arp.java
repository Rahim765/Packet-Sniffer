public class Arp {

    private String protocolType;
    private String src_Mac_Add;
    private String srcIp;
    private String desIp;
    private String des_Mac_Add;



    public void setProtocolType(byte[] bytes) {
        if (bytes[0] == 8 && bytes[1] == 0) {
            this.protocolType = "ipv4";
        }
    }




    public void setSrc_Mac_Add(byte[] src_mac_add) {
        this.src_Mac_Add = converter(src_mac_add);
    }



    public void setSrcIp(byte[] bytes) {
        int x = Byte.toUnsignedInt(bytes[0]);
        int x1 = Byte.toUnsignedInt(bytes[1]);
        int x2 = Byte.toUnsignedInt(bytes[2]);
        int x3 = Byte.toUnsignedInt(bytes[3]);
        this.srcIp = x + "." + x1 + "." + x2 + "." + x3;
    }



    public void setDesIp(byte[] bytes) {
        int y = Byte.toUnsignedInt(bytes[0]);
        int y1 = Byte.toUnsignedInt(bytes[1]);
        int y2 = Byte.toUnsignedInt(bytes[2]);
        int y3 = Byte.toUnsignedInt(bytes[3]);
        this.desIp = y + "." + y1 + "." + y2 + "." + y3;

    }



    public void setDes_Mac_Add(byte[] bytes) {
        this.des_Mac_Add = converter(bytes);
    }

    private String converter(byte[] destinationMacAddress) {
        StringBuilder sb = new StringBuilder();
        for (byte b : destinationMacAddress) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Arp{" +
                ", protocolType='" + protocolType + '\'' +
                ", sourceMacAddressArp='" + src_Mac_Add + '\'' +
                ", sourceIpArp='" + srcIp+ '\'' +
                ", destinationIpArp='" + desIp + '\'' +
                ", destinationMacAddress='" + des_Mac_Add + '\'' +
                '}';
    }
}
