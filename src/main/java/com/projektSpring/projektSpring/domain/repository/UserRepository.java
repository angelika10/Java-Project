package com.projektSpring.projektSpring.domain.repository;

import com.projektSpring.projektSpring.domain.Library;
import com.projektSpring.projektSpring.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    Map<Integer, User> users = new HashMap<>();

    public void createUser(String name){

        int newId = getNewId();

        User newUser = new User(newId, name);
        newUser.setId(getNewId());
        users.put(newUser.getId(), newUser);
    }


    public void createLibrary(User user) {
        user.setId(getNewId());
        users.put(user.getId(), user);
    }

    public List<User> showAllUsers(){
        return new ArrayList<>(users.values());
    }


    public User getUser(Integer id){
        return users.get(id);
    }


    @PostConstruct
    public void build() {
        createUser("Basia");
        createUser("Zosia");
    }

    @PostConstruct
    public void init() {

    }


    public int getNewId(){
        if(users.isEmpty()){
            return 0;
        }else{
            Integer integer = users.keySet().stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
    }

    public void update(User user) {
        users.put(user.getId(),user);
    }
}
