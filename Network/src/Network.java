public class Network {

    Ipv4 ipv4;
    Ipv6 ipv6 ;
    Arp arp ;
    @Override
    public String toString() {
        if (ipv4!=null){
            return "Network{" +
                    "ipv4=" + ipv4 +"}";
        }else if(ipv6!=null){
            return "Network{" +
                    "ipv6=" + ipv6 +"}";
        }else {
            return "Network{" +
                    "arp=" + arp + "}";
        }
    }
}
