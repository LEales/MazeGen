package model.Maps;

/**
 * @author André Eklund, Sebastian Helin, Viktor Näslund, Filip Örnling
 */

public class World1Maps {

    private Sprite[][] level11 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Goal},
            {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path},
            {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall},
            {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall}};

    private Sprite[][] level12 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Start},
            {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path},
            {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Goal}};

    private Sprite[][] level13 = {{Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
            {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path},
            {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
            {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
            {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
            {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
            {Sprite.Wall, Sprite.Goal, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Start}};

    private Sprite[][] level14 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
            {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
            {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
            {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
            {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
            {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
            {Sprite.Wall, Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Goal}};

    private Sprite[][] level15 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
            {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
            {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path},
            {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
            {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
            {Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
            {Sprite.Collectible, Sprite.Heart, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
            {Sprite.Collectible, Sprite.Goal, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Start}};

    /**
     * Returnerar en array som representerar en nivå i spelet.
     *
     * @return returnerar en array av siffror.
     */
    public Sprite[][] getLevel11() {
        return level11;
    }

    public Sprite[][] getLevel12 {
        return level12;
    }

    public Sprite[][] getLevel13() {
        return level13;
    }

    public Sprite[][] getLevel14() {
        return level14;
    }

    public Sprite[][] getLevel15() {
        return level15;
    }
}
