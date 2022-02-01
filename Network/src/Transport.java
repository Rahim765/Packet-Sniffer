public class Transport {
    Udp udp;
    Tcp tcp;

    @Override
    public String toString() {
        if (udp!=null){
            return "Transport{" +
                    "Udp=" + udp +
                    '}';
        }else {
            return "Transport{" +
                    "Tcp=" + tcp +
                    '}';
        }
    }
}
