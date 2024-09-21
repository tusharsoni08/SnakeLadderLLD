package models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    @Setter
    int position;

    String name;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }


}
