package cc.ghast.packet.wrapper.packet.play.client;

import cc.ghast.packet.nms.ItemNMS;
import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.nbt.WrappedItem;
import cc.ghast.packet.wrapper.packet.ClientPacket;
import cc.ghast.packet.wrapper.packet.Packet;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketPlayClientSetCreativeSlot extends Packet<ClientPacket> {
    public PacketPlayClientSetCreativeSlot(UUID player, ProtocolVersion version) {
        super(player, version);
    }

    private int slot;
    private WrappedItem item;

    @Override
    public void handle(ProtocolByteBuf byteBuf) {
        this.slot = byteBuf.readShort();
        this.item = byteBuf.readItem();
    }
}
