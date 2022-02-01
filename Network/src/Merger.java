import org.jnetpcap.packet.JPacket;

public class Merger {
    Link link;
    Network network;
    Transport transport;
    JPacket jPacket;
    public Merger(Link link, Network network , Transport transport , JPacket jPacket){
        setjPacket(jPacket);
        setLink(link);
        setNetwork(network);
        setTransport(transport);
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
        if (network.ipv4!=null) {
            switch (network.ipv4.getProtocol()) {
                case "tcp":
                    transport.tcp = new Tcp();
                    transport.tcp.setSrcPort(new byte[]{jPacket.getByte(34), jPacket.getByte(35)});
                    transport.tcp.setDesPort(new byte[]{jPacket.getByte(36), jPacket.getByte(37)});
                    transport.tcp.setSeqNum(new byte[]{jPacket.getByte(38), jPacket.getByte(39), jPacket.getByte(40), jPacket.getByte(41)});
                    transport.tcp.setAcknowledgmentNumber(new byte[]{jPacket.getByte(42), jPacket.getByte(43), jPacket.getByte(44), jPacket.getByte(45)});
                    break;
                case "udp":
                    transport.udp = new Udp();
                    transport.udp.setSrcPort(new byte[]{jPacket.getByte(34), jPacket.getByte(35)});
                    transport.udp.setDesPort(new byte[]{jPacket.getByte(36), jPacket.getByte(37)});
                    break;
            }
        }
    }

    public void setNetwork(Network network) {
        this.network = network;

        switch (link.getType()) {
            case "ipv4":
                network.ipv4 = new Ipv4();
                network.ipv4.setVersion(jPacket.getByte(14));
                network.ipv4.setLength(new byte[]{jPacket.getByte(16), jPacket.getByte(17)});
                network.ipv4.setTtl(jPacket.getByte(22));
                network.ipv4.setProtocol(jPacket.getByte(23));
                network.ipv4.setDesIpv4(new byte[]{jPacket.getByte(30), jPacket.getByte(31), jPacket.getByte(32), jPacket.getByte(33)});
                network.ipv4.setSrcIpv4(new byte[]{jPacket.getByte(26), jPacket.getByte(27), jPacket.getByte(28), jPacket.getByte(29)});
                break;
            case "arp":
                network.arp = new Arp();
                network.arp.setProtocolType(new byte[]{jPacket.getByte(16), jPacket.getByte(17)});
                network.arp.setSrc_Mac_Add(new byte[]{jPacket.getByte(22), jPacket.getByte(23), jPacket.getByte(24), jPacket.getByte(25), jPacket.getByte(26), jPacket.getByte(27)});
                network.arp.setDes_Mac_Add(new byte[]{jPacket.getByte(32), jPacket.getByte(33), jPacket.getByte(34), jPacket.getByte(35), jPacket.getByte(36), jPacket.getByte(37)});
                network.arp.setSrcIp(new byte[]{jPacket.getByte(28), jPacket.getByte(29), jPacket.getByte(30), jPacket.getByte(31)});
                network.arp.setDesIp(new byte[]{jPacket.getByte(38), jPacket.getByte(39), jPacket.getByte(40), jPacket.getByte(41)});
                break;
            case "ipv6":
                network.ipv6=new Ipv6();
                network.ipv6.setVersion(jPacket.getByte(14));
                network.ipv6.setNextHeader(jPacket.getByte(20));
                network.ipv6.setSrcIPV6(new byte[]{jPacket.getByte(22), jPacket.getByte(23), jPacket.getByte(24),
                        jPacket.getByte(25), jPacket.getByte(26), jPacket.getByte(27), jPacket.getByte(28),
                        jPacket.getByte(29), jPacket.getByte(30), jPacket.getByte(31), jPacket.getByte(32),
                        jPacket.getByte(33), jPacket.getByte(34), jPacket.getByte(35), jPacket.getByte(36),
                        jPacket.getByte(37),});
                network.ipv6.setDesIPV6(new byte[]{jPacket.getByte(38), jPacket.getByte(39), jPacket.getByte(40),
                        jPacket.getByte(41), jPacket.getByte(42), jPacket.getByte(43), jPacket.getByte(44),
                        jPacket.getByte(45), jPacket.getByte(46), jPacket.getByte(47), jPacket.getByte(48),
                        jPacket.getByte(49), jPacket.getByte(50), jPacket.getByte(51), jPacket.getByte(52),
                        jPacket.getByte(53),});
                break;
        }
    }

    public void setjPacket(JPacket jPacket) {
        this.jPacket = jPacket;
    }

    public void setLink(Link link){
        this.link = link;
        byte[] dMac = {jPacket.getByte(0), jPacket.getByte(1), jPacket.getByte(2), jPacket.getByte(3), jPacket.getByte(4), jPacket.getByte(5)};
        link.setDes_Ma_Add(dMac);
        byte[] sMac = {jPacket.getByte(6), jPacket.getByte(7), jPacket.getByte(8), jPacket.getByte(9), jPacket.getByte(10), jPacket.getByte(11)};
        link.setSrc_Mac_Add(sMac);
        link.setType(new byte[]{jPacket.getByte(12), jPacket.getByte(13)});
    }

    @Override
    public String toString() {
        return "Merger{\n"
                 + link +
                "\n" + network +
                "\n" + transport +
                "}\n";
    }
}
