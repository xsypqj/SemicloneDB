package com.semiclone.springboot.domain.ticket;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //  티켓 고유번호

    @Column
    private String accountId;

    @Column(nullable = false)
    private Long seatId;    //  좌석 고유번호

    @Column(nullable = false)
    private Long screenId;    //  상영관 고유번호

    @Column(nullable = false)
    private Long movieId;    //  영화 고유번호

    @Column(nullable = false)
    private Long timeTableId;    //  시간표 고유번호

    @Column(nullable = false)
    @ColumnDefault("5000")
    private int ticketPrice = 5000;    //  티켓 가격

    @Column(length = 1, nullable = false)
    @ColumnDefault("1")
    private char ticketState = '1';    //  티켓 진행상태

    @Builder
    public Ticket(Long seatId, Long screenId, Long movieId, Long timeTableId){
        this.seatId = seatId;
        this.screenId = screenId;
        this.movieId = movieId;
        this.timeTableId = timeTableId;
    }

    public void setTicketState(char ticketState){
        this.ticketState = ticketState;
    }

    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

}//end of class