package com.board.neo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping
    fun create(
        @RequestBody boardDto: BoardDto,
    ) {
        boardService.create(boardDto)
    }

    @GetMapping
    fun getAll(): List<BoardDto> {
        return boardService.getAll()
    }

    @GetMapping("/{id}")
    fun getByID(@PathVariable("id") id: Long): BoardDto {
        return boardService.getById(id)
    }

    @PatchMapping
    fun update(
        @RequestBody boardDto: BoardDto,
    ) {
        boardService.update(boardDto)
    }
}