package com.clean.example.entrypoints.user;

import com.clean.example.core.domain.User;
import com.clean.example.core.usecase.user.FindAllUsersUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FindAllUsersEndpoint {

    private FindAllUsersUseCase helloWorldUseCase;

    public FindAllUsersEndpoint(FindAllUsersUseCase helloWorldUseCase) {
        this.helloWorldUseCase = helloWorldUseCase;
    }

    @RequestMapping(value = "/hello", method = GET)
    public List<UserDto> getAllUsers(){
        List<User> examples = helloWorldUseCase.findAllUsers();
        return toDtos(examples);
    }

    private List<UserDto> toDtos(List<User> allUsers) {
        return allUsers.stream()
                .map(user -> new UserDto(user.getFirstName(), user.getLastName()))
                .collect(Collectors.toList());
    }

}