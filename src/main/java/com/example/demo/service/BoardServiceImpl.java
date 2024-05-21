package com.example.demo.service;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.request.BoardRequest;
import com.example.demo.domain.response.BoardResponse;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public BoardResponse getById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return BoardResponse.of(board);
    }

    @Override
    public List<BoardResponse> getAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::of)
                .toList();
    }

    @Override
    public void saveBoard(BoardRequest request) {
        boardRepository.save(request.toEntity());
    }
    public String test(int i){
        if(i%2==0)return "짝";
        return "홀";
    }
}
