package org.jpstale.server.common.protocol.account;

/**
 * 账号标志位（对应 account.h 中 EAccountFlag，按位或组合）。
 */
public final class AccountFlag {
    private AccountFlag() {}

    public static final int NotExist         = -1;
    public static final int Invalid          = 0;
    public static final int Mule             = 1;
    public static final int Activated        = 2;
    public static final int EventGM          = 4;
    public static final int Supporter        = 8;
    public static final int GameMaster       = 16;
    public static final int AcceptedLatestTOA = 32;
    public static final int Approved         = 64;
    public static final int MustConfirm      = 128;
    public static final int GMIPRequired     = 256;
}
