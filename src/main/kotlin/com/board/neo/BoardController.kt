package com.board.neo

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController {

    @PostMapping
    fun create() {

    }
}