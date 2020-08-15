package cc.ghast.packet.buffer.types.java;

import cc.ghast.packet.buffer.BufConverter;
import io.netty.buffer.ByteBuf;
import java.util.UUID;

public class UUIDConverter extends BufConverter<UUID> {
    public UUIDConverter() {
        super("uuid", UUID.class);
    }

    @Override
    public void write(ByteBuf buffer, UUID value) {
        buffer.writeLong(value.getMostSignificantBits());
        buffer.writeLong(value.getLeastSignificantBits());
    }

    @Override
    public UUID read(ByteBuf buffer, Object... args) {
        return new UUID(buffer.readLong(), buffer.readLong());
    }
}
