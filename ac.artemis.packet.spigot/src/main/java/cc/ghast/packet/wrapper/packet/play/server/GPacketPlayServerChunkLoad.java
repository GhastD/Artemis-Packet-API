package cc.ghast.packet.wrapper.packet.play.server;

import ac.artemis.packet.protocol.ProtocolVersion;
import ac.artemis.packet.spigot.protocol.PacketLink;
import ac.artemis.packet.wrapper.server.PacketPlayServerChunkLoad;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import ac.artemis.packet.spigot.wrappers.GPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;

import java.util.UUID;

@PacketLink(PacketPlayServerChunkLoad.class)
public class GPacketPlayServerChunkLoad extends GPacket implements ReadableBuffer {
    public GPacketPlayServerChunkLoad(UUID player, ProtocolVersion version) {
        super("PacketPlayOutMapChunk", player, version);
    }

    @Override
    public void read(ProtocolByteBuf byteBuf) {

    }
}
