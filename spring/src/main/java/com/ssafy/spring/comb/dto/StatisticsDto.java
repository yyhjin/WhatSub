package com.ssafy.spring.comb.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class StatisticsDto {

    private Gender gender;
    private Age age;
    private Subti subti;
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Gender {
        private int male;
        private int female;
    }
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Age {
        private int teenager;
        private int twenties;
        private int thirties;
        private int forties;
        private int fifties;
        private int sixties;
    }
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Subti {
        private int LSAH;
        private int LSAM;
        private int LSEH;
        private int LSEM;
        private int LCAH;
        private int LCAM;
        private int LCEH;
        private int LCEM;
        private int ISAH;
        private int ISAM;
        private int ISEH;
        private int ISEM;
        private int ICAH;
        private int ICAM;
        private int ICEH;
        private int ICEM;
    }

}
