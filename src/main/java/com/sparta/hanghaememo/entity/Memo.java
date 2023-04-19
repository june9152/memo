package com.sparta.hanghaememo.entity;

//import com.sparta.hanghaememo.dto.MemoRequestDto;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String password;

    public Memo(String username, String contents,String title,String date,String password) {
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();
        // 현재 날짜 구하기(Paris)
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.date = now.toString();
        this.password = password;
    }
    public Memo(MemoRequestDto requestDto) {
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now = LocalDate.now();
        // 현재 날짜 구하기(Paris)

        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.date = now.toString();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto memoRequestDto) {
        LocalDate now = LocalDate.now();
        // 현재 날짜 구하기(Paris)
        this.username = memoRequestDto.getUsername();
        this.contents = memoRequestDto.getContents();
        this.title = memoRequestDto.getTitle();
        this.date = now.toString();
        this.password = memoRequestDto.getPassword();
    }
}