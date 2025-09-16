package com.board.neo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class BoardEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    var content: String,

    val name: String,

) {

    fun update(boardDto: BoardDto) {
        this.title = boardDto.title
        this.content = boardDto.content
    }
}