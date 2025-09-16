package com.board.neo

import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    fun create(
        boardDto: BoardDto
    ) {
        val boardEntity = BoardEntity(
            title = boardDto.title,
            content = boardDto.content,
            name = boardDto.name
        )

        boardRepository.save(boardEntity)
    }

    fun getAll(): List<BoardDto> {
        val boardEntities = boardRepository.findAll()
        val boardDtos = boardEntities.map {
            it -> BoardDto(id = it.id, title = it.title, content = it.content, name = it.name)
        }
        return boardDtos
    }

    fun getById(id: Long): BoardDto {
        val board = boardRepository.findById(id).orElseThrow { IllegalArgumentException("Board with id $id not found") }
        return BoardDto(board.id, board.title, board.content, board.name)
    }

    fun update(boardDto: BoardDto) {
        val id = boardDto.id!!
        val board = boardRepository.findById(id).orElseThrow { IllegalArgumentException("Board with id $id not found") }
        board.update(boardDto)
        boardRepository.save(board)
    }
}