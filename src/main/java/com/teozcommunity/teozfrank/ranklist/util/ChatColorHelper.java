package com.teozcommunity.teozfrank.ranklist.util;

import org.bukkit.ChatColor;

public class ChatColorHelper
{

    public ChatColorHelper()
    {
    }

    public static String replaceColorCodes(String message)
    {
        ChatColor achatcolor[];
        int j = (achatcolor = ChatColor.values()).length;
        for(int i = 0; i < j; i++)
        {
            ChatColor color = achatcolor[i];
            message = message.replaceAll(String.format("&%c", new Object[] {
                Character.valueOf(color.getChar())
            }), color.toString());
        }

        return message;
    }
}
