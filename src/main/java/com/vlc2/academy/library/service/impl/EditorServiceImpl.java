package com.vlc2.academy.library.service.impl;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.entity.Editor;
import com.vlc2.academy.library.mapper.BookMapper;
import com.vlc2.academy.library.mapper.EditorMapper;
import com.vlc2.academy.library.repository.EditorRepository;
import com.vlc2.academy.library.repository.OrderRepository;
import com.vlc2.academy.library.service.EditorService;
import com.vlc2.academy.library.utility.GeneralUtility;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@RequiredArgsConstructor
public class EditorServiceImpl implements EditorService {

    private final EditorRepository repository;
    private final EditorMapper mapper;

    private final BookMapper bookMapper;
    private final OrderRepository orderRepository;


    // -----------------------------
    // Methods that operate on the level of database (CRUD Methods)
    // -----------------------------
    @Override
    public void save(Editor editor) {
        editor.setBooks(new ArrayList<>());
        repository.save(editor);
    }

    @Override
    public Editor findById(Integer id) {
        Optional<Editor> editor = repository.findById(id);
        return GeneralUtility.getValueOfAnOptional(editor, "editor", "id", id);
    }

    @Override
    public Editor findByName(String name) {
        Optional<Editor> editor = repository.findByName(name);
        return GeneralUtility.getValueOfAnOptional(editor, "editor", "name", name);
    }


    @Override
    public Editor findByEmail(String email) {
        Optional<Editor> editor = repository.findByEmail(email);
        return GeneralUtility.getValueOfAnOptional(editor, "editor", "email", email);

    }

    @Override
    public List<Editor> findAll() {
        return repository.findAll();
    }



    // Method that checks whether an editor is present or not by name
    @Override
    public Boolean existsByName(String name){
        return repository.findByName(name).isPresent();
    }


    // Method that checks whether an editor is present or not by email
    @Override
    public Boolean existsByEmail(String email){
        return repository.findByEmail(email).isPresent();
    }


    // Method that update the statistics about the average time of delivering an order of a specific editor
    // This method is called every time an order is delivered
    @Override
    public void setValuesAfterOrder(Integer days, Integer id) {
        Editor editor = repository.findById(id).get();
        // If this is the first order the average time is set as the time of this order
        if(editor.getAverageTimeDelivering() == null){
            editor.setAverageTimeDelivering(BigDecimal.valueOf(days).setScale(2, RoundingMode.HALF_UP));
        }
        // Otherwise the average time is set as a weighted average among the previous value and the time of this order
        else{
            Integer totalOrders = orderRepository.findByDeliveredIsTrueAndBookEditorName(editor.getName()).size();
            editor.setAverageTimeDelivering(
                    BigDecimal.valueOf((editor.getAverageTimeDelivering().doubleValue()*totalOrders+days)/(totalOrders+1))
                            .setScale(2, RoundingMode.HALF_UP));
        }
        // The record is then updated
        repository.save(editor);
    }

    /**
     * @param request
     * @return EditorResponse
     * General method for saving a new record
     */
    @Override
    public EditorResponse insert(EditorRequest request) {
        Editor editor = mapper.toEntity(request);
        save(editor);
        return mapper.toDto(editor, bookMapper);
    }

    /**
     * @param id
     * @return EditorResponse
     * General method for searching an editor by id
     */
    @Override
    public EditorResponse getEditorById(Integer id) {
        Editor editor = findById(id);
        return mapper.toDto(editor, bookMapper);
    }

    /**
     * @param name
     * @return EditorResponse
     * General method for searching an editor by name
     */
    @Override
    public EditorResponse getEditorByName(String name) {
        Editor editor = findByName(name);
        return mapper.toDto(editor, bookMapper);
    }

    /**
     * @param email
     * @return EditorResponse
     * General method for searching an editor by email
     */
    @Override
    public EditorResponse getEditorByEmail(String email) {
        Editor editor = findByEmail(email);
        return mapper.toDto(editor, bookMapper);
    }

    /**
     * @return List of EditorResponse
     */
    @Override
    public List<EditorResponse> getAllEditors() {
        return mapper.listToDto(findAll(), bookMapper);
    }


}
