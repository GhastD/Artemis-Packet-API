package ac.artemis.packet.wrapper.server;

import ac.artemis.packet.wrapper.PacketServer;

public interface PacketPlayServerItemHeldSlot extends PacketServer {
    short getSlot();
}
