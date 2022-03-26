package com.yqx.ssm.config;

import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author YangQX   2022/3/26 - 10:06
 */
public class UUIdUtils
{
    public static String getId()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
