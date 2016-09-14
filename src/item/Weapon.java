package item;



public class Weapon implements Item{


        private String name;
        private String description;
        private int force;

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

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Sets the force points
         * @param force points
         */
        public void setForce(int force) {
            this.force = force;
        }

}
