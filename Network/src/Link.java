public class Link {
    String src_Mac_Add;
    String des_Ma_Add;
    String type;

    public void setType(byte[] bytes) {
        if (bytes[0] == 8 && bytes[1] == 0) {
            this.type = "ipv4";
        }else if (bytes[0] == -122 && bytes[1] == -35) {
            this.type = "ipv6";
        } else if (bytes[0] == 8 && bytes[1] == 6) {
            this.type = "arp";
        }
    }


    public void setSrc_Mac_Add(byte[] src_Mac_Add) {
        this.src_Mac_Add = converter(src_Mac_Add);
    }

    public void setDes_Ma_Add(byte[] des_Ma_Add) {
        this.des_Ma_Add = converter(des_Ma_Add);
    }

    private String converter(byte[] destinationMacAddress) {
        StringBuilder sb = new StringBuilder();
        for (byte b : destinationMacAddress) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Link{" +
                "src_Mac_Add='" + src_Mac_Add + '\'' +
                ", des_Ma_Add='" + des_Ma_Add + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
