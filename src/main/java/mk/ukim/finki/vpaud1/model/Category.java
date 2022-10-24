package mk.ukim.finki.vpaud1.model;

public class Category {

        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(String name) {
            this.name = name;
        }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
