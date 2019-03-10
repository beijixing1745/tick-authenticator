package com.lingyejun.authenticator;

import java.util.concurrent.TimeUnit;

/**
 * 参数配置
 *
 * @Author: lingyejun
 * @Date: 2019/2/22
 * @Describe: 
 * @Modified By:
 */
public class TickAuthenticatorConfig {

    // OTP长度
    private int digit = 6;

    // 用于取模计算的基数
    private int modDigit = (int) Math.pow(10, digit);

    // OTP的步长
    private long timeStepMills = TimeUnit.SECONDS.toMillis(30);

    // Hmac的类型
    private String hmacType = HmacTypeEnum.HmacSHA1.getHmacType();

    public int getDigit() {
        return digit;
    }

    public int getModDigit() {
        return modDigit;
    }


    public static class AuthenticatorConfigBuilder {

        private TickAuthenticatorConfig config = new TickAuthenticatorConfig();

        public TickAuthenticatorConfig build() {
            return config;
        }

        public AuthenticatorConfigBuilder setDigit(int digit) {

            if (digit <= 0) {

                throw new IllegalArgumentException("number of digit not be negative.");
            }

            if (digit < 6) {
                throw new IllegalArgumentException("minimum number of digit is 6.");
            }

            if (digit > 8) {
                throw new IllegalArgumentException("maximum digit number of is 8.");
            }

            config.digit = digit;
            config.modDigit = (int) Math.pow(10, digit);
            return this;
        }

        public AuthenticatorConfigBuilder setTimeStepMills(long timeStepMills) {

            if (timeStepMills <= 0) {
                throw new IllegalArgumentException("time step not be negative.");
            }

            config.timeStepMills = timeStepMills;
            return this;
        }
    }
}
