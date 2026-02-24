package com.vlc2.academy.library.command;

import com.vlc2.academy.library.dto.request.EditorRequest;
import com.vlc2.academy.library.dto.response.EditorResponse;
import com.vlc2.academy.library.exception.custom.InvalidEditorException;
import com.vlc2.academy.library.exception.custom.InvalidEmailException;
import com.vlc2.academy.library.exception.custom.NullInsertException;
import com.vlc2.academy.library.service.EditorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Getter
@RequiredArgsConstructor
public class EditorCommand {

    private final EditorService service;
    private final EditorRequest request;


    public EditorResponse execute() {
        validate();
        return service.save(request);
    }

    public void validate(){
        if(request.getName() == null || request.getName().isBlank()){
            throw new NullInsertException("You must provide a name");
        }
        if(request.getEmail() == null || request.getEmail().isBlank()){
            throw new NullInsertException("You must provide an email");
        }
        if(!request.getEmail().matches("[\\w.-]+@[\\w.-]+\\.[\\w.-]+")){
            throw new InvalidEmailException("Email addresses must have a local part, the '@' symbol and a domain");
        }
        if(service.existsByName(request.getName())){
            throw new InvalidEditorException(String.format("There's already an editor named %s",request.getName()));
        }
        if(service.existsByEmail(request.getEmail())){
            throw new InvalidEmailException(String.format("There's already an email named %s",request.getEmail()));
        }
    }

}
