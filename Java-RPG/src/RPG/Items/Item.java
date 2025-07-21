package RPG.Items;

import RPG.Characters.Character;

public interface Item {

    String getName();
    String getDescription();

    void use(Character target);
}
