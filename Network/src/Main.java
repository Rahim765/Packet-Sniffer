import org.jnetpcap.Pcap;
import org.jnetpcap.packet.JPacketHandler;

public class Main {

    public static void main(String[] args) {
        StringBuilder errbuf = new StringBuilder();
        String folderpath = "C:\\Users\\HP\\IdeaProjects\\Network\\src\\pack.pcap";
        Pcap pcap = Pcap.openOffline(folderpath,errbuf);
        JPacketHandler<Pcap> byteJPacketHandler = (jPacket, aByte) -> {
            Link link = new Link();
            Network network = new Network();
            Transport transport = new Transport();
            Merger merger = new Merger(link,network,transport,jPacket);
            System.out.println(merger);
        };
        pcap.dispatch(-1, byteJPacketHandler, pcap);

    }
}

