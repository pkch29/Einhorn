package item;

/**
 * Weapon class for any weapon in the game.
 */
public class Weapon implements Item {

        public static final String HAND = "Hand";  // the name of the "weapon" hand of the player

        private String name;
        private String description;
        private int force;

    /**
     * Default constructor for a weapon
     * @param name name of the weapon
     * @param description description of the wepaon
     * @param force strength of the weapon
     */
        public Weapon(String name, String description, int force) {
            this.name = name;
            this.description = description;
            this.force = force;
        }

        @Override
        public String toString(){
            return name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getDescription() {
            return description;
        }

        /**
         * Gets the force points
         * @return force points
         */
        public int getForce() {
            return force;
        }

}
