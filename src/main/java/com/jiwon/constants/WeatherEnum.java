package com.jiwon.constants;

public enum WeatherEnum {
    /* *
    * 기상청 단기예보 API 제공 시간
    * Base_time : 0200, 0500, 0800, 1100, 1400, 1700, 2000, 2300
    * API UPDATE : 0215, 0510, 0810, 1110, 1410, 1710, 2010, 2310
    * */
    POP("POP","강수확률"),
    PTY("PTY","강수형태"),
    PCP("PCP","1시간 강수량"),
    REH("REH","습도"),
    SNO("SNO","1시간 신적설"),
    SKY("SKY","하늘상태"),
    TMP("TMP","1시간 기온"),
    TMN("TMN","일 최저기온"),
    TMX("TMX","일 최고기온"),
    UUU("UUU","풍속(동서성분)"),
    VVV("VVV","풍속(남북성분)"),
    WAV("WAV","파고"),
    VEC("VEC","풍향"),
    WSD("WSD","풍속");



    private final String label;
    private final String korean;

    WeatherEnum(String label,String korean) {
        this.label = label;
        this.korean = korean;
    }

    public String getLabel() {
        return label;
    }

    public String getKorean(){
        return korean;
    }
    public static String getKoreanByLabel(String label) {
        for (WeatherEnum weatherEnum : WeatherEnum.values()) {
            if (weatherEnum.label.equals(label)) {
                return weatherEnum.getKorean();
            }
        }
        return null;
    }
}
