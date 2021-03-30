package cc.ghast.packet.wrapper.packet.login;

import cc.ghast.packet.nms.ProtocolVersion;
import cc.ghast.packet.buffer.ProtocolByteBuf;
import cc.ghast.packet.wrapper.mc.GameProfile;
import cc.ghast.packet.wrapper.packet.Packet;
import cc.ghast.packet.wrapper.packet.ServerPacket;
import cc.ghast.packet.wrapper.packet.ReadableBuffer;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PacketLoginServerSuccess extends Packet<ServerPacket> implements ReadableBuffer {
    public PacketLoginServerSuccess(UUID player, ProtocolVersion version) {
        super("PacketLoginOutServerSuccess", player, version);
    }

    private GameProfile gameProfile;

    @Override
    public void read(ProtocolByteBuf byteBuf) {
        final UUID uuid;
        final String username;

        if (version.isOrAbove(ProtocolVersion.V1_15)) {
            int[] aint = new int[4];

            for(int i = 0; i < aint.length; ++i) {
                aint[i] = byteBuf.readInt();
            }

            uuid = decodeUUID(aint);
            username = byteBuf.readStringBuf(16);
        } else {
            final String uid = byteBuf.readStringBuf(36);
            uuid = UUID.fromString(uid);
            username = byteBuf.readStringBuf(16);
        }

        this.gameProfile = new GameProfile(uuid, username);
    }

    private static UUID decodeUUID(int[] bits) {
        return new UUID((long)bits[0] << 32 | (long)bits[1] & 4294967295L, (long)bits[2] << 32 | (long)bits[3] & 4294967295L);
    }
}
