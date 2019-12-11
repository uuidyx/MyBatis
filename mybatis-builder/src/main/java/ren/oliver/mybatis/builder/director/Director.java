package ren.oliver.mybatis.builder.director;

import ren.oliver.mybatis.builder.builder.impl.RedPacketBuilderImpl;
import ren.oliver.mybatis.builder.product.RedPacket;

import java.math.BigDecimal;
import java.util.Date;

public class Director {

    public static void main(String[] args) {
        RedPacket redPacket = RedPacketBuilderImpl.getBulider().setPublisherName("lison")
                .setAcceptName("vip群")
                .setPacketAmount(new BigDecimal("888"))
                .setPacketType(1)
                .setOpenPacketTime(new Date())
                .setPulishPacketTime(new Date()).build();

        System.out.println(redPacket);
    }

}
