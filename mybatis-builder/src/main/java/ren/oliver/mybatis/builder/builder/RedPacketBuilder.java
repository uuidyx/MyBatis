package ren.oliver.mybatis.builder.builder;

import ren.oliver.mybatis.builder.product.RedPacket;

import java.math.BigDecimal;
import java.util.Date;

public interface RedPacketBuilder {

    RedPacketBuilder setPublisherName(String publishName);

    RedPacketBuilder setAcceptName(String acceptName);

    RedPacketBuilder setPacketAmount(BigDecimal packetAmount);

    RedPacketBuilder setPacketType(int packetType);

    RedPacketBuilder setPulishPacketTime(Date pushlishPacketTime);

    RedPacketBuilder setOpenPacketTime(Date openPacketTime);

    RedPacket build();

}
